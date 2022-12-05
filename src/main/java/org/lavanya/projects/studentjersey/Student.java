package org.lavanya.projects.studentjersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	private String name;
	private int rollno;
	private String branch;
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}	
}
