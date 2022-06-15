<%@page import="com.ptit.btl_ltw.model.TheLoai"%>
<%@page import="com.ptit.btl_ltw.model.BaiViet"%>
<%@page import="java.util.List"%>
<%@page import="com.ptit.btl_ltw.model.NguoiDung"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="./css/css.css">
<script src="./ckeditor/ckeditor.js" type="text/javascript"></script>
<title>Tin tức | Trang chủ</title>
</head>
<body>
	<header>
		<h1>Trang chủ</h1>
	</header>

	<nav>
		
	</nav>

	<div class="thanTrang">
		<div class="noiDung">
			<form action="" method="post" style="padding-left: 24px; padding-right: 24px; padding-top: 32px;">
	            <div class="themSuaBaiViet">
	                <label>Thể loại</label>
	                <select name="theLoai">
	                    <option value="">Chọn thể loại</option>
	                    <option value=""></option>
	                </select>
	            </div>
	            <div class="themSuaBaiViet">
	                <label>Tiêu đề</label>
	                <input type="text" class="khoi1" name="title" required>
	            </div>
	            <div class="themSuaBaiViet">
	                <label>Tóm tắt</label>
	                <textarea class="khoi1" name="shortDescription" rows="3" required></textarea>
	            </div>
	            <div class="themSuaBaiViet">
	                <label>Nội dung</label>
	                <textarea class="khoi1" name="content" rows="20" required></textarea>
	                <script>
	                    CKEDITOR.replace('content')
	                </script>
	            </div>
	            <div class="themSuaBaiViet">
	                <button type="submit" class="btn btn-primary">ADD</button>
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