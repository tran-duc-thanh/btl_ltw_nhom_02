package com.ptit.btl_ltw.service;

import java.util.List;

import com.ptit.btl_ltw.model.TheLoai;

public interface TheLoaiService {
	List<TheLoai> layTatCaTheLoai ();
	TheLoai layMotTheLoai (int id);
	void themTheLoai (TheLoai theLoai);
	void suaTheLoai (TheLoai theLoai, int id);
}
