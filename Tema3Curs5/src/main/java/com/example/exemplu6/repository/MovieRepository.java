package com.example.exemplu6.repository;

import com.example.exemplu6.model.Movie;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addMovie(Movie movie) {
        String query = "INSERT INTO movie (id, title, genre, rating) VALUES (?, ?, ?, ?)";

        movie.setId(getMaxId() + 1);

        System.out.println("Movie added!");
        return jdbcTemplate.update(query, movie.getId(), movie.getTitle(), movie.getGenre(), movie.getRating());
    }

    public List<Movie> getAllMovies() {
        String query = "SELECT * FROM movie";

        return jdbcTemplate.query(query, new MovieRowMapper());
    }

    public Movie getById(int id) {
        String query = "SELECT * FROM movie WHERE id = ?";

        if(existId(id).equals("Yes")) {
            return jdbcTemplate.queryForObject(query, new MovieRowMapper(), id);
        } else {
            System.out.println("Movie with id = " + id + " doesn't exist in database!");
            return null;
        }
    }

    public int updateMovie(int id, int rating) {
        String query = "UPDATE movie SET rating = ? where id = ?";

        if(existId(id).equals("Yes")) {
            System.out.println("Movie with id = " + id + " updated!");
            return jdbcTemplate.update(query, rating, id);
        } else {
            System.out.println("Movie with id = " + id + " doesn't exist in database!");
            return 0;
        }
    }

    public int deleteMovie(int id) {
        String query = "DELETE FROM movie WHERE id = ?";

        if(existId(id).equals("Yes")) {
            System.out.println("Movie with id = " + id + " deleted!");
            return jdbcTemplate.update(query, id);
        } else {
            System.out.println("Movie with id = " + id + " doesn't exist in database!");
            return 0;
        }
    }

    private int getMaxId() {
        int maxId;

        if(!getIdList().isEmpty()) {
            maxId = getIdList().get(0);
            for(int i = 1; i < getIdList().size(); i++) {
                if(getIdList().get(i) > maxId) {
                    maxId = getIdList().get(i);
                }
            }
        } else {
            maxId = 0;
        }

        return maxId;
    }

    private List<Integer> getIdList() {
        String query = "SELECT id FROM movie";

        return jdbcTemplate.queryForList(query, Integer.class);
    }

    private String existId(int id) {
        String exist = "No";

        for(int i : getIdList()) {
            if(i == id) {
                exist = "Yes";
            }
        }

        return exist;
    }

    protected class MovieRowMapper implements RowMapper<Movie> {
        @Override
        public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
            Movie movie = new Movie();
            movie.setId(resultSet.getInt(1));
            movie.setTitle(resultSet.getString(2));
            movie.setGenre(resultSet.getString(3));
            movie.setRating(resultSet.getInt(4));

            return movie;
        }
    }
}
