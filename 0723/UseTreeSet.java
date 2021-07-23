package com.home.exercise;

import java.util.TreeSet;
import java.util.Iterator;

public class UseTreeSet {
	public static void main(String[] args) {
		TreeSet<Empolyee> treeSet = new TreeSet<Empolyee>();
		treeSet.add(new Empolyee("김철수",38, "인사팀"));
		System.out.println(treeSet);
		treeSet.add(new Empolyee("함덕춘",44, "공무팀"));
		System.out.println(treeSet);
		treeSet.add(new Empolyee("김철수",38, "관리팀"));
		System.out.println(treeSet);
		treeSet.add(new Empolyee("양선아",27, "관리팀"));
		System.out.println(treeSet);
		treeSet.add(new Empolyee("박기훈",29, "인사팀"));
		System.out.println(treeSet);
		treeSet.add(new Empolyee("박기훈",29, "인사팀"));
		System.out.println(treeSet);
		Iterator<Empolyee> iter = treeSet.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
			
		}
		
		
	}
}
