package com.ptit.btl_ltw.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ptit.btl_ltw.model.BaiViet;

public class BaiVietDAO extends DAO {

    public List<BaiViet> layTatCaBaiViet() {
        List<BaiViet> danhSachKetQua = new ArrayList<>();
        String sql = "SELECT * FROM data_ltw.baiviet";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BaiViet baiViet = new BaiViet();
                baiViet.setId(rs.getInt("id"));
                baiViet.setTieuDe(rs.getString("tieuDe"));
                baiViet.setTomTat(rs.getString("tomTat"));
                baiViet.setNoiDung(rs.getString("noiDung"));
                baiViet.setTheLoaiId(rs.getInt("theLoai_id"));
                baiViet.setNguoiTao(rs.getString("nguoiTao"));
                baiViet.setNgayTao(rs.getTimestamp("ngayTao"));
                baiViet.setNguoiSua(rs.getString("nguoiSua"));
                baiViet.setNgaySua(rs.getTimestamp("ngaySua"));
                danhSachKetQua.add(baiViet);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return danhSachKetQua;
    }

    public List<BaiViet> layTatCaBaiVietCungTheLoai(int id) {
        List<BaiViet> danhSachKetQua = new ArrayList<>();
        String sql = "SELECT * FROM data_ltw.baiviet WHERE theLoai_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BaiViet baiViet = new BaiViet();
                baiViet.setId(rs.getInt("id"));
                baiViet.setTieuDe(rs.getString("tieuDe"));
                baiViet.setTomTat(rs.getString("tomTat"));
                baiViet.setNoiDung(rs.getString("noiDung"));
                baiViet.setTheLoaiId(rs.getInt("theLoai_id"));
                baiViet.setNguoiTao(rs.getString("nguoiTao"));
                baiViet.setNgayTao(rs.getTimestamp("ngayTao"));
                baiViet.setNguoiSua(rs.getString("nguoiSua"));
                baiViet.setNgaySua(rs.getTimestamp("ngaySua"));
                danhSachKetQua.add(baiViet);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return danhSachKetQua;
    }

    public BaiViet layMotBaiViet(int id) {
        BaiViet baiViet = new BaiViet();
        String sql = "SELECT * FROM data_ltw.baiviet WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                baiViet.setId(rs.getInt("id"));
                baiViet.setTieuDe(rs.getString("tieuDe"));
                baiViet.setTomTat(rs.getString("tomTat"));
                baiViet.setNoiDung(rs.getString("noiDung"));
                baiViet.setTheLoaiId(rs.getInt("theLoai_id"));
                baiViet.setNguoiTao(rs.getString("nguoiTao"));
                baiViet.setNgayTao(rs.getTimestamp("ngayTao"));
                baiViet.setNguoiSua(rs.getString("nguoiSua"));
                baiViet.setNgaySua(rs.getTimestamp("ngaySua"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return baiViet;
    }

    public void themBaiViet (BaiViet baiViet) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO `data_ltw`.`baiviet` ");
        sql.append("(`tieuDe`, `tomTat`, `noiDung`, `theLoai_id`, `nguoiTao`, `ngayTao`) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?)");

        try {
            PreparedStatement ps = con.prepareStatement(sql.toString());

            ps.setString(1, baiViet.getTieuDe());
            ps.setString(2, baiViet.getTomTat());
            ps.setString(3, baiViet.getNoiDung());
            ps.setInt(4, baiViet.getTheLoaiId());
            ps.setString(5, baiViet.getNguoiTao());
            ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()));

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void suaBaiViet (BaiViet baiViet, int id) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE `data_ltw`.`baiviet` ");
        sql.append("SET `tieuDe` = ?, `tomTat` = ?, `noiDung` = ?, `theLoai_id` = ?, ");
        sql.append("`nguoiTao` = ?, `ngayTao` = ?, `nguoiSua` = ?, `ngaySua` = ? ");
        sql.append("WHERE (`id` = ?)");

        try {
            PreparedStatement ps = con.prepareStatement(sql.toString());

            ps.setString(1, baiViet.getTieuDe());
            ps.setString(2, baiViet.getTomTat());
            ps.setString(3, baiViet.getNoiDung());
            ps.setInt(4, baiViet.getTheLoaiId());
            ps.setString(5, baiViet.getNguoiTao());
            ps.setTimestamp(6, baiViet.getNgayTao());
            ps.setString(7, baiViet.getNguoiSua());
            ps.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
            ps.setInt(9, id);

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void xoaBaiViet (int id) {
        String sql = "DELETE FROM `data_ltw`.`baiviet` WHERE (`id` = ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        BaiVietDAO test = new BaiVietDAO();
//        test.layTatCaBaiViet().forEach(baiViet -> System.out.println(baiViet.getTieuDe()));
//        BaiViet baiViet = test.layMotBaiViet(2);
//        baiViet.setTieuDe("test");
//        baiViet.setTomTat("test");
//        baiViet.setNoiDung("test");
//        baiViet.setTheLoaiId(1);
//        baiViet.setNguoiTao("test");
//        baiViet.setNguoiSua("test");
//        test.suaBaiViet(baiViet, 2);
//        test.xoaBaiViet(1);
//    }
}
