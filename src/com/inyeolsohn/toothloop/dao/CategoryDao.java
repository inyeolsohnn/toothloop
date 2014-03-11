package com.inyeolsohn.toothloop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/*List of functions involving category db
 * 
 * 1. create category
 * 2. create menu
 * 	-find categories that doesn't have parents (super categories) create global menu out of it 
 * 	-find all direct children of parents
 *  -continue this until there is not a single row with 'yes' in parents column
 *  -List of helper methods: 3.4.5
 *  -moved to front end 'menufilter'
 *  -instead became a helper method that returns all rows
 * 3. check existence
 * 4. check children
 * 5. check parent
 * 6. Resort
 * 	- done through java and simple sql (efficiency?)
 *  - in case of change from 'sort 5' to 'sort 1' *  
 * 7. delete
 * 8. return selected category
 * 
 * 
 * 
 * 
 * */
@Component("categoryDao")
public class CategoryDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}


	public boolean create(Category category) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		moveAfter(category.getParent(), category.getSort());
		int rightSort = findOrder(category.getParent(), category.getSort());
		params.addValue("parent", category.getParent());
		params.addValue("name", category.getName());
		params.addValue("showing", category.getShowing());
		params.addValue("content", category.getContent());
		params.addValue("sort", rightSort);
		params.addValue("children", category.getChildren());
		params.addValue("type", category.getType());
		params.addValue("author", category.getAuthor());
		params.addValue("editor", category.getEditor());
		return jdbc
				.update("insert into category (parent, name, showing, sort, children,  author, content, type, editor ) values (:parent, :name, :showing,  :sort, :children, :author, :content, :type, :editor)",
						params) == 1;

	}


	public void moveAfter(int parentId, int sortInput) {
		// TODO Auto-generated method stub
		// currently bugged 12/02/2014 14:30
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("parent", parentId);
		params.addValue("sort", sortInput);
		jdbc.update(
				"UPDATE category set sort=sort+1 WHERE parent=:parent and sort>=:sort",
				params);

	}

	
	public void moveBefore(int parentId, int currentSort) {
		// TODO Auto-generated method stub
		// currently bugged 12/02/2014 14:30
	
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("parent", parentId);
		params.addValue("sort", currentSort);
		jdbc.update(
				"UPDATE category set sort=sort-1 WHERE parent=:parent and sort>=:sort",
				params);

	}


	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.update("DELETE FROM category WHERE id=:id", params) == 1;
	}

	public boolean exists(Category category) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(
				category);
		return jdbc
				.queryForObject(
						"SELECT  COUNT(*) FROM category WHERE id=:id and parent=:parent and name=:name",
						params, Integer.class) == 1;
	}


	public Category getCategory(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.queryForObject("select * from category where id=:id",
				params, new RowMapper<Category>() {

					public Category mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Category category = new Category();
						category.setId(rs.getInt("id"));
						category.setName(rs.getString("name"));
						category.setParent(rs.getInt("parent"));
						category.setShowing(rs.getString("showing"));
						category.setSort(rs.getInt("sort"));
						category.setChildren(rs.getString("children"));
						category.setContent(rs.getString("content"));
						category.setType(rs.getString("type"));
						return category;
					}

				});
	}


	public List<Category> getCMS() {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", 1);

		List<Category> resultList = new ArrayList<Category>();

		Category root = jdbc.queryForObject(
				"select * from category where id=:id", params,
				BeanPropertyRowMapper.newInstance((Category.class)));

		resultList = appendChildren(root, resultList, -1);

		return resultList;

	}


	public void checkChildren(int parentId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("parent", parentId);

		if (jdbc.queryForObject(
				"select count(*) from category where parent=:parentId", params,
				Integer.class) == 0) {
			jdbc.update("update category set children='no' where id=:parentId",
					params);
		} else {
			jdbc.update(
					"update category set children='yes' where id=:parentId",
					params);
		}

	}

	// //////////////////////
	/***** Helper methods ****/
	// //////////////////////

	private List<Category> appendChildren(Category currentParent,
			List<Category> resultList, int counter) {
		counter++;
		if (currentParent.getChildren().equals("no")) {
			resultList.add(new CMSCategory(currentParent, counter));
			return resultList;
		} else {
			resultList.add(new CMSCategory(currentParent, counter));
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("parentID", currentParent.getId());
			List<Category> childrenList = jdbc
					.query("select * from category where parent=:parentID order by sort asc",
							param,
							BeanPropertyRowMapper.newInstance((Category.class)));
			for (int i = 0; i < childrenList.size(); i++) {
				resultList = appendChildren(childrenList.get(i), resultList,
						counter);
			}

			return resultList;
		}

	}


	private int findOrder(int parentID, int sortInput) {
		int input = sortInput;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("parent", parentID);
		int currentHighest = 0;
		try {
			currentHighest = jdbc.queryForObject(
					"select MAX(sort) from category WHERE parent=:parent",
					params, Integer.class);
		} catch (Exception e) {

		}
		if (currentHighest <= 0)
			return 1;
		else if (input > currentHighest) {
			return currentHighest + 1;
		} else {
			return input;
		}
	}
	
	public int findHighest(int parentID) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("parent", parentID);
		int currentHighest = 0;
		try {
			currentHighest = jdbc.queryForObject(
					"select MAX(sort) from category WHERE parent=:parent",
					params, Integer.class);
		} catch (Exception e) {
		
		}
		return currentHighest;
	}
	
	
	public void notifyParent(Category category, String commandName) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("parent", category.getParent()); // id of parent
		// TODO Auto-generated method stub
		if (commandName.equals("create")) {
			jdbc.update("update category set children='yes' where id=:parent",
					params);

		} else if (commandName.equals("delete")) {
			if (jdbc.queryForObject(
					"select count(*) from category where parent=:parent",
					params, Integer.class) == 1) {
				jdbc.update(
						"update category set children='no' where id=:parent",
						params);
			}

		}

	}
	
	public boolean killDescendent(Category category){
		boolean report=false;
		moveBefore(category.getParent(), category.getSort());
		List<Category> resultList = new ArrayList<Category>();
		resultList = appendChildren(category, resultList, 0);
		Iterator<Category> iter = resultList.iterator();
	
		while(iter.hasNext())
		{
			Category current = iter.next();
			int currentId = current.getId();
			report=delete(currentId);
					}
		return report;
	}
	public void update(Category category) {
		// TODO Auto-generated method stub
		Category updated = category;
		Category original = getCategory(category.getId());
		updated.setSort(findOrder(updated.getParent(), updated.getSort())-1);
		if(updated.getSort()<=0)
			updated.setSort(1);
			
		
		updateSort(updated, original);
		updateRest(updated, original);
	}

	private void updateRest(Category updated, Category original) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("content", updated.getContent());
		param.addValue("showing", updated.getShowing());
		param.addValue("id", original.getId());
		param.addValue("parent", updated.getParent());
		param.addValue("name", updated.getName());
		param.addValue("sort", updated.getSort());
		param.addValue("editor", updated.getEditor());
		param.addValue("lastmodified", updated.getLastModified());
		jdbc.update(
				"update category set parent=:parent, name=:name, showing=:showing, sort=:sort, content=:content, editor=:editor, lastmodified=:lastmodified where id=:id",
				param);

	}

	private void updateSort(Category updated, Category original) {
		// TODO Auto-generated method stub
		int updatedSort = updated.getSort();
		int originalSort = original.getSort();
		int parentId = original.getParent();
		if (updatedSort == originalSort) {

		} else if (updatedSort > originalSort) // moving category upwards
		{
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("originalSort", originalSort);
			param.addValue("updatedSort", updatedSort);
			param.addValue("parent", parentId);
			jdbc.update(
					"update category set sort=sort-1 where parent=:parent and sort>:originalSort and sort<=:updatedSort",
					param);
		} else if (updatedSort < originalSort) // moving category down wards
		{
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("originalSort", originalSort);
			param.addValue("updatedSort", updatedSort);
			param.addValue("parent", parentId);
			jdbc.update(
					"update category set sort=sort+1 where parent=:parent and sort<:originalSort and sort>=:updatedSort ",
					param);
		}

	}

}
