package exercise.fileStream;

public class UserInfoMysqlDao implements UserInfoDao{

	@Override
	public void insertUserInfo(UserInfo userInfo) {
		System.out.println("insert into MYSQL DB userID = " + userInfo.getuSerID());
		
	}

	@Override
	public void deleteUserInfo(UserInfo userInfo) {
		System.out.println("delete into MYSQL DB userID = " + userInfo.getuSerID());
		
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		System.out.println("update into MYSQL DB userID = " + userInfo.getuSerID());
		
	}

}
