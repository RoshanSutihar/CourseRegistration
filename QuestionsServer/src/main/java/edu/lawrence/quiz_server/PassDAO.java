
package edu.lawrence.quiz_server;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class PassDAO {
     @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Pass> findByQuiz(int crn) {
	String sql = "SELECT * FROM courses WHERE crn=?";
        RowMapper<Pass> rowMapper = new PassRowMapper();
        return jdbcTemplate.query(sql, rowMapper, crn);
    }
}
