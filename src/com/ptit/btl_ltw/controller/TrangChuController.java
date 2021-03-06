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

@WebServlet(urlPatterns = {"", "/trangChu"})
public class TrangChuController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final BaiVietService baiVietService;
	private final TheLoaiService theLoaiService;
	private final NguoiDungService nguoiDungService;

	public TrangChuController() {
		this.nguoiDungService  = new NguoiDungImlp();
		this.baiVietService = new BaiVietImlp();
		this.theLoaiService = new TheLoaiImlp();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		String un = req.getParameter("u");
		if (un != null && un != "") {
			NguoiDung nguoiDung = nguoiDungService.layNguoiDungTheoUsername(un);
			req.setAttribute("nguoiDung", nguoiDung);
		}
		List<BaiViet> dsBaiViet = baiVietService.layTatCaBaiViet();
		List<TheLoai> dsTheLoai = theLoaiService.layTatCaTheLoai();
		req.setAttribute("dsBaiViet", dsBaiViet);
		req.setAttribute("dsTheLoai", dsTheLoai);
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
    	rd.forward(req, resp);
	}
}
