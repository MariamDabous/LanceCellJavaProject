package com.rrmm.lancecell.models;

public enum Language {
	Java("JAVA"),
	CPlusPlus("C++"),
	Python("Python"),
	Ruby("Ruby"),
	CSharp("C#"),
	JavaScript("JavaScript");
	private String name ;
	
	Language(String name) {
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
