package com.leemani.ThreadPra.last;

import java.util.ArrayList;

public class Library {
	public ArrayList<String> bookList = new ArrayList<String>();
	public Library() {
		bookList.add("다빈치 코드");
		bookList.add("해리포터 - 아즈카반의 죄수");
		bookList.add("창문을 넘어 도망친 100세 노인");
//		bookList.add("개미");
//		bookList.add("천사와 악마");
//		bookList.add("너의 이름은");
		}
	
	// 도서 대여
	public synchronized String lendBook() {
		Thread thread = Thread.currentThread();
		
		if(bookList.size() == 0) {
			try {
				
				System.out.println("wait..");
				wait();
				System.out.println("end");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String book =  bookList.remove(0);
		System.out.println(  thread.getName()+ " : "+book+" 대여");
		return book;
		
	}
	
	// 도서 반납
	public synchronized void returnBook(String book) {
		Thread thread = Thread.currentThread();
		bookList.add(book);
		notifyAll();
		System.out.println(  thread.getName()+ " : "+book+" 반납");
		
	}
	
	
}
