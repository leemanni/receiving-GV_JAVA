package stock;

import java.util.ArrayList;
import java.util.Scanner;

public class StockDAO {
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
			System.out.println("2. 검색");
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
				System.out.println("잘목입력하셨습니다");
				break;
			}

		} while (true);
	}

	// # 삽입
	public void insert() {
		String endMsg = "";
		while (true) {
			if (endMsg.toLowerCase().equals("n")) {
				break;
			}
			System.out.print("종목 명 : ");
			String name = scanner.nextLine();
			System.out.print("구매 단가 : ");
			int pPrice = scanner.nextInt();
			scanner.nextLine();
			System.out.print("현재 단가 : ");
			int cPrice = scanner.nextInt();
			scanner.nextLine();
			System.out.print("보유 주식 수 : ");
			int ownStocks = scanner.nextInt();
			scanner.nextLine();

			StockVO stockVO = new StockVO(name, pPrice, cPrice, ownStocks);
			arStock.add(stockVO);
			priceAsset += stockVO.getTotalpPrice();
			nowAsset += stockVO.getTotalcPrice();
			System.out.println(stockVO);

			System.out.print("\n계속 하시려면 Y 아니면 N : ");
			endMsg = scanner.nextLine();
		}

	}

	// # 보기
	public void view() {
		String showPriceAsset = "총 매입금액 : " + String.format("%,d", priceAsset) + " 원";	// 총 매입금액
		String showNowAsset = "총 평가금액 : " + String.format("%,d", nowAsset) + " 원";		// 총 평가금액
		String showTotalYeild = "총 수익률 " + String.format("%.2f %%",
								((float) nowAsset - priceAsset) / priceAsset * 100);			// 총 수익률 포멧
		if (arStock.size() == 0) {
			System.out.println("보유한 주식이 없음.");
		} else {
			choice = 0;
			System.out.println("<<보고싶은 내용을 선택하세요>>");
			System.out.println("1. 전체 내용 및 전체 자산 ");
			System.out.println("2. 전체 자산만");
			System.out.println("3. 종목별 수익률만");
			System.out.println("입력 => ");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1: // 전체 내용 공개
				for (int i = 0; i < arStock.size(); i++) {
					System.out.println("[" + (i + 1) + "]");
					System.out.println(arStock.get(i));
				}
				System.out.println();
				System.out.println(showPriceAsset + "\n" + showNowAsset + "\n"+ showTotalYeild);
				break;
			case 2: // 전체 자산만
				System.out.println(showPriceAsset + "\n" + showNowAsset + "\n"+ showTotalYeild);
				break;
			case 3: // 종목별루만
				for (int i = 0; i < arStock.size(); i++) {
					System.out.println("[" + (i + 1) + "]");
					System.out.println(arStock.get(i));
				}
				break;
			default:
				System.out.println("잘 못 입력하셨습니다.");
			}

		}
		System.out.println("===============================");
	}


	// # 삭제
	public void delete() {
		choice = 0; // 삭제할 index를 저장
		StockVO delStock = null; // 제거할 객체를 저장하는 변수
		if (arStock.size() != 0) {
			view();
			System.out.println("삭제할 종목 번호를 클릭하세요");
			choice = scanner.nextInt();
			scanner.nextLine();
			if (choice - 1 > arStock.size()) {
				System.out.println("다시 입력하세요");
			} else {
				delStock = arStock.get(choice - 1);

				// 제거한 만큼 재산에서 제외
				priceAsset -= delStock.getTotalpPrice();
				nowAsset -= delStock.getTotalcPrice();
				arStock.remove(choice - 1);
			}
			System.out.println(delStock.getName() + " 삭제 완료");
			view();
		} else {
			System.out.println("보유한 주식이 없음.");
		}
	}

	// # 수정
	public void update() {
		choice = 0;
		view();
		System.out.println("수정하실 종목 번호를 입력하세요");
		choice = scanner.nextInt() - 1; // 인덱스 번호로 활용하기 위해서
		if (choice <= arStock.size() || choice >= 0) {
			scanner.nextLine();
			// 우선 합계 금액들 산정한 거 제거하기
			priceAsset -= arStock.get(choice).getTotalpPrice();
			nowAsset -= arStock.get(choice).getTotalcPrice();
			System.out.print("구매 단가 : ");
			int pPrice = scanner.nextInt();
			scanner.nextLine();
			System.out.print("현재 단가 : ");
			int cPrice = scanner.nextInt();
			scanner.nextLine();
			System.out.print("보유 주식 수 : ");
			int ownStocks = scanner.nextInt();
			scanner.nextLine();
			arStock.get(choice).setcPrice(cPrice);
			arStock.get(choice).setOwnStocks(ownStocks);
			arStock.get(choice).setpPrice(pPrice);
			view();
		}else {
			System.out.println("잘 못 입력하셨습니다.");
		}

	}

}
