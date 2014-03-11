package com.inyeolsohn.toothloop.controllers;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.inyeolsohn.toothloop.dao.Category;
import com.inyeolsohn.toothloop.dao.User;

import com.inyeolsohn.toothloop.service.CategoryService;
import com.inyeolsohn.toothloop.service.UsersService;

@Controller
public class AdminController {

	private UsersService usersService;
	private CategoryService categoriesService;

	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoriesService = categoryService;
	}

	@RequestMapping("/admin")
	public String showAdmin(Model model) {

		return "admin";
	}

	@RequestMapping(value = "/mycms")
	public String showMyCMS(ModelMap modelMap) {
		List<Category> category = categoriesService.createCMS();
		modelMap.put("cmscategory", category);
		modelMap.put("category", new Category());
		return "mycms";
	}

	@RequestMapping(value = "/createcategory", method = RequestMethod.POST)
	public String createCategory(@Valid Category category,
			BindingResult result, Principal principal, ModelMap model) {
		if (result.hasErrors()) {
			return "errors";
		}
		category.setAuthor(principal.getName());
		categoriesService.notifyParent(category, "create");
		if(category.getSort()==0)
		{
			category.setSort(categoriesService.getHighest(category.getParent()));
		}
		categoriesService.create(category);

		return "admin";
	}

	@RequestMapping(value = "/editexistingcategory", method = RequestMethod.POST)
	public String editExistingCategory(@Valid Category category,
			BindingResult result, Principal principal, ModelMap model) {
		
		
		if(result.hasErrors()){
			int id = category.getId();
			Category template = categoriesService.getCategory(id);
			List<ObjectError> errors	= result.getAllErrors();
			for(ObjectError error: errors){
				System.out.println(error.getDefaultMessage());
				}
				model.put("categorytemplate", category);
				
				return "editentry";
			}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String formattedDate = sdf.format(date);		
	    Category updatedCategory= category;	
	    updatedCategory.setEditor(principal.getName());
	    updatedCategory.setLastModified(formattedDate);
	    categoriesService.update(updatedCategory);
		return "admin";
	}

	@RequestMapping(value = "deletecategory", method = RequestMethod.POST)
	public String deleteCategory(@Valid Category category,
			BindingResult result, Principal principal, Model model) {
		int id = category.getId();
		Category currentCategory = categoriesService.getCategory(id);
		categoriesService.notifyParent(currentCategory, "delete");	
		if(currentCategory.getChildren().equals("yes")){		
				categoriesService.killDescendent(currentCategory);
			}
		else{
		categoriesService.delete(currentCategory);}
		return "admin";
	}

	@RequestMapping(value = "/newcategory", method = RequestMethod.POST)
	public String newCategory(@Valid Category category, BindingResult result,
			Principal principal, Model model) {
		
		int parentId = category.getParent();
		Category template = categoriesService.getCategory(parentId);
		
		template.setAuthor(principal.getName());
		model.addAttribute("categorytemplate", template);
		return "newentry";

	}

	@RequestMapping(value = "/editcategory", method = RequestMethod.POST)
	public String editCategory(@Valid Category category, BindingResult result,
			Principal principal, ModelMap model) {
		int id = category.getId();
		Category template = categoriesService.getCategory(id);
		model.put("categorytemplate", template);
		model.put("category", new Category());

		return "editentry";

	}

	

}
