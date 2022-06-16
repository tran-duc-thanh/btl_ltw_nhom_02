package com.ptit.btl_ltw.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
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
	
	public TheLoai layMotTheLoai (int id) {
		TheLoai theLoai = new TheLoai();
		String sql = "SELECT * FROM data_ltw.theloai WHERE id = ?";
		try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                theLoai.setId(rs.getInt("id"));
                theLoai.setTen(rs.getString("ten"));
                theLoai.setMa(rs.getNString("ma"));
                theLoai.setNguoiTao(rs.getString("nguoiTao"));
                theLoai.setNgayTao(rs.getTimestamp("ngayTao"));
                theLoai.setNguoiSua(rs.getString("nguoiSua"));
                theLoai.setNgaySua(rs.getTimestamp("ngaySua"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return theLoai;
	}
	
	public void themTheLoai(TheLoai theLoai) {
		String sql = "INSERT INTO `data_ltw`.`theloai` (`ten`, `ma`, `nguoiTao`, `ngayTao`) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
            ps.setString(1, theLoai.getTen());
            ps.setString(2, theLoai.getMa());
            ps.setString(3, theLoai.getNguoiTao());
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            
            ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void suaTheLoai(TheLoai theLoai, int id) {
		String sql = "UPDATE `data_ltw`.`theloai` SET `ten` = ?, `ma` = ?, `nguoiTao` = ?, `ngayTao` = ?, `nguoiSua` = ?, `ngaySua` = ? WHERE (`id` = ?);";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
            ps.setString(1, theLoai.getTen());
            ps.setString(2, theLoai.getMa());
            ps.setString(3, theLoai.getNguoiTao());
            ps.setTimestamp(4, theLoai.getNgayTao());
            ps.setString(5, theLoai.getNguoiSua());
            ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            ps.setInt(7, id);
            
            ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		TheLoaiDAO test = new TheLoaiDAO();
//		test.layTatCaTheLoai().forEach(action -> {System.out.println(action.getTen());});
//	}
	
}
