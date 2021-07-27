package com.leemani.ThreadPra.last;

public class Student extends Thread{
	public Student(String name) {
		super(name);
	}
	
	
	@Override
	public void run() {
		try {
			String title = LibraryTest.library.lendBook();
			if(title == null) {
				return;
			}
			sleep(3000);
			LibraryTest.library.returnBook(title);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IndexOutOfBoundsException e) {
			System.out.println("책을 빌리지 못했습니다.");
		}
	}
}
