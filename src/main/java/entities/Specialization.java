package com.softserver.todolist.entities;

public enum Specialization {
	Developer("Developer"),
	Architect("Architect"), 
	ProjectManager("Project Manager"),
	Test("Test");
	
	private String title;
	
	Specialization(String title){
		this.title = title;
	}
	
	@Override
	public String toString() {
		return this.title;
	}
}
