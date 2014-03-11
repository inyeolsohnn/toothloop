package com.inyeolsohn.toothloop.dao;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class Category {
	
	private int id;
	

	private String name;
	
	private String content;
	

	private String author;
    
	@NumberFormat(style = Style.NUMBER)
	private int sort;
	
	@NumberFormat(style = Style.NUMBER)
	private int parent;

	private String children;

	private String showing;

	private String editor;
	
	private String lastmodified;
	
	private String createdon;

	private String type;
	public Category() {
	}

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
	}

	public Category(int id, int parent, String name, String showing, int sort,
			String children, String type) {
		super();
		this.id=id;
		this.parent = parent;
		this.name = name;
		this.showing = showing;
		this.sort = sort;
		this.children = children;
		this.type=type;
		this.content="";
		this.lastmodified="";
		this.createdon="";
		this.editor="";
	}
	public Category(int id, int parent, String name, String showing, int sort,
			String children) {
		super();
		this.id=id;
		this.parent = parent;
		this.name = name;
		this.showing = showing;
		this.sort = sort;
		this.children = children;
		this.content="";
		this.lastmodified="";
		this.createdon="";
		this.editor="";
		
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor()
	{
		return this.author;
	}
	public void setAuthor(String author)
	{
		this.author=author;
	}
	public void setEditor(String editor)
	{
		this.editor=editor;
	}
	public String getEditor()
	{
		return editor;
	}
	
	public String getShowing() {
		return showing;
	}

	public void setShowing(String showing) {
		this.showing = showing;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public int getSort() {
		return sort;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content=content;
	}
	public String getLastModified() {
		return lastmodified;
	}

	public void setLastModified(String lastmodified) {
		this.lastmodified = lastmodified;
	}

	public String getCreatedon() {
		return createdon;
	}

	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type=type;
	}
	
	

	public void setSort(int sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "Category [parent=" + parent + ", name=" + name +  ", sort=" + sort + "]";
	}

	

}
