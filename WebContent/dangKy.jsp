<%--
  Created by IntelliJ IDEA.
  User: Duc Thanh
  Date: 6/5/2022
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.ptit.btl_ltw.model.TheLoai"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="./css/css.css">
    <title>Tin tức | Đăng ký</title>
</head>
<body>
<header>
    <h1>Đăng ký</h1>
</header>

<nav>
    <a href="" class="chonVao">Trang chủ</a>
	<%
		List<TheLoai> dsTheLoai = (List<TheLoai>) request.getAttribute("dsTheLoai");
		for (int i = 0; i < dsTheLoai.size(); i++) {
			out.print("<a href='theLoai?id=" + dsTheLoai.get(i).getId() + "'>"+ dsTheLoai.get(i).getTen() +"</a>");
		}
	%>
    <a href="dangNhap">Đăng nhập</a>
</nav>

<div class="thanTrang thanTrang-hinhNen">
    <div class="noiDung dangKy">
        <section>
            <h2>Chào mừng bạn đến với trang của chúng tôi</h2>
            <br>
            <h3>Vui lòng nhập đầy đủ thông tin để đăng ký.</h3>
        </section>
        <article>
            <form action="dangKy" method="post">
                <input type="text" name="hoTen" placeholder="Họ tên" required autofocus><br>
                <br>
                <input type="text" name="taiKhoan" placeholder="Tên tài khoản" required><br>
                <br>
                <input type="password" name="matKhau" placeholder="Mật khẩu" required><br>
                <br>
                <button type="submit">Đăng ký</button>
                <input type="reset" value="Làm mới">
            </form>
        </article>
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
