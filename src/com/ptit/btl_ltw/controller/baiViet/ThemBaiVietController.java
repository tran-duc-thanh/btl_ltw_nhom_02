package com.ptit.btl_ltw.controller.baiViet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ptit.btl_ltw.model.TheLoai;
import com.ptit.btl_ltw.service.NguoiDungService;
import com.ptit.btl_ltw.service.TheLoaiService;
import com.ptit.btl_ltw.service.imlp.NguoiDungImlp;
import com.ptit.btl_ltw.service.imlp.TheLoaiImlp;

@WebServlet("/themBaiViet")
public class ThemBaiVietController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final NguoiDungService nguoiDungService;
	private final TheLoaiService theLoaiService;
	
	public ThemBaiVietController() {
		this.nguoiDungService  = new NguoiDungImlp();
		this.theLoaiService = new TheLoaiImlp();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		String un = req.getParameter("u");
		
		req.setAttribute("dsTheLoai", theLoaiService.layTatCaTheLoai());
		req.setAttribute("nguoiDung", nguoiDungService.layNguoiDungTheoUsername(un));
		
		RequestDispatcher rd = req.getRequestDispatcher("themSuaBaiViet.jsp");
    	rd.forward(req, resp);
	}
}
