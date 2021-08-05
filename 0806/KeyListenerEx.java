package com.leemanni.exercise;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public 
class KeyListenerEx extends JFrame
{
	public KeyListenerEx() 
	{
		setTitle("KeyListener");
		setBounds(500, 250, 400, 450);
		
		addKeyListener(new KeyListener() 
		{
			boolean flag = false;
			@Override
			public void keyTyped(KeyEvent e) 	// 키보드가 눌릴때
			{
				// getKeyCode() => 해당 키보드 값을 int 로 반환하고 그 값은 상수로 준비 돼 있다.
//								(단, 대소문자를 구분하지 않는다.)
//				if(e.getKeyCode() == KeyEvent.VK_A);
//				{
//					System.out.println("AAAA");
//				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) // 키보드가 눌렀다 뗴질때
			{
//				#2-1 => ctrl 을 누른 뒤 true로 바꾸고 's' 눌리자 마자 저장 이 됨
				if(flag && e.getKeyCode() == KeyEvent.VK_S)
				{
					System.out.println("저장 완료");
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) 	// 키보드를 누르고 있을 때
			{
//				#2 단축키를 지정할 수 있다. => ctrl 을 넘김 true
				if(e.getModifiersEx() ==128 )
				{
					System.out.println("in");
					flag = true;
				}
				
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		KeyListenerEx window = new KeyListenerEx();
		
		
	}
}
