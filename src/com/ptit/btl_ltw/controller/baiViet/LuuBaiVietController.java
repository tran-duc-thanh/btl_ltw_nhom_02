package com.ptit.btl_ltw.controller.baiViet;

import java.io.IOException;

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
import com.ptit.btl_ltw.service.TheLoaiService;
import com.ptit.btl_ltw.service.imlp.BaiVietImlp;
import com.ptit.btl_ltw.service.imlp.NguoiDungImlp;
import com.ptit.btl_ltw.service.imlp.TheLoaiImlp;

@WebServlet("/luuBaiViet")
public class LuuBaiVietController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final NguoiDungService nguoiDungService;
	private final BaiVietService baiVietService;
	private final TheLoaiService theLoaiService;
	
	public LuuBaiVietController() {
		this.nguoiDungService  = new NguoiDungImlp();
		this.baiVietService = new BaiVietImlp();
		this.theLoaiService = new TheLoaiImlp();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		int theLoai_id = Integer.parseInt(req.getParameter("theLoai"));
		String tieuDe = req.getParameter("tieuDe");
		String tomTat = req.getParameter("tomTat");
		String noiDung = req.getParameter("noiDung");
		String un = req.getParameter("u");
		NguoiDung nguoiDung = nguoiDungService.layNguoiDungTheoUsername(un);
		
		BaiViet baiViet = new BaiViet();
		baiViet.setTieuDe(tieuDe);
		baiViet.setTomTat(tomTat);
		baiViet.setNoiDung(noiDung);
		baiViet.setTheLoaiId(theLoai_id);
		baiViet.setNguoiTao(nguoiDung.getUsername());
		
		baiVietService.themBaiViet(baiViet);
		req.setAttribute("nguoiDung", nguoiDung);
		req.setAttribute("dsBaiViet", baiVietService.layTatCaBaiViet());
		req.setAttribute("dsTheLoai", theLoaiService.layTatCaTheLoai());
		
		RequestDispatcher rd = req.getRequestDispatcher("dsBaiViet.jsp");
		rd.forward(req, resp);
	}
}
