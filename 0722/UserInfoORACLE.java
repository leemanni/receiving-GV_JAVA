package exercise.fileStream;

public class UserInfoORACLE implements UserInfoDao{

	@Override
	public void insertUserInfo(UserInfo userInfo) {
		System.out.println("insert into ORACLE DB userID = " + userInfo.getuSerID());
		
	}

	@Override
	public void deleteUserInfo(UserInfo userInfo) {
		System.out.println("delete into ORACLE DB userID = " + userInfo.getuSerID());
		
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		System.out.println("update into ORACLE DB userID = " + userInfo.getuSerID());
		
	}

}
