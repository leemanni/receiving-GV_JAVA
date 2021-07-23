package com.home.exercise;

import java.util.Objects;

public class Empolyee implements Comparable<Empolyee> {
	private String name;
	private int age;
	private String department;
	
	
	
	public Empolyee(String name, int age, String department) {
		this.name = name;
		this.age = age;
		this.department = department;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return name + "( " + age + ", " + department + ")";
	}


	@Override
	public int hashCode() {
		return Objects.hash(age, department, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empolyee other = (Empolyee) obj;
		return age == other.age && Objects.equals(department, other.department) && Objects.equals(name, other.name);
	}


	@Override
	public int compareTo(Empolyee o) {
		if(this.name.equals(o.name)) {
			return o.age-this.age;
		}else if (this.department.equals(o.department)) {
			return this.name.compareTo(o.name);
		}else {
			return this.department.compareTo(o.department);
		}
		
//		return this.name.compareTo(o.name);
	}
	

	
	
	
}
