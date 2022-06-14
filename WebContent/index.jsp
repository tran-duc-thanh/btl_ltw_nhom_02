<%@page import="com.ptit.btl_ltw.model.BaiViet"%>
<%@page import="java.util.List"%>
<%@page import="com.ptit.btl_ltw.model.NguoiDung"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

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
    <a href="" class="chonVao">Trang chủ</a>
    <a href="theLoai.jsp">Bài viết</a>
    <% NguoiDung nguoiDung = (NguoiDung) request.getAttribute("nguoiDung"); %>
    <a href="dangNhap.jsp"><%
    	if (nguoiDung != null){
    		out.print(nguoiDung.getTen());
    	} else {
    		out.print("Đăng Nhập");
    	}
    %></a>
</nav>

<div class="thanTrang">
    <div class="noiDung">
        <section>
            <h2>Chào mừng bạn đến với trang tin tức của chúng tôi</h2>
            <br>
            <h3>Chúng tôi rất vui khi được chia sẽ nhưng tin mới nhất cho bạn!</h3>
            <p>Hãy chọn một mục để xem.</p>
        </section>
        <%
        List<BaiViet> dsBaiViet  = (List<BaiViet>) request.getAttribute("dsBaiViet");
        int i;
        for (i = 0; i < dsBaiViet.size(); i++) {
        	out.print("<section><a href='chiTiet.jsp'><h2>" + dsBaiViet.get(i).getTieuDe() + "</h2></a><br><h3>" + dsBaiViet.get(i).getTomTat() + "</h3></section>");
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