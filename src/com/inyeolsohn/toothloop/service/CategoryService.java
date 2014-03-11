package com.inyeolsohn.toothloop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inyeolsohn.toothloop.dao.Category;
import com.inyeolsohn.toothloop.dao.CategoryDao;

@Service("categoryService")
public class CategoryService {

	private CategoryDao categoryDao;

	@Autowired
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	@Transactional
	public void create(Category category) {
		// TODO Auto-generated method stub
		categoryDao.create(category);
	}
	
	@Transactional
	public boolean exist(Category category) {
		/*
		 * return categoryDao.exist(category);
		 */
		return categoryDao.exists(category);

	}

	@Transactional
	public void checkChildren(int parentId) {
		categoryDao.checkChildren(parentId);
	}

	@Transactional
	public boolean delete(Category category) {
		categoryDao.moveBefore(category.getParent(), category.getSort());
		return categoryDao.delete(category.getId());
	}


	@Transactional
	public List<Category> createCMS() {
		return categoryDao.getCMS();
	}

	@Transactional
	public Category getCategory(int id) {
		return categoryDao.getCategory(id);
	}

	@Transactional
	public void notifyParent(Category category, String commandName) {
		categoryDao.notifyParent(category, commandName);
	}

	@Transactional
	public int getHighest(int parent) {
		// TODO Auto-generated method stub
		return categoryDao.findHighest(parent)+1;
	
	}
	
	@Transactional
	public void update(Category category)
	{
		categoryDao.update(category);
	}
	
	@Transactional
	public boolean killDescendent(Category category)
	{
		return categoryDao.killDescendent(category);
	}

}
