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
import com.ptit.btl_ltw.service.BaiVietService;
import com.ptit.btl_ltw.service.imlp.BaiVietImlp;

@WebServlet("")
public class TrangChuController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final BaiVietService baiVietService;

	public TrangChuController() {
		this.baiVietService = new BaiVietImlp();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		List<BaiViet> dsBaiViet = baiVietService.layTatCaBaiViet();
		req.setAttribute("dsBaiViet", dsBaiViet);
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
    	rd.forward(req, resp);
	}
}
