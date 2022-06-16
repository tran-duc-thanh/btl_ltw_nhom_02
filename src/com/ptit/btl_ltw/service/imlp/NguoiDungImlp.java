package com.ptit.btl_ltw.service.imlp;

import java.util.List;

import com.ptit.btl_ltw.dao.NguoiDungDAO;
import com.ptit.btl_ltw.model.NguoiDung;
import com.ptit.btl_ltw.service.NguoiDungService;

public class NguoiDungImlp implements NguoiDungService {

    NguoiDungDAO ud = new NguoiDungDAO();

    @Override
    public NguoiDung kiemTraDangNhap(NguoiDung u) {
        return ud.kiemTraDangNhap(u);
    }

    @Override
    public NguoiDung layNguoiDungTheoUsername(String username) {
        return ud.layNguoiDungTheoUsername(username);
    }

    @Override
    public void themTaiKhoan(NguoiDung u) {
        ud.themTaiKhoan(u);
    }

	@Override
	public List<NguoiDung> layTaiCaNguoiDung() {
		return ud.dsNguoiDung();
	}

	@Override
	public void khoaMoTaiKhoan(String un) {
		ud.khoaMoTaiKhoan(un);
	}

	@Override
	public void themTaiKhoanAdmin(NguoiDung u) {
		ud.themTaiKhoanAdmin(u);
	}

}
