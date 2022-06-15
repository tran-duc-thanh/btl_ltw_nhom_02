package com.ptit.btl_ltw.controller.baiViet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ptit.btl_ltw.service.BaiVietService;
import com.ptit.btl_ltw.service.NguoiDungService;
import com.ptit.btl_ltw.service.TheLoaiService;
import com.ptit.btl_ltw.service.imlp.BaiVietImlp;
import com.ptit.btl_ltw.service.imlp.NguoiDungImlp;
import com.ptit.btl_ltw.service.imlp.TheLoaiImlp;

@WebServlet("/xoaBaiViet")
public class XoaBaiVietController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final NguoiDungService nguoiDungService;
	private final BaiVietService baiVietService;
	private final TheLoaiService theLoaiService;
	
	public XoaBaiVietController() {
		this.nguoiDungService  = new NguoiDungImlp();
		this.baiVietService = new BaiVietImlp();
		this.theLoaiService = new TheLoaiImlp();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		String un = req.getParameter("u");
		int id = Integer.parseInt(req.getParameter("id"));
		
		req.setAttribute("dsTheLoai", theLoaiService.layTatCaTheLoai());
		req.setAttribute("nguoiDung", nguoiDungService.layNguoiDungTheoUsername(un));
		
		baiVietService.xoaBaiViet(id);
		
		req.setAttribute("dsBaiViet", baiVietService.layTatCaBaiViet());
		
		RequestDispatcher rd = req.getRequestDispatcher("dsBaiViet.jsp");
    	rd.forward(req, resp);
	}
}
