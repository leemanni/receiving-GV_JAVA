package tree;

public class BinaryTree {
	int data;
	BinaryTree left;// 자바에서는 주소를 받으려면 자료형 자체를 클래스로 해버리면 주소가 기억돼
	BinaryTree right;

	public BinaryTree(int data) {
		this.data = data;
	}

	void insert(int data) {
		// 왼쪽에 ? 오른쪽에
		if (this.data > data) {// 왼쪽에 데이터 삽입
			// 왼쪽에 데이터 있는지 유무 검사
			if (left == null) {// 데이터 없음
				System.out.println(+this.data +"왼쪽에 [" + data + "] 삽입 가능");
				left = new BinaryTree(data);
				System.out.println(+this.data +"왼쪽에 [" + data + "] 삽입 완료");
			} else {// 데이터 있음
				System.out.println("부모 [" + this.data + "] 의 왼쪽에 [" + data + "] 삽입불가" + " 왼쪽 노드로 이동");
				this.left.insert(data);

			}

		} else if (this.data < data) {
			// 오른쪽에 데이터 있는지 유무 검사
			if (right == null) {// 데이터 없음
				System.out.println(+this.data +"오른쪽에 [" + data + "] 삽입 가능");
				right = new BinaryTree(data);
				System.out.println(+this.data +"오른쪽에 [" + data + "] 삽입 완료");
			} else {// 데이터 있음
				System.out.println("부모 [" + this.data + "] 의 오른쪽에 [" + data + "] 삽입불가" + " 왼쪽 노드로 이동");
				this.right.insert(data);

			}
		}else {
			System.out.println("트리에 존재하지 않거나 중복된 데이터 입니다.");
		}
	}
	
	void inorder() {
		if (this.left != null) {
			left.inorder();
		}
		System.out.print(this.data+ " ");
		if (this.right != null) {
			right.inorder();
		}
	}
		
		void preorder() {
			
			System.out.print(this.data+ " ");
			if (this.left != null) {
				left.preorder();
			}
			if (this.right != null) {
				right.preorder();
			}
		}
		
		void postorder() {
			if (this.left != null) {
				left.postorder();
			}
			if (this.right != null) {
				right.postorder();
			}
			System.out.print(this.data+ " ");
		}
			
		
			
	
	
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(12);
		System.out.println(root.right);
		root.insert(6);
		System.out.println("====================");
		root.insert(20);
		System.out.println("====================");
		root.insert(3);
		System.out.println("====================");
		root.insert(25);
		System.out.println("====================");
		root.insert(10);
		System.out.println("====================");
		root.insert(15);
		System.out.println("====================");
		root.inorder();
		System.out.println("\n====================");
		root.preorder();
		System.out.println("\n====================");
		root.postorder();
	}
	
	
	
	

}
