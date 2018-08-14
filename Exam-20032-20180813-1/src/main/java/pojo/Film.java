package pojo;

/**
 * @ Author: xin
 * @ Date: 2018/8/13 15:27
 */
public class Film {
    private int filmId;
    private String title;
    private String description;
    private int languageId;
    private String languageName;

    public Film(int filmId, String title, String description, int languageId) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.languageId = languageId;
    }

    public Film(String title, String description, int languageId) {
        this.title = title;
        this.description = description;
        this.languageId = languageId;
    }

    public Film(int filmId, String title, String description, int languageId, String languageName) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.languageId = languageId;
        this.languageName = languageName;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Film(Object o, String title, String description, int i) {
    }


    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
