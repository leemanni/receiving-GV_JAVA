package com.leemani.ThreadPra.last;

public class LibraryTest {
	public static Library library = new Library();
	
	public static void main(String[] args) {
		Student student1 = new Student("홍길동");
		Student student2 = new Student("임꺽정");
		Student student3 = new Student("장길산");
		Student student4 = new Student("일지매");
		Student student5 = new Student("이몽룡");
		
		student1.start();
		student2.start();
		student3.start();
		student4.start(); 
		student5.start();
	}
}
