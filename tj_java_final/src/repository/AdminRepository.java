package repository;

import java.util.List;

import vo.AdminVO;
import vo.CartVO;

public class AdminRepository extends AbstractRepository<AdminVO>  {
	public AdminRepository() {
		super(AdminVO.class);	
	}
	
	public AdminVO selectByAdminIdAndPassword(String id, String pwd) {
		List<AdminVO> adminList = null;
		AdminVO admin = null; 
		adminList = selectByQuery(String.format("Select admin_no, admin_name from admin where admin_id = '%s' and password = '%s'", id, pwd));
		
		if (adminList.size() > 0) {
			admin = adminList.get(0); 
		}
		
		return admin;
	}
}
