<%@page import="com.ptit.btl_ltw.model.TheLoai"%>
<%@page import="com.ptit.btl_ltw.model.BaiViet"%>
<%@page import="java.util.List"%>
<%@page import="com.ptit.btl_ltw.model.NguoiDung"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="./css/css.css">
<title>Tin tức | Trang chủ</title>
</head>
<body>
	<header>
		<h1>Trang chủ</h1>
	</header>

	<nav>
		<% NguoiDung nguoiDung = (NguoiDung) request.getAttribute("nguoiDung");%>
		<% 
			if (nguoiDung != null) {
				out.print("<a href='trangChu?u=" + nguoiDung.getUsername() + "' class='chonVao'>Trang chủ</a>");
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
			<section>
				<h2>Chào mừng bạn đến với trang tin tức của chúng tôi</h2>
				<br>
				<h3>Chúng tôi rất vui khi được chia sẽ nhưng tin mới nhất cho
					bạn!</h3>
				<p>Hãy chọn một mục để xem.</p>
			</section>
			<%
				List<BaiViet> dsBaiViet = (List<BaiViet>) request.getAttribute("dsBaiViet");
				if (nguoiDung != null) {
					for (int i = 0; i < dsBaiViet.size(); i++) {
						out.print("<section><a href='chiTiet?id=" + dsBaiViet.get(i).getId()  + "&u=" + nguoiDung.getUsername() + "'><h2>" + dsBaiViet.get(i).getTieuDe()
						+ "</h2></a><br><h3>" + dsBaiViet.get(i).getTomTat() + "</h3></section>");
					}
				} else {
					for (int i = 0; i < dsBaiViet.size(); i++) {
						out.print("<section><a href='chiTiet?id=" + dsBaiViet.get(i).getId() + "'><h2>" + dsBaiViet.get(i).getTieuDe()
						+ "</h2></a><br><h3>" + dsBaiViet.get(i).getTomTat() + "</h3></section>");
					}
				}
			%>
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