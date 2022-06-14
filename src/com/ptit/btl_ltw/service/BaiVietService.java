package com.ptit.btl_ltw.service;

import java.util.List;

import com.ptit.btl_ltw.model.BaiViet;

public interface BaiVietService {
	List<BaiViet> layTatCaBaiViet ();
	List<BaiViet> layTatCaBaiVietCungTheLoai (int id);
	BaiViet layMotBaiViet (int id);
	void themBaiViet (BaiViet baiViet);
	void suaBaiViet (BaiViet baiViet, int id);
	void xoaBaiViet (int id);
}
