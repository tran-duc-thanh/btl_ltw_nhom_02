package com.ptit.btl_ltw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ptit.btl_ltw.dao.NguoiDungDAO;
import com.ptit.btl_ltw.model.NguoiDung;

@WebServlet("/dangNhap")
public class DangNhapController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private NguoiDungDAO nguoiDungDAO;
	
	public DangNhapController() {
		this.nguoiDungDAO  = new NguoiDungDAO();
	}
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        
        String taiKhoan = req.getParameter("taiKhoan");
        String matKhau = req.getParameter("matKhau");
        
        NguoiDung nguoiDung = new NguoiDung();
        nguoiDung.setUsername(taiKhoan);
        nguoiDung.setPassword(matKhau);
        
        if (nguoiDungDAO.kiemTraDangNhap(nguoiDung) != null) {
        	RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        	rd.forward(req, resp);
        } else {
        	RequestDispatcher rd = req.getRequestDispatcher("dangNhap.jsp");
        	rd.forward(req, resp);
        }
        
    }
}
