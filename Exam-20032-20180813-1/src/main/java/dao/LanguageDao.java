package dao;

import pojo.Language;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ Author: xin
 * @ Date: 2018/8/13 21:37
 */
public interface LanguageDao {
    //查
    Language[] selectLanguage() throws SQLException, IOException, ClassNotFoundException;

}
