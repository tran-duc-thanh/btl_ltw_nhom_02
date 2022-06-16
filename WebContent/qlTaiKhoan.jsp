<%@page import="com.ptit.btl_ltw.model.TheLoai"%>
<%@page import="com.ptit.btl_ltw.model.BaiViet"%>
<%@page import="java.util.List"%>
<%@page import="com.ptit.btl_ltw.model.NguoiDung"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="./css/css.css">
	<title>Tin tức | QL Tài Khoản</title>
</head>
<body>
	<header>
		<h1>QL Tài Khoản</h1>
	</header>

	<nav>
		<% NguoiDung nguoiDung = (NguoiDung) request.getAttribute("nguoiDung");%>
		<% 
			if (nguoiDung != null) {
				out.print("<a href='trangChu?u=" + nguoiDung.getUsername() + "' class='chonVao'>Trang chủ</a>");
				if (nguoiDung.getQuyen().equals("ADMIN")) {
					out.print("<a href='dsBaiViet?u=" + nguoiDung.getUsername() + "'>QL Bài Viết</a>");
					out.print("<a href='dsTheLoai?u=" + nguoiDung.getUsername() + "'>QL Thể Loại</a>");
					out.print("<a href='dsTaiKhoan?u=" + nguoiDung.getUsername() + "'>QL Tài Khoản</a>");
				}
			} else {
				out.print("<a href='trangChu' class='chonVao'>Trang chủ</a>");
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
	</nav>

	<div class="thanTrang">
		<div class="noiDung">
			<% List<NguoiDung> dsNguoiDung = (List<NguoiDung>) request.getAttribute("dsNguoiDung"); %>
			<form action="themTKAdmin?u=<%out.print(nguoiDung.getUsername()); %>" method="post">
            	<button type="submit">Thêm TK Admin</button>
        	</form>

			<table class="table table-bordered">
            	<thead>
            		<tr>
		                <th scope="col">STT</th>
		                <th scope="col">Tên Tài khoản</th>
		                <th scope="col">Tùy chỉnh</th>
            		</tr>
            	</thead>
            	<tbody>
					<%
						for (int i = 0; i < dsNguoiDung.size(); i++) {
							out.println("<tr>");
							out.println("<th scope='row'>" + (i+1) + "</th>");
							out.println("<td>" + dsNguoiDung.get(i).getUsername() + "</td>");
							out.println("<td>");
							out.println("<form action='khoaMoTaiKhoan?un="+ dsNguoiDung.get(i).getUsername() + "&u="+ nguoiDung.getUsername() +"' method='post' class=''>");
							
							if (dsNguoiDung.get(i).getQuyen().equals("ADMIN")) {
								out.println("<button type='button' class=''>-----</button>");
							} else {
								if (dsNguoiDung.get(i).getTrangThai() == 1) {
									out.println("<button type='submit' class=''>Khóa</button>");
								} else {
									out.println("<button type='submit' class=''>Mở</button>");
								}
							}
							
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