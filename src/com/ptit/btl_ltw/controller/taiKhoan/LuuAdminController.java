package com.ptit.btl_ltw.controller.taiKhoan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ptit.btl_ltw.model.NguoiDung;
import com.ptit.btl_ltw.service.NguoiDungService;
import com.ptit.btl_ltw.service.TheLoaiService;
import com.ptit.btl_ltw.service.imlp.NguoiDungImlp;
import com.ptit.btl_ltw.service.imlp.TheLoaiImlp;

@WebServlet("/luuAdmin")
public class LuuAdminController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final NguoiDungService nguoiDungService;
	private final TheLoaiService theLoaiService;
	
	public LuuAdminController() {
		this.nguoiDungService  = new NguoiDungImlp();
		this.theLoaiService = new TheLoaiImlp();
	}
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
		resp.setContentType("text/html");
		
    	String un = req.getParameter("u");
    	NguoiDung u = nguoiDungService.layNguoiDungTheoUsername(un);
    	String hoTen = req.getParameter("hoten");
    	String taiKhoan = req.getParameter("taikhoan");
    	String matKhau = req.getParameter("matkhau");
    	
    	NguoiDung nguoiDung = new NguoiDung();
    	nguoiDung.setTen(hoTen);
    	nguoiDung.setUsername(taiKhoan);
    	nguoiDung.setPassword(matKhau);
    	nguoiDung.setNguoiTao(u.getUsername());
    	
    	req.setAttribute("nguoiDung", u);
    	nguoiDungService.themTaiKhoanAdmin(nguoiDung);
    	req.setAttribute("dsNguoiDung", nguoiDungService.layTaiCaNguoiDung());
		req.setAttribute("dsTheLoai", theLoaiService.layTatCaTheLoai());
		
		RequestDispatcher rd = req.getRequestDispatcher("qlTaiKhoan.jsp");
    	rd.forward(req, resp);
    }
}
