package com.ptit.btl_ltw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ptit.btl_ltw.model.TheLoai;
import com.ptit.btl_ltw.service.TheLoaiService;
import com.ptit.btl_ltw.service.imlp.TheLoaiImlp;

@WebServlet("/dangKy")
public class DangKyController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final TheLoaiService theLoaiService;
	
	public DangKyController() {
		this.theLoaiService = new TheLoaiImlp();
	}
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	resp.setContentType("text/html");
		
		List<TheLoai> dsTheLoai = theLoaiService.layTatCaTheLoai();
		req.setAttribute("dsTheLoai", dsTheLoai);
		
		RequestDispatcher rd = req.getRequestDispatcher("dangKy.jsp");
    	rd.forward(req, resp);
    }

}
