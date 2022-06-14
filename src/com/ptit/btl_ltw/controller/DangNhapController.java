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
import com.ptit.btl_ltw.service.BaiVietService;
import com.ptit.btl_ltw.service.NguoiDungService;
import com.ptit.btl_ltw.service.imlp.BaiVietImlp;
import com.ptit.btl_ltw.service.imlp.NguoiDungImlp;

@WebServlet("/dangNhap")
public class DangNhapController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final NguoiDungService nguoiDungService;
	private final BaiVietService baiVietService;
	
	public DangNhapController() {
		this.nguoiDungService  = new NguoiDungImlp();
		this.baiVietService = new BaiVietImlp();
	}
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        
        String taiKhoan = req.getParameter("taiKhoan");
        String matKhau = req.getParameter("matKhau");
        
        NguoiDung nguoiDung = new NguoiDung();
        nguoiDung.setUsername(taiKhoan);
        nguoiDung.setPassword(matKhau);
        nguoiDung = nguoiDungService.kiemTraDangNhap(nguoiDung);
        req.setAttribute("nguoiDung", nguoiDung);
        List<BaiViet> dsBaiViet = baiVietService.layTatCaBaiViet();
//        System.out.print(dsBaiViet.get(0).getTieuDe());
        
        if (nguoiDung != null) {
        	req.setAttribute("dsBaiViet", dsBaiViet);
        	RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        	rd.forward(req, resp);
        } else {
        	RequestDispatcher rd = req.getRequestDispatcher("dangNhap.jsp");
        	rd.forward(req, resp);
        }
        
    }
}
