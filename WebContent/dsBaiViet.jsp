<%@page import="com.ptit.btl_ltw.model.TheLoai"%>
<%@page import="com.ptit.btl_ltw.model.BaiViet"%>
<%@page import="java.util.List"%>
<%@page import="com.ptit.btl_ltw.model.NguoiDung"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="./css/css.css">
<title>Tin tức | QL Bài Viết</title>
</head>
<body>
	<header>
		<h1>QL Bài Viết</h1>
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
			<form class="nutThemMoi" action="themBaiViet?u=<%out.print(nguoiDung.getUsername()); %>" method="post">
            	<button type="submit"><img src="./img/btnThem.png" width="20" height="20"></button>
        	</form>

			<table class="bangDs">
            	<thead>
            		<tr>
		                <th scope="col">STT</th>
		                <th scope="col">Tiêu đề</th>
		                <th scope="col">Tùy chỉnh</th>
            		</tr>
            	</thead>
            	<tbody>
					<%
						List<BaiViet> dsBaiViet = (List<BaiViet>) request.getAttribute("dsBaiViet");
						for (int i = 0; i < dsBaiViet.size(); i++) {
							out.println("<tr>");
							out.println("<th scope='row'>" + (i+1) + "</th>");
							out.println("<td>" + dsBaiViet.get(i).getTieuDe() + "</td>");
							out.println("<td>");
							out.println("<form action='suaBaiViet?id="+ dsBaiViet.get(i).getId() + "&u="+ nguoiDung.getUsername() +"' method='post' class=''>");
							out.println("<button class='nut vang' type='submit' class=''><img src='./img/btnSua.png' width='20' height=''20></button>");
							out.println("</form>");
							out.println("<form action='xoaBaiViet?id="+ dsBaiViet.get(i).getId() + "&u="+ nguoiDung.getUsername() +"' method='post' class=''>");
							out.println("<button id='btnXoaBV' class='nut do' type='submit' class=''><img src='./img/btnXoa.png' width='20' height=''20></button>");
							out.println("</form>");
							out.println("</td>");
							out.println("</tr>");
						}
					%>
            	</tbody>
        </table>
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