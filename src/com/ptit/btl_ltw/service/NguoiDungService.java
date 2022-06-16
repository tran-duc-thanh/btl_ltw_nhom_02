package com.ptit.btl_ltw.service;

import java.util.List;

import com.ptit.btl_ltw.model.NguoiDung;

public interface NguoiDungService {
    NguoiDung kiemTraDangNhap (NguoiDung u);
    NguoiDung layNguoiDungTheoUsername (String username);
    void themTaiKhoan (NguoiDung u);
    void themTaiKhoanAdmin (NguoiDung u);
    List<NguoiDung> layTaiCaNguoiDung ();
    void khoaMoTaiKhoan (String un);
}
