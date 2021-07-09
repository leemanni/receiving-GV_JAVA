package stack;

import java.util.ArrayList;

public class StackModule {
	
	// 저장공간
	ArrayList<Object> stack = new ArrayList<Object>();
	// 스택의 사이즈를 저장하는 
	int size = 0;
	// 스택의 인덱스 결과와 데이터 정개수를 알려주는 변수
	int top = 0; //  데이터 입력시 +1 , 제거시 -1
	
	public StackModule(int size) {
		this.size = size;
	}
	
//	 #1 데이터 입력 => push()
	void push(Object data) {
		//중복체크
		if (!(stack.contains(data))) {
			// overflow check!
			if (size > top) { //  Not overflow
				stack.add(data);
				top ++;
			}else { // overflow
				System.out.println("overflow! [" + data +"] 를 데이터로 추가할 수 없음.");
			}
			
		}else { // 중복인 경우
			System.out.println("중복 이미  [" + data + "] 가(이) 자료에 있습니다.");
		}
		view(); // 잘 들어갔는지 보여주기
	}
	
	
	//#2 보기 
	void view() {
		//데이터가 없을경우
		if (top == 0) {
			System.out.println("저장된 데이터가 없습니다.");
		}else {
			System.out.print("stack=>  ");
			for(Object i : stack) {
				System.out.print(i + " ");
			}
			System.out.println(); // 한 줄 띄어주기 위함!
		}
	}
	
	//#3 출력하기
	void pop() {
		//데이터 없을경우
		if (top == 0) {
			System.out.println("저장된 데이터가 없습니다.");
		}else {
			Object data = stack.get(top-1);
			stack.remove(top-1);
			top --;
			System.out.println(data + "가(이) 추출 완료되었습니다.");
			view();
		}
		
	}
}
