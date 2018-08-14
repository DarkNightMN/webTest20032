<%--
  Created by IntelliJ IDEA.
  User: GuoYinxin
  Date: 2018/8/13
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>电影租赁系统</title>
</head>
<body>
<div style="margin:150px auto 0;width:500px;border:blue solid 1px">
    <h1>系统主要功能</h1>
    <ol>
        <li><a href="/view/login.jsp">跳转到登录页</a></li>
        <ul>
            <li>登录页为login.jsp</li>
        </ul>
        <li>验证登录用户名
            <ul>
                <li>在login.jsp进行非空验证</li>
                <li>在LoginServlet进行用户名正确性的验证</li>
            </ul>
        </li>
        <li>film表增删改查
            <ul>
                <li>在film.jsp页面展示列表，可以直接删除</li>
                <li>添加和更新跳转到addFilm页面操作</li>
            </ul>
        </li>
        <li>filter过滤
            <ul>
                <li>除了首页和登录页，过滤request.getParameter("user")非空的页面</li>
            </ul>
        </li>
    </ol>
</div>
</body>
</html>
