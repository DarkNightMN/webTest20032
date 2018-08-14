package daoImpl;

import com.mysql.cj.api.jdbc.Statement;
import dao.LanguageDao;
import pojo.Film;
import pojo.Language;
import tools.MysqlConnect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @ Author: xin
 * @ Date: 2018/8/13 21:38
 */
public class LanguageImpl implements LanguageDao {

    @Override
    public Language[] selectLanguage() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = MysqlConnect.getConnection();
        ArrayList<Language> languages = new ArrayList<>();
        String sql = "select * from language";


        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet result = pst.executeQuery();
        try {
            while (result.next()) {
                Language language = new Language(result.getInt("language_id"), result.getString("name"));
                languages.add(language);
            }
            return languages.toArray(new Language[0]);
        } finally {
            result.close();
            pst.close();
            connection.close();
        }
    }
}
