package vo;

import java.util.Date;

public class AdminVO {
    public final static String TABLENAME = "admin";
    public final static String INDEXNAME = "adminNo";
    private Long adminNo;
    private String adminId;
    private String adminName;
    private String password;
    
	public Long getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(Long adminNo) {
		this.adminNo = adminNo;
	}
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}