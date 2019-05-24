package com.example.exemplu6.repository;

import com.example.exemplu6.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

        return jdbcTemplate.queryForObject(query, new MovieRowMapper(), id);
    }

    public int updateMovie(Movie movie) {
        String query = "UPDATE movie SET title = ?, genre = ?, rating = ? where id = ?";

        return jdbcTemplate.update(query, movie.getTitle(), movie.getGenre(), movie.getRating(), movie.getId());
    }

    public int deleteMovie(int id) {
        String query = "DELETE FROM movie WHERE id = ?";

        return jdbcTemplate.update(query, id);
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

//    private boolean existId(int id) {
//        String query = "SELECT id FROM movie";
//
//        return jdbcTemplate.queryForList(query, Integer.class).contains(id);
//    }

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
