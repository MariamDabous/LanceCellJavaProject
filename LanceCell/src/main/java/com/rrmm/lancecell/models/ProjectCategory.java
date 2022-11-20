package com.rrmm.lancecell.models;

public enum ProjectCategory {
	Social("Social Media"),
	PersonaLWeb("Personal Web Page"),
	News("News"),
	E_commerce("E Commerce"),
	Blog("Blog"),
	Online_Store("Online Store"),
	Nonprofit_Org("Nonprofit Organization"),
	Internet_Forum("Internet Forum"),;
	private String name ;
	
	ProjectCategory(String name) {
		this.name=name;
	}
	
	public String displayName() {
		return name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
