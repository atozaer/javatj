package controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception;
	// ����(==�޼���)�� input, output�� �߿�!
	
	/*
	  +++ output +++
	  1- ���� ����(����������)
	  2- ��� ����(forward,sendRedirect)
	  ���� ��� == ��üȭ -> ActionForward	ex)vo
	 */
}