package servlet;

import daoImpl.CustomerImpl;

import pojo.Customer;
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
 * @ Date: 2018/8/13 11:11
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String name=req.getParameter("user");
            Customer customer=new CustomerImpl().getCustomer(name);

            if (customer!=null){
                req.getRequestDispatcher("/film").forward(req,resp);
            }
            else{
                req.setAttribute("message","登录失败，用户名错误");
                req.getRequestDispatcher("/view/login.jsp").forward(req,resp);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
