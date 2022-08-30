package kr.co.tj.service;

import kr.co.tj.dao.EmpDAO;
import kr.co.tj.domain.EmpVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class SelectService {
    public ArrayList<EmpVO> excute(HttpServletRequest request, HttpServletResponse response){
        EmpDAO dao = new EmpDAO();

        return dao.select();
    }
}
