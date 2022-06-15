package com.ptit.btl_ltw.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ptit.btl_ltw.model.TheLoai;

public class TheLoaiDAO extends DAO {
	
	public List<TheLoai> layTatCaTheLoai () {
		List<TheLoai> dsTheLoai = new ArrayList<>();
		String sql = "SELECT * FROM data_ltw.theloai";
		try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TheLoai theLoai = new TheLoai();
                theLoai.setId(rs.getInt("id"));
                theLoai.setTen(rs.getString("ten"));
                theLoai.setMa(rs.getNString("ma"));
                theLoai.setNguoiTao(rs.getString("nguoiTao"));
                theLoai.setNgayTao(rs.getTimestamp("ngayTao"));
                theLoai.setNguoiSua(rs.getString("nguoiSua"));
                theLoai.setNgaySua(rs.getTimestamp("ngaySua"));
                dsTheLoai.add(theLoai);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsTheLoai;
	}
	
//	public static void main(String[] args) {
//		TheLoaiDAO test = new TheLoaiDAO();
//		test.layTatCaTheLoai().forEach(action -> {System.out.println(action.getTen());});
//	}
	
}
