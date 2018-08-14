<%@ page import="pojo.Film" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: GuoYinxin
  Date: 2018/8/13
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<link rel="stylesheet" type="text/css" href="../components/css/bootstrap.min.css">--%>
    <%--<script type="text/javascript" src="../components/js/jquery-3.3.1.min.js"></script>--%>
    <%--<script type="text/javascript" src="../components/js/bootstrap.min.js"></script>--%>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <%--<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>--%>
    <%--<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

</head>
<body>
<div style="margin:150px auto 0;width:500px;">
<%

%>
<%
    Film[] films= (Film[]) request.getAttribute("films");

%>
    <a href="/language?user=<%=request.getParameter("user")%>&operation=add" style="margin-left: 0">
        <button class="btn btn-primary btn-lg">添加电影</button></a>

    <table border="1" style="margin:10px 0">
        <tr>
            <th>ID</th>
            <th>电影名称</th>
            <th>电影简介</th>
            <th>语言</th>
            <th>操作</th>
        </tr>
        <%
        for(Film film:films){
        %>
        <tr>
            <td><%=film.getFilmId()%></td>
            <td><%=film.getTitle()%></td>
            <td><%=film.getDescription()%></td>
            <td><%=film.getLanguageName()%></td>
            <th>
                <a href="/film?user=<%=request.getParameter("user")%>&id=<%=film.getFilmId()%>&operation=update">
                    <button class="btn btn-primary btn-lg">编辑</button></a>
                <a href="/film?user=<%=request.getParameter("user")%>&id=<%=film.getFilmId()%>&operation=del">
                <button class="btn btn-primary btn-lg">删除</button></a>
            </th>
        </tr>
        <%
        }
        %>

    </table>
</div>
