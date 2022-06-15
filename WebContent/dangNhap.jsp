<%--
  Created by IntelliJ IDEA.
  User: Duc Thanh
  Date: 6/5/2022
  Time: 9:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.ptit.btl_ltw.model.TheLoai"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="./css/css.css">
    <title>Tin tức | Đăng nhập</title>
</head>
<body>
<header>
    <h1>Đăng nhập</h1>
</header>

<nav>
    <a href="" class="chonVao">Trang chủ</a>
	<%
		List<TheLoai> dsTheLoai = (List<TheLoai>) request.getAttribute("dsTheLoai");
		for (int i = 0; i < dsTheLoai.size(); i++) {
			out.print("<a href='theLoai?id=" + dsTheLoai.get(i).getId() + "'>"+ dsTheLoai.get(i).getTen() +"</a>");
		}
	%>
</nav>

<div class="thanTrang thanTrang-hinhNen">
    <div class="noiDung dangNhap">
        <section>
            <h2>Chào mừng bạn đến với trang của chúng tôi</h2>
            <br>
            <h3>Vui lòng đăng nhập hoặc đăng ký.</h3>
        </section>
        <article class="locin">
            <form action="dangNhap" method="post">
                <input type="text" name="taiKhoan" placeholder="tài khoản" required autofocus><br>
                <br/>
                <input type="password" name="matKhau" placeholder="mật khẩu" required><br>
                <br>
                <button type="submit">Đăng nhập</button>
                <br/>
                <br/>
                <p>Bạn chưa có tài khoản? <a href="dangKy" style="color: #d36d00;">Đăng ký ngay!</a></p>
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
