package tools;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ Author: xin
 * @ Date: 2018/8/13 13:46
 */
public class MysqlConnect {
    public static Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
        Properties properties=new Properties();
        InputStream is=MysqlConnect.class.getClassLoader().getResourceAsStream("db.properties");
        properties.load(is);
        String driver=properties.getProperty("driver");
        String url=properties.getProperty("url");
        String user=properties.getProperty("username");
        String password=properties.getProperty("password");

        Class.forName(driver);
        Connection connection=DriverManager.getConnection(url,user,password);
        return connection;
    }
}
