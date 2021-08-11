package stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockDAO {

	public static boolean insert(StockVO vo) {
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = DBUtill.getMySQLConnection();
			String sql = "insert into stock(name , ownStocks, pPrice, cPrice, totalpPrice, totalcPrice,profitRatio)"
					+ " values(? , ?, ?, ?, ?, ?, ?) " ;
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, vo.getName());
			pstm.setInt(2, vo.getOwnStocks());
			pstm.setInt(3, vo.getpPrice());
			pstm.setInt(4, vo.getcPrice());
			pstm.setInt(5, vo.getTotalpPrice());
			pstm.setInt(6, vo.getTotalcPrice());
			pstm.setFloat(7, vo.getProfitRatio());
			
			pstm.executeUpdate();
			System.out.println(vo.getProfitRatio());
			System.out.println(vo);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			DBUtill.close(conn);
			DBUtill.close(pstm);
		}
		return true;
	}

	public static ArrayList<StockVO> select() {
		ArrayList<StockVO> list = null;
		try {
			Connection conn = DBUtill.getMySQLConnection();
			String sql = "select * from stock order by idx ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				StockVO vo = new StockVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setOwnStocks(rs.getInt("ownStocks"));
				vo.setpPrice(rs.getInt("pPrice"));
				vo.setcPrice(rs.getInt("cPrice"));
				vo.setTotalpPrice(rs.getInt("totalpPrice"));
				vo.setTotalcPrice(rs.getInt("totalcPrice"));
				vo.setProfitRatio(rs.getFloat("profitRatio"));
				list.add(vo);
			}
			DBUtill.close(conn);
			DBUtill.close(pstm);
			DBUtill.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이터 비어있음");
		}
		return list;
	}

	public static void update(int idx, String name, int pPrice, int cPrice, int ownStocks) {
		
		try {
			Connection conn = DBUtill.getMySQLConnection();
			String sql = "";
			PreparedStatement pstm =null;
//			name
			sql = "update stock set name = ? where idx = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setInt(2, idx);
			pstm.executeUpdate();
//			pPrice
			sql = "update stock set pPrice = ? where idx = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, pPrice);
			pstm.setInt(2, idx);
			pstm.executeUpdate();
//			cPrice
			sql = "update stock set cPrice = ? where idx = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cPrice);
			pstm.setInt(2, idx);
			pstm.executeUpdate();
//			ownStocks
			sql = "update stock set ownStocks = ? where idx = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ownStocks);
			pstm.setInt(2, idx);
			pstm.executeUpdate();
				
//			수익률 정정하기
			sql = "update stock set totalpPrice = ? where idx = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ownStocks * pPrice);
			pstm.setInt(2, idx);
			pstm.executeUpdate();
			
			sql = "update stock set totalcPrice = ? where idx = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ownStocks * cPrice);
			pstm.setInt(2, idx);
			pstm.executeUpdate();
			
			sql = "update stock set profitRatio = ? where idx = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setFloat(1,(float)(cPrice - pPrice) / pPrice * 100);
			pstm.setInt(2, idx);
			pstm.executeUpdate();
			
			DBUtill.close(conn);
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean delete(int choice) {
		boolean result = false;
		
		try {
			Connection conn = DBUtill.getMySQLConnection();
			String sql = "delete from stock where idx =?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, choice);
			pstm.executeUpdate();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
}
