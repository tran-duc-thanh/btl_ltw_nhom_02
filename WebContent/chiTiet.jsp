<%--
  Created by IntelliJ IDEA.
  User: Thanh
  Date: 6/7/2022
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.ptit.btl_ltw.model.TheLoai"%>
<%@page import="com.ptit.btl_ltw.model.BaiViet"%>
<%@page import="java.util.List"%>
<%@page import="com.ptit.btl_ltw.model.NguoiDung"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <link rel="stylesheet" href="./css/css.css">
    <title>Tin tức | Chi Tiết</title>
</head>
<body>
<header>
    <h1>Chi Tiết</h1>
</header>

<nav>
		<% NguoiDung nguoiDung = (NguoiDung) request.getAttribute("nguoiDung");%>
		<% 
			if (nguoiDung != null) {
				out.print("<a href='trangChu?u=" + nguoiDung.getUsername() + "'><img src='./img/trangChu.png' width='20' height=''20></a>");
				if (nguoiDung.getQuyen().equals("ADMIN")) {
					out.print("<a href='dsBaiViet?u=" + nguoiDung.getUsername() + "'>QL Bài Viết</a>");
					out.print("<a href='dsTheLoai?u=" + nguoiDung.getUsername() + "'>QL Thể Loại</a>");
					out.print("<a href='dsTaiKhoan?u=" + nguoiDung.getUsername() + "'>QL Tài Khoản</a>");
				}
			} else {
				out.print("<a href='trangChu'><img src='./img/trangChu.png' width='20' height=''20></a>");
			}
		%>
		
		<%
			List<TheLoai> dsTheLoai = (List<TheLoai>) request.getAttribute("dsTheLoai");
			if (nguoiDung != null) {
				for (int i = 0; i < dsTheLoai.size(); i++) {
					out.print("<a href='theLoai?id=" + dsTheLoai.get(i).getId() + "&u=" + nguoiDung.getUsername() + "'>"+ dsTheLoai.get(i).getTen() +"</a>");
				}
			} else {
				for (int i = 0; i < dsTheLoai.size(); i++) {
					out.print("<a href='theLoai?id=" + dsTheLoai.get(i).getId() + "'>"+ dsTheLoai.get(i).getTen() +"</a>");
				}
			}
		%>
		
		<a href="dangNhap">
			<%
			if (nguoiDung != null) {
				out.print(nguoiDung.getTen());
			} else {
				out.print("Đăng Nhập");
			}
			%>
		</a>
		<a>
		<%
			if (nguoiDung != null) {
				out.print("<form action='timKiem?u=" + nguoiDung.getUsername() + "' class='timKiem' method='post'>"
				+ "<input type='text' class='' name='tuKhoa' placeholder='nhập từ khóa...''>"
				+ "<button type='submit'>Tìm Kiếm</button>"
			    + "</form>");
			} else {
				out.print("<form action='timKiem' class='timKiem' method='post'>"
						+ "<input type='text' class='' name='tuKhoa' placeholder='nhập từ khóa...''>"
						+ "<button type='submit'>Tìm Kiếm</button>"
					    + "</form>");
			}
		%>
		</a>
</nav>

<div class="thanTrang">
    <div class="noiDung">
        <section>
        	<% BaiViet baiViet = (BaiViet) request.getAttribute("baiViet"); %>
            <h2><% out.print(baiViet.getTieuDe()); %></h2>
            <br>
            <h3><% out.print(baiViet.getTomTat()); %></h3>
        </section>
        <article><% out.print(baiViet.getNoiDung()); %></article>
    </div>
</div>

<footer>
    <ul>
        <li>
            <h3>Về chúng tôi</h3>
            <p>Nhóm 02 lập trình web</p>
        </li>
        <li>
            <h3>Liên hệ</h3>
            <p>SĐT: 0936739044</p>
            <p>E-mail: thanhthanh1996xxx@gmail.com</p>
        </li>
    </ul>
</footer>

</body>
</html>
