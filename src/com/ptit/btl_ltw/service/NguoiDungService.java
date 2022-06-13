package com.ptit.btl_ltw.service;

import com.ptit.btl_ltw.model.NguoiDung;

public interface NguoiDungService {
    NguoiDung kiemTraDangNhap (NguoiDung u);
    NguoiDung layNguoiDungTheoUsername (String username);
    void themTaiKhoan (NguoiDung u);
}
