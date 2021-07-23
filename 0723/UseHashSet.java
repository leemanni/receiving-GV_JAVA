package com.home.exercise;

import java.util.HashSet;
import java.util.Iterator;

public class UseHashSet {
	public static void main(String[] args) {
		HashSet<Empolyee> hashSet = new HashSet<Empolyee>();
		hashSet.add(new Empolyee("김철수",38, "인사팀"));
		System.out.println(hashSet);
		hashSet.add(new Empolyee("함덕춘",44, "공무팀"));
		System.out.println(hashSet);
		hashSet.add(new Empolyee("김철수",38, "관리팀"));
		System.out.println(hashSet);
		hashSet.add(new Empolyee("양선아",27, "관리팀"));
		System.out.println(hashSet);
		hashSet.add(new Empolyee("박기훈",29, "인사팀"));
		System.out.println(hashSet);
		hashSet.add(new Empolyee("박기훈",29, "인사팀"));
		System.out.println(hashSet);
		Iterator<Empolyee> iter = hashSet.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
			
		}
		
		
	}
}
