package com.ptit.btl_ltw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ptit.btl_ltw.model.BaiViet;
import com.ptit.btl_ltw.model.NguoiDung;
import com.ptit.btl_ltw.model.TheLoai;
import com.ptit.btl_ltw.service.BaiVietService;
import com.ptit.btl_ltw.service.NguoiDungService;
import com.ptit.btl_ltw.service.TheLoaiService;
import com.ptit.btl_ltw.service.imlp.BaiVietImlp;
import com.ptit.btl_ltw.service.imlp.NguoiDungImlp;
import com.ptit.btl_ltw.service.imlp.TheLoaiImlp;

@WebServlet("/theLoai")
public class TheLoaiController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final NguoiDungService nguoiDungService;
	private final BaiVietService baiVietService;
	private final TheLoaiService theLoaiService;
	
	public TheLoaiController() {
		this.nguoiDungService  = new NguoiDungImlp();
		this.baiVietService = new BaiVietImlp();
		this.theLoaiService = new TheLoaiImlp();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		int id = Integer.parseInt(req.getParameter("id"));
		String un = req.getParameter("u");
		if (un != null && un != "") {
			req.setAttribute("nguoiDung", nguoiDungService.layNguoiDungTheoUsername(un));
		}
		List<BaiViet> dsBaiViet = baiVietService.layTatCaBaiVietCungTheLoai(id);
		List<TheLoai> dsTheLoai = theLoaiService.layTatCaTheLoai();
		req.setAttribute("dsBaiViet", dsBaiViet);
		req.setAttribute("dsTheLoai", dsTheLoai);
		
		RequestDispatcher rd = req.getRequestDispatcher("theLoai.jsp");
    	rd.forward(req, resp);
	}
}
