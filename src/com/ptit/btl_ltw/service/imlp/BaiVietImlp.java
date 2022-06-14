package com.ptit.btl_ltw.service.imlp;

import java.util.List;

import com.ptit.btl_ltw.dao.BaiVietDAO;
import com.ptit.btl_ltw.model.BaiViet;
import com.ptit.btl_ltw.service.BaiVietService;

public class BaiVietImlp implements BaiVietService{
	
	BaiVietDAO bDao = new BaiVietDAO();

	@Override
	public List<BaiViet> layTatCaBaiViet() {
		return bDao.layTatCaBaiViet();
	}

	@Override
	public List<BaiViet> layTatCaBaiVietCungTheLoai(int id) {
		return bDao.layTatCaBaiVietCungTheLoai(id);
	}

	@Override
	public BaiViet layMotBaiViet(int id) {
		return bDao.layMotBaiViet(id);
	}

	@Override
	public void themBaiViet(BaiViet baiViet) {
		bDao.themBaiViet(baiViet);
	}

	@Override
	public void suaBaiViet(BaiViet baiViet, int id) {
		bDao.suaBaiViet(baiViet, id);
	}

	@Override
	public void xoaBaiViet(int id) {
		bDao.xoaBaiViet(id);
	}

}
