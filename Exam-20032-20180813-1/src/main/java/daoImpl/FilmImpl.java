package daoImpl;

import dao.FilmDao;
import pojo.Film;
import tools.MysqlConnect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @ Author: xin
 * @ Date: 2018/8/13 15:32
 */
public class FilmImpl implements FilmDao {

    @Override
    public Film[] selectFilm() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = MysqlConnect.getConnection();
        ArrayList<Film> films = new ArrayList<>();
        String sql = "select f.film_id,f.title,f.description,f.language_id,l.name from film f,language l where f.language_id=l.language_id";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet result = pst.executeQuery();
        try {
            while (result.next()) {
                Film film = new Film(result.getInt("film_id"), result.getString("title"),
                        result.getString("description"), result.getInt("language_id"),
                        result.getString("name"));
                films.add(film);
            }
            return films.toArray(new Film[0]);
        } finally {
            result.close();
            pst.close();
            connection.close();
        }
    }

    @Override
    public Film getFilm(int id) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = MysqlConnect.getConnection();
        String sql = "select film_id,title,description,language_id from film where film_id=?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet result = pst.executeQuery();
        try {
            while (result.next()) {
                Film film = new Film(result.getInt("film_id"), result.getString("title"),
                        result.getString("description"), result.getInt("language_id"));
                return film;
            }
        } finally {
            result.close();
            pst.close();
            connection.close();
        }
        return null;
    }

    @Override
    public void insertFilm(Film film) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = MysqlConnect.getConnection();
        String sql = "insert into film values (?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        try {
            pst.setInt(1, film.getFilmId());
            pst.setString(2, film.getTitle());
            pst.setString(3, film.getDescription());
            pst.setInt(4, film.getLanguageId());
            pst.execute();
        } finally {
            pst.close();
            connection.close();
        }
    }

    @Override
    public void deleteFilm(int id) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = MysqlConnect.getConnection();
        String sql = "delete from film where film_id=?";
        PreparedStatement pst = connection.prepareStatement(sql);
        try {
            pst.setInt(1, id);
            pst.execute();

        } finally {
            pst.close();
            connection.close();
        }
    }

    @Override
    public void updateFilm(Film film) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = MysqlConnect.getConnection();
        System.out.println(film.getFilmId()+film.getTitle());
        String sql = "update film set title=?,description=?,language_id=? where film_id=?";
        PreparedStatement pst = connection.prepareStatement(sql);
        
        try {
            pst.setString(1, film.getTitle());
            pst.setString(2, film.getDescription());
            pst.setInt(3, film.getLanguageId());
            pst.setInt(4, film.getFilmId());
            System.out.println(pst);
            pst.execute();

        } finally {
            pst.close();
            connection.close();
        }
    }
}
