package com.inyeolsohn.toothloop.dao;

public class CMSCategory extends Category {
	private int heritage;

	public CMSCategory()
	{
		
	}
	public CMSCategory(Category currentParent, int counter) {
		super(currentParent.getId(), currentParent.getParent(), currentParent
				.getName(), currentParent.getShowing(), currentParent
				.getSort(), currentParent.getChildren(), currentParent.getType());
		this.heritage=counter;
	}

	public int getHeritage() {
		return heritage;
	}

	public void setHeritage(int heritage) {
		this.heritage = heritage;
	}

}
