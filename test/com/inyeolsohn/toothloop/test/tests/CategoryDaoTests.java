package com.inyeolsohn.toothloop.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;
import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inyeolsohn.toothloop.dao.CategoryDao;
import com.inyeolsohn.toothloop.dao.Category;
import com.inyeolsohn.toothloop.service.CategoryService;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:com/inyeolsohn/toothloop/test/config/datasource.xml",
		"classpath:com/inyeolsohn/toothloop/config/dao-context.xml",
		"classpath:com/inyeolsohn/toothloop/config/security-context.xml",
		"classpath:com/inyeolsohn/toothloop/config/service-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryDaoTests {
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		/*
	public Category(int id, String name, String content, String author,
			int sort, int parent, String children, String showing,
			String editor, String lastmodified, String createdon, String type) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.author = author;
		this.sort = sort;
		this.parent = parent;
		this.children = children;
		this.showing = showing;
		this.editor = editor;
		this.lastmodified = lastmodified;
		this.createdon = createdon;
		this.type = type;
	}*/
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String formattedDate = sdf.format(date);
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.update("truncate table category");
		Category rootCategory = new Category(1, "Root Category", "", "tester",
				1, 0, "yes", "yes", "tester", formattedDate, formattedDate,
				"category");
		
		
		Category first = new Category(2, "1st Category", "", "tester",
				1, 1, "no", "yes", "tester", formattedDate, formattedDate,
				"category");
		Category second = new Category(3, "2nd Category", "", "tester",
				2, 1, "no", "yes", "tester", formattedDate, formattedDate,
				"category");
		Category third = new Category(4, "3rd Category", "", "tester",
				3, 1, "yes", "yes", "tester", formattedDate, formattedDate,
				"category");
		Category fourth = new Category(5, "4th Category", "", "tester",
				4, 1, "no", "yes", "tester", formattedDate, formattedDate,
				"category");
		
		Category sub1 = new Category(6, "sub1 Category", "", "tester",
				1, 4, "no", "yes", "tester", formattedDate, formattedDate,
				"category");
		Category sub2 = new Category(7, "sub2 Category", "", "tester",
				2,4, "no", "yes", "tester", formattedDate, formattedDate,
				"category");
		categoryService.create(rootCategory);
		categoryService.create(first);
		categoryService.create(second);
		categoryService.create(third);
		categoryService.create(fourth);
		categoryService.create(sub1);
		categoryService.create(sub2);

	}

	@Test
	public void testCreateCategory() {
		assertTrue(categoryService.killDescendent(categoryService
				.getCategory(4)));
	}

}
