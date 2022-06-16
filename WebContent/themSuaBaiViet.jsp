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
	<script src="./ckeditor/ckeditor.js" type="text/javascript"></script>
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
			<% BaiViet baiViet = (BaiViet) request.getAttribute("baiViet"); %>
			<form action="luuBaiViet?u=<%out.print(nguoiDung.getUsername()); if (baiViet != null){out.print("&id="+baiViet.getId());}%>"
				method="post" style="padding-left: 24px; padding-right: 24px; padding-top: 32px;">
	            <div class="">
	                <label>Thể loại</label>
	                <select name="theLoai">
	                    
	                    <%
	                    	if (baiViet == null) {
		                    	out.println("<option value=''>Chọn thể loại</option>");
			                    for (int i = 0; i < dsTheLoai.size(); i++) {
			                    	out.println("<option value='"+ dsTheLoai.get(i).getId() +"'>"+ dsTheLoai.get(i).getTen() +"</option>");
			    				}
	                    	} else {
	                    		for (int i = 0; i < dsTheLoai.size(); i++) {
	                    			if (baiViet.getTheLoaiId() == dsTheLoai.get(i).getId()) {
	                    				out.println("<option selected='selected' value='"+ dsTheLoai.get(i).getId() +"'>"+ dsTheLoai.get(i).getTen() +"</option>");
	                    			} else {
			                    		out.println("<option value='"+ dsTheLoai.get(i).getId() +"'>"+ dsTheLoai.get(i).getTen() +"</option>");
	                    			}
			    				}
	                    	}
	                    %>
	                </select>
	            </div>
	            <div class="">
	                <label>Tiêu đề</label>
	                <input type="text" value="<%if (baiViet != null) {out.print(baiViet.getTieuDe());} %>" class="" name="tieuDe" required>
	            </div>
	            <div class="">
	                <label>Tóm tắt</label>
	                <textarea class="" value="" name="tomTat" rows="3" required><%if (baiViet != null) {out.print(baiViet.getTomTat());} %></textarea>
	            </div>
	            <div class="">
	                <label>Nội dung</label>
	                <textarea class="" name="noiDung" rows="20" required><%if (baiViet != null) {out.print(baiViet.getNoiDung());} %></textarea>
	                <script>
	                    CKEDITOR.replace('noiDung')
	                </script>
	            </div>
	            <div class="">
	                <button type="submit" class="">Lưu</button>
	            </div>
        	</form>
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