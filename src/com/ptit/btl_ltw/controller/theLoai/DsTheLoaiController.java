package com.ptit.btl_ltw.controller.theLoai;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ptit.btl_ltw.service.NguoiDungService;
import com.ptit.btl_ltw.service.TheLoaiService;
import com.ptit.btl_ltw.service.imlp.NguoiDungImlp;
import com.ptit.btl_ltw.service.imlp.TheLoaiImlp;

@WebServlet("/dsTheLoai")
public class DsTheLoaiController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final NguoiDungService nguoiDungService;
	private final TheLoaiService theLoaiService;
	
	public DsTheLoaiController() {
		this.nguoiDungService  = new NguoiDungImlp();
		this.theLoaiService = new TheLoaiImlp();
	}
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	resp.setContentType("text/html");
		
    	String un = req.getParameter("u");
    	
    	req.setAttribute("nguoiDung", nguoiDungService.layNguoiDungTheoUsername(un));
		req.setAttribute("dsTheLoai", theLoaiService.layTatCaTheLoai());
		
		RequestDispatcher rd = req.getRequestDispatcher("dsTheLoai.jsp");
    	rd.forward(req, resp);
    }
}
