package com.ptit.btl_ltw.service.imlp;

import java.util.List;

import com.ptit.btl_ltw.dao.TheLoaiDAO;
import com.ptit.btl_ltw.model.TheLoai;
import com.ptit.btl_ltw.service.TheLoaiService;

public class TheLoaiImlp implements TheLoaiService {

	TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
	
	@Override
	public List<TheLoai> layTatCaTheLoai() {
		return theLoaiDAO.layTatCaTheLoai();
	}

	@Override
	public TheLoai layMotTheLoai(int id) {
		return theLoaiDAO.layMotTheLoai(id);
	}

	@Override
	public void themTheLoai(TheLoai theLoai) {
		theLoaiDAO.themTheLoai(theLoai);
	}

	@Override
	public void suaTheLoai(TheLoai theLoai, int id) {
		theLoaiDAO.suaTheLoai(theLoai, id);
	}

}
