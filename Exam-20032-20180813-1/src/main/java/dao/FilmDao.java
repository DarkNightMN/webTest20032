package dao;

import pojo.Film;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @ Author: xin
 * @ Date: 2018/8/13 15:29
 */
public interface FilmDao {
    //查列表
    Film[] selectFilm() throws SQLException, IOException, ClassNotFoundException;

    //查ID
    Film getFilm(int id) throws SQLException, IOException, ClassNotFoundException;

    //增
    void insertFilm(Film film) throws SQLException, IOException, ClassNotFoundException;

    //删
    void deleteFilm(int id) throws SQLException, IOException, ClassNotFoundException;

    //改
    void updateFilm(Film film) throws SQLException, IOException, ClassNotFoundException;

}
