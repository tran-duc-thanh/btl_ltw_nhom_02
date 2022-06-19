package com.ptit.btl_ltw.controller;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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

@WebServlet("/timKiem")
public class TimKiemController extends HttpServlet{
	
	private final BaiVietService baiVietService;
	private final TheLoaiService theLoaiService;
	private final NguoiDungService nguoiDungService;

	public TimKiemController() {
		this.nguoiDungService  = new NguoiDungImlp();
		this.baiVietService = new BaiVietImlp();
		this.theLoaiService = new TheLoaiImlp();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		
		String un = req.getParameter("u");
		String k = chuanHoaString(req.getParameter("tuKhoa"));
		System.out.println(k);
		if (un != null && un != "") {
			NguoiDung nguoiDung = nguoiDungService.layNguoiDungTheoUsername(un);
			req.setAttribute("nguoiDung", nguoiDung);
		}
		List<BaiViet> dsBaiViet = baiVietService.layTatCaBaiViet();
		List<BaiViet> dsTimKiem = new ArrayList<>();
		dsBaiViet.forEach(baiViet -> {
			if (chuanHoaString(baiViet.getTieuDe()).contains(k)) dsTimKiem.add(baiViet);
			System.out.println(chuanHoaString(baiViet.getTieuDe()));
		});
		List<TheLoai> dsTheLoai = theLoaiService.layTatCaTheLoai();
		req.setAttribute("dsBaiViet", dsTimKiem);
		req.setAttribute("dsTheLoai", dsTheLoai);
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
    	rd.forward(req, resp);
	}
	
	public String chuanHoaString (String s) {
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(temp).replaceAll("").toLowerCase();
	}
}
