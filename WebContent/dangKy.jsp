<%--
  Created by IntelliJ IDEA.
  User: Duc Thanh
  Date: 6/5/2022
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <a href="theLoai.jsp">Bài viết</a>
    <a href="dangNhap.jsp">Đăng nhập</a>
</nav>

<div class="thanTrang thanTrang-hinhNen">
    <div class="noiDung dangKy">
        <section>
            <h2>Chào mừng bạn đến với trang của chúng tôi</h2>
            <br>
            <h3>Vui lòng nhập đầy đủ thông tin để đăng ký.</h3>
        </section>
        <article>
            <form action="" method="post" enctype="multipart/form-data">
                <input type="text" placeholder="Họ tên" required autofocus><br>
                <br>
                <input type="text" placeholder="Tên tài khoản" required><br>
                <br>
                <input type="password" placeholder="Mật khẩu" required><br>
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
