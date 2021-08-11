package stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class IInsert {
	public static void main(String[] args) {
//		#Test
		Scanner sc = new Scanner(System.in);
		
		System.out.print("종목명 : ");
		String name = sc.nextLine().trim();
		
		System.out.print("보유주식 수 : ");
		int ownStocks = sc.nextInt();
		sc.nextLine();
		
		System.out.print("구매금액 : ");
		int pPrice = sc.nextInt();
		sc.nextLine();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = DBUtill.getMySQLConnection();
			String sql = "insert into stock(name , pPrice , ownStocks) values(?, ?, ?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setInt(2, pPrice);
			pstm.setInt(3, ownStocks);
			
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
