package queue;

import java.util.ArrayList;


public class QueueModule {
	int size = 0; // 데이터의 사이즈
	int rear = 0; // 추가될 때 마다 증가하는 수
	int front = 0; // 데이터가 제거될 때마다 1식 증가
	ArrayList<Object> queue = new ArrayList<Object>();

	public QueueModule(int size) {
		this.size = size;
	}

	// #1 데이터 추가 add
	void add(Object data) {
		// 중복검사
		if (queue.contains(data)) {
			System.out.println("[" + data + "] 는 중복된 데이터 입니다.");
		} else {
			if (rear >= size) {
				System.out.println("overflow!");
			} else {
				queue.add(data);
				rear++;
				System.out.println("[" + data + "] 추가 완료");
			}
		}
		view();
	}

	// #2 데이터 보기
	void view() {
		// 데이터 비어있는지 유무 검사
		if (rear != 0 || front != rear) {
			System.out.print("queue => ");
			for(int i = front ; i < queue.size() ; i ++) {
				System.out.print(queue.get(i)+ " ");
			}
			System.out.println();
		} else {
			System.out.println("저장된 데이터 없음.");
		}
	}

	// #3 데이터 추출
	void remove() {
		// 데이터 비어있는지 유무
		if (rear == 0 || rear == front) {
			System.out.println("저장된 데이터 없음.");
		} else {
			Object data = queue.get(front);
			front++;
			System.out.println("[" + data + "] 제거 완료");
			view();
		}
	}
	


}
