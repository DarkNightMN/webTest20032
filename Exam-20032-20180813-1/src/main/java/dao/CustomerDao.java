package dao;

import pojo.Customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ Author: xin
 * @ Date: 2018/8/13 14:20
 */
public interface CustomerDao {

    //login
    Customer getCustomer(String name) throws SQLException, IOException, ClassNotFoundException;
}
