package stock;

import java.util.ArrayList;
import java.util.Scanner;

public class StockMain {
	Scanner scanner = new Scanner(System.in);
	// 종목 담아두는 배열
	private ArrayList<StockVO> arStock = new ArrayList<StockVO>();
	private int choice = 0; // 선택지를 받아주는 변수
	private int priceAsset; // 모든 주식 매입금액
	private int nowAsset; // 모든 주식 평가금액

	// view 단 역할
	public void index() {
		choice = 0; // 선택을 받아주는 변수
		do {
			System.out.println("==보유 주식 등록 시스템==");
			System.out.println("1. 보유주식 등록");
			System.out.println("2. 보기");
			System.out.println("3. 삭제하기");
			System.out.println("4. 수정하기");
			System.out.println("5. 나가기");
			System.out.print("입력하세요 : ");
			choice = scanner.nextInt();
			scanner.nextLine(); // 혹시모를 엔터키 흡수
			if (choice == 5) {
				break;
			}
			switch (choice) {
			case 1: // 삽입
				insert();
				break;
			case 2: // 보기
				view();
				break;
			case 3: // 삭제
				delete();
				break;
			case 4: // 수정
				update();
				break;
			default:
				System.out.println("잘못입력하셨습니다");
				break;
			}

		} while (true);
	}

	// # 삽입
	public void insert() {
		
		System.out.print("종목 명 : ");
		String name = scanner.nextLine().trim();
		System.out.print("구매 단가 : ");
		int pPrice = scanner.nextInt();
		scanner.nextLine();
		System.out.print("현재 단가 : ");
		int cPrice = scanner.nextInt();
		scanner.nextLine();
		System.out.print("보유 주식 수 : ");
		int ownStocks = scanner.nextInt();
		scanner.nextLine();

		StockVO vo = new StockVO();
		vo.setName(name);
		vo.setpPrice(pPrice);
		vo.setcPrice(cPrice);
		vo.setOwnStocks(ownStocks);
		vo.setTotalpPrice(vo.getOwnStocks() * vo.getpPrice());
		vo.setTotalcPrice(vo.getOwnStocks() * vo.getcPrice());
		vo.setProfitRatio( (float)(vo.getcPrice() - vo.getpPrice()) / vo.getpPrice() * 100 );
		
		
		if(StockDAO.insert(vo)) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		
		

	}

	// # 보기
	public void view() {
		ArrayList<StockVO> list = StockDAO.select();
		if(list == null || list.size() == 0) {
			System.out.println("데이터 비어있음");
		}else{
			for (StockVO stockVO : list) {
				System.out.println(stockVO);
			}
		}
	}


	// # 삭제
	public void delete() {
		System.out.print("삭제할 번호를 입력하세요");
		choice = scanner.nextInt();
		scanner.nextLine();
		if(StockDAO.delete(choice)) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
		
	}

	// # 수정
	public void update() {
		choice = 0;					// 선택을 담아주는 변수
		boolean check = false;		// 종목있는지 확인해주는 변수
		ArrayList<StockVO> list = StockDAO.select();
		System.out.print("수정하실 번호를 입력하세요 : ");
		choice = scanner.nextInt();
		scanner.nextLine();
		
//		종목이 있는 지 확인하기
		for (int i = 0; i < list.size(); i++) {
//			확인이 됐으면 수정할 내용을 받아서 DAO 메소드로 넘겨주기
			if(list.get(i).getIdx() == choice) {
				System.out.println(list.get(choice-1));
				System.out.print("종목 명 : ");
				String name = scanner.nextLine().trim();
				System.out.print("구매 단가 : ");
				int pPrice = scanner.nextInt();
				scanner.nextLine();
				System.out.print("현재 단가 : ");
				int cPrice = scanner.nextInt();
				scanner.nextLine();
				System.out.print("보유 주식 수 : ");
				int ownStocks = scanner.nextInt();
				scanner.nextLine();
				StockDAO.update(choice , name, pPrice, cPrice, ownStocks);
				check  = true;
				break;
			}
		}
		String msg = check? "성공" : "존재하지 않는 종목입니다";
		System.out.println(msg);
	}

}
