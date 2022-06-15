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

}
