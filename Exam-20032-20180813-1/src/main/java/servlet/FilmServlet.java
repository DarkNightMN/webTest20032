package servlet;

import daoImpl.FilmImpl;
import pojo.Film;
import tools.MysqlConnect;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ Author: xin
 * @ Date: 2018/8/13 15:50
 */
public class FilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        try {
            //删
            String idString=req.getParameter("id");
            String operation=req.getParameter("operation");

            int id=0;
            if(idString!=null){
                id=Integer.parseInt(idString);
            }
            if(operation !=null&&operation.equals("del")){
                new FilmImpl().deleteFilm(id);
            }

            String title=req.getParameter("title");
            String description=req.getParameter("description");
            String languageId=req.getParameter("language");

            //查询要更改的film信息
            if(operation !=null&&operation.equals("update")){
                Film film1=new FilmImpl().getFilm(id);
                req.setAttribute("film",film1);
                req.getRequestDispatcher("/language").forward(req,resp);
            }
            //改
            if(operation !=null&&operation.equals("updateFilm")){
                System.out.println(id);
                Film film1=new Film(id,title,description,Integer.parseInt(languageId));
                new FilmImpl().updateFilm(film1);
                req.getRequestDispatcher("/film?operation=null").forward(req,resp);
            }

            //增
            if(title!=null && description!=null && languageId!=null && operation!=null &&operation.equals("add")){
                Film film2=new Film(title,description,Integer.parseInt(languageId));
                new FilmImpl().insertFilm(film2);
            }

            //查列表
            Film[] films=new FilmImpl().selectFilm();
            req.setAttribute("films",films);
            req.getRequestDispatcher("/view/film.jsp").forward(req,resp);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
