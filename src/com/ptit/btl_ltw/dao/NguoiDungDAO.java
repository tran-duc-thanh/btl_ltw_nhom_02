package com.ptit.btl_ltw.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ptit.btl_ltw.model.NguoiDung;

public class NguoiDungDAO extends DAO {
	
    public NguoiDungDAO () {
    }

    public NguoiDung kiemTraDangNhap (NguoiDung u) {
        boolean check = false;
        NguoiDung nguoiDung = new NguoiDung();
        String sql = "SELECT * FROM data_ltw.nguoidung WHERE username = ? AND password = ? AND trangThai = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                check = true;
                nguoiDung.setId(rs.getInt("id"));
                nguoiDung.setTen(rs.getString("ten"));
                nguoiDung.setUsername(rs.getString("username"));
                nguoiDung.setPassword(rs.getString("password"));
                nguoiDung.setQuyen(rs.getString("quyen"));
                nguoiDung.setTrangThai(rs.getInt("trangThai"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (check) return nguoiDung;
        return null;
    }

    public NguoiDung layNguoiDungTheoUsername (String username) {
        NguoiDung nguoiDung = new NguoiDung();
        String sql = "SELECT * FROM data_ltw.nguoidung WHERE username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nguoiDung.setId(rs.getInt("id"));
                nguoiDung.setTen(rs.getString("ten"));
                nguoiDung.setUsername(rs.getString("username"));
                nguoiDung.setPassword(rs.getString("password"));
                nguoiDung.setQuyen(rs.getString("quyen"));
                nguoiDung.setTrangThai(rs.getInt("trangThai"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nguoiDung;
    }

    public void themTaiKhoan (NguoiDung u) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO `data_ltw`.`nguoidung` ");
        sql.append("(`ten`, `username`, `password`, `quyen`, `trangThai`, `nguoiTao`, `ngayTao`) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?)");

        try {
            PreparedStatement ps = con.prepareStatement(sql.toString());
            ps.setString(1, u.getTen());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getPassword());
            ps.setString(4, "USER");
            ps.setInt(5, 1);
            ps.setString(6, u.getUsername());
            ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));

            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void themTaiKhoanAdmin (NguoiDung u) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO `data_ltw`.`nguoidung` ");
        sql.append("(`ten`, `username`, `password`, `quyen`, `trangThai`, `nguoiTao`, `ngayTao`) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?)");

        try {
            PreparedStatement ps = con.prepareStatement(sql.toString());
            ps.setString(1, u.getTen());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getPassword());
            ps.setString(4, "ADMIN");
            ps.setInt(5, 1);
            ps.setString(6, u.getNguoiTao());
            ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));

            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<NguoiDung> dsNguoiDung () {
    	List<NguoiDung> dsNguoiDung = new ArrayList<>();
    	String sql = "SELECT * FROM data_ltw.nguoidung";
    	
    	try {
    		PreparedStatement ps = con.prepareStatement(sql);
    		ResultSet rs = ps.executeQuery();
    		
    		while (rs.next()) {
    			NguoiDung nguoiDung = new NguoiDung();
    			nguoiDung.setId(rs.getInt("id"));
    			nguoiDung.setTen(rs.getString("ten"));
    			nguoiDung.setUsername(rs.getString("username"));
    			nguoiDung.setPassword(rs.getString("password"));
    			nguoiDung.setQuyen(rs.getString("quyen"));
                nguoiDung.setTrangThai(rs.getInt("trangThai"));
                dsNguoiDung.add(nguoiDung);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return dsNguoiDung;
    }

    public void khoaMoTaiKhoan (String un) {
    	NguoiDung nguoiDung = layNguoiDungTheoUsername(un);
    	String sql = "UPDATE `data_ltw`.`nguoidung` SET `trangThai` = ? WHERE (`username` = ?)";
    	
    	try {
    		PreparedStatement ps = con.prepareStatement(sql);
    		if (nguoiDung.getTrangThai() == 1) {
    			ps.setInt(1, 0);
    		} else {
    			ps.setInt(1, 1);
    		}
    		ps.setString(2, un);
    		ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
//    public static void main(String[] args) {
//        NguoiDungDAO test = new NguoiDungDAO();
//        NguoiDung user = new NguoiDung();
//        user.setTen("user");
//        user.setUsername("user");
//        user.setPassword("1234567");
//        System.out.println(test.kiemTraDangNhap(user).getUsername());
//    }
}
