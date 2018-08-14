<%--
  Created by IntelliJ IDEA.
  User: GuoYinxin
  Date: 2018/8/13
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div style="text-align:center;margin-top:150px ">
    <form action="/login" method="post" onsubmit="return test()">
        用户名：<input name="user" id="user"><br>
        <button type="submit" class="btn btn-primary btn-lg" style="margin-top:20px">登录</button>
        <%
            if (request.getAttribute("message") != null) {
        %><h4 id="wrongName" style="display:block;color:red"><%=request.getAttribute("message")%>
    </h4><%
        }
        ;
    %>

        <h4 id="nullName" style="display: none;color:red">登录失败，用户名不能为空</h4>
    </form>
</div>
</body>
<script>
    function test() {
        var name = document.getElementById("user").value;
        if (name === "" || name === null) {
            document.getElementById("nullName").style.display = "block";
            if(document.getElementById("wrongName")!==null){
                document.getElementById("wrongName").style.display = "none";
            }
            document.getElementById("user").focus();
            return false;
        }
        return true;
    };

</script>

</html>

