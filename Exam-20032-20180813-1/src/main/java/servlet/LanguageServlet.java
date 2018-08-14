package servlet;

import daoImpl.FilmImpl;
import daoImpl.LanguageImpl;
import pojo.Film;
import pojo.Language;
import tools.MysqlConnect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ Author: xin
 * @ Date: 2018/8/13 21:40
 */
public class LanguageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        try {
            Language[] languages=new LanguageImpl().selectLanguage();
            req.setAttribute("languages",languages);
            req.getRequestDispatcher("/view/addFilm.jsp").forward(req,resp);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
