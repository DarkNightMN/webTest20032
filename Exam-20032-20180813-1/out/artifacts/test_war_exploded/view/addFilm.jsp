<%@ page import="pojo.Language" %>
<%@ page import="pojo.Film" %><%--
  Created by IntelliJ IDEA.
  User: GuoYinxin
  Date: 2018/8/13
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<div style="margin:150px auto;width: 30%;border:blue solid 1px">

    <h3 style="text-align: center">
        <%
            String operation = request.getParameter("operation");
            if (operation.equals("add")) {
        %>
        添加电影<%
    } else {
    %>编辑电影<%
        }
    %>

        <%
            Object film = request.getAttribute("film");
            Film film1 = null;
            if (film != null) {
                film1 = (Film) film;
            }
        %>
    </h3>
    <form
                <%
                if (request.getParameter("operation").equals("add")){
                    %>action=<%="/film?user="+request.getParameter("user")+"&operation=add"%>
            <%
        }else{
            %>action=<%="/film?user=" + request.getParameter("user") + "&operation=updateFilm&id=" + film1.getFilmId()%>
            <%
                }
            %>
                method="post" onsubmit="return test()">
        <div style="margin-top:10px;margin-left: 10px">电影名称：
            <input name="title" id="title"
                   <%
                   if(film1!=null){
                       %>value=<%=film1.getTitle()%><%
                   }
                   %>
                   >
        </div>
        <br>
        <div style="margin-top:10px;margin-left: 10px">电影简介：
            <input name="description" id="description" <%
                   if(film1!=null){
                       %>value=<%=film1.getDescription()%><%
                   }
                   %>
            >
        </div>
        <br>
        <div style="margin-top:10px;margin-left: 10px">语言：
            <select id="language" name="language">
                <%
                    Language[] languages = (Language[]) request.getAttribute("languages");
                    for (Language l : languages) {
                %>
                <option <%
                            if(film1!=null&& film1.getLanguageId()==l.getLanguageId()){
                                %>selected="selected"<%
                    }
                %>
                        value=<%=l.getLanguageId()%>><%=l.getName()%>
                </option>
                <%
                    }
                %>
            </select>
        </div>
        <br>
        <button class="btn btn-primary btn-lg" style="margin-left: 20px" type="submit">保存</button>
    </form>
    <a href="/film?user=<%=request.getParameter("user")%>">
        <button class="btn btn-primary btn-lg" style="margin-left: 20px">取消</button>
    </a>
    <h4 id="nullTitle" style="display: none;color:red">保存失败，电影名称不能为空</h4>
    <h4 id="nullDesc" style="display: none;color:red">保存失败，电影简介不能为空</h4>

</div>
</body>
</html>
<script>
    function test() {
        var title = document.getElementById("title").value;
        var description = document.getElementById("description").value;
        if (title === "" || title === null) {
            document.getElementById("nullTitle").style.display = "block";
            document.getElementById("nullDesc").style.display = "none";
            document.getElementById("title").focus();
            return false;
        }
        if (description === "" || description === null) {
            document.getElementById("nullDesc").style.display = "block";
            document.getElementById("nullTitle").style.display = "none";
            document.getElementById("description").focus();
            return false;
        }
        return true;
    };

</script>