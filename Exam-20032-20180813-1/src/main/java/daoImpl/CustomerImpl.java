package daoImpl;

import dao.CustomerDao;
import pojo.Customer;
import tools.MysqlConnect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ Author: xin
 * @ Date: 2018/8/13 14:22
 */
public class CustomerImpl implements CustomerDao {

    public Customer getCustomer(String name) throws SQLException, IOException, ClassNotFoundException {

        Connection connection=MysqlConnect.getConnection();
        String sql = "select first_name from customer where first_name=?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, name);
        ResultSet result = pst.executeQuery();
        try{
            while (result.next()) {
                Customer customer = new Customer(result.getString("first_name"));
                return customer;
            }
        }finally{
            result.close();
            pst.close();
            connection.close();
        }
        return null;
    }
}
