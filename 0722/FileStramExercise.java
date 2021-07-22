package exercise.fileStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileStramExercise {
	
	public static void main(String[] args) {
		String dbType = "";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(".\\src\\exercise\\fileStream\\db.propertise");
			Properties properties = new Properties();
			
				properties.load(fis);
				dbType = properties.getProperty("DB");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		UserInfo userInfo = new UserInfo("Nada", "이윤열");
		System.out.println(userInfo);
		UserInfoDao dao = null;
		if(dbType.equals("ORACLE")) {
			dao = new UserInfoORACLE();
		}else if(dbType.equals("MYSQL")) {
			dao = new UserInfoMysqlDao();
		}
		
		
		dao.insertUserInfo(userInfo);
	}
}
