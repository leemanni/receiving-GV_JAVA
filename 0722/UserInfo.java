package exercise.fileStream;

public class UserInfo {
	private String uSerID;
	private String userName;
	
	public UserInfo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UserInfo(String uSerID, String userName) {
		this.uSerID = uSerID;
		this.userName = userName;
	}


	public String getuSerID() {
		return uSerID;
	}
	public void setuSerID(String uSerID) {
		this.uSerID = uSerID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "UserInfo [uSerID=" + uSerID + ", userName=" + userName + "]";
	}
	
	
	
	
}
