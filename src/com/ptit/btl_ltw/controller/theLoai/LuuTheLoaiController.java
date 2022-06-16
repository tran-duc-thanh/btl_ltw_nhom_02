package com.ptit.btl_ltw.controller.theLoai;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ptit.btl_ltw.model.NguoiDung;
import com.ptit.btl_ltw.model.TheLoai;
import com.ptit.btl_ltw.service.NguoiDungService;
import com.ptit.btl_ltw.service.TheLoaiService;
import com.ptit.btl_ltw.service.imlp.NguoiDungImlp;
import com.ptit.btl_ltw.service.imlp.TheLoaiImlp;

@WebServlet("/luuTheLoai")
public class LuuTheLoaiController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final NguoiDungService nguoiDungService;
	private final TheLoaiService theLoaiService;
	
	public LuuTheLoaiController() {
		this.nguoiDungService  = new NguoiDungImlp();
		this.theLoaiService = new TheLoaiImlp();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		String tenTheLoai = req.getParameter("tenTheLoai");
		String maTheLoai = req.getParameter("maTheLoai");
		String un = req.getParameter("u");
		NguoiDung nguoiDung = nguoiDungService.layNguoiDungTheoUsername(un);
		
		TheLoai theLoai = new TheLoai();
		theLoai.setTen(tenTheLoai);
		theLoai.setMa(maTheLoai);
		
		if (req.getParameter("id") == null) {
			theLoai.setNguoiTao(nguoiDung.getUsername());
			theLoaiService.themTheLoai(theLoai);
		} else {
			theLoai.setNguoiSua(nguoiDung.getUsername());
			int id = Integer.parseInt(req.getParameter("id"));
			theLoaiService.suaTheLoai(theLoai, id);
		}
		
		req.setAttribute("nguoiDung", nguoiDung);
		req.setAttribute("dsTheLoai", theLoaiService.layTatCaTheLoai());
		
		RequestDispatcher rd = req.getRequestDispatcher("dsTheLoai.jsp");
		rd.forward(req, resp);
	}
}
