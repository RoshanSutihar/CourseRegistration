
package edu.lawrence.quiz_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ResponseDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public String save(Response response) {

        String insertSQL = "INSERT INTO registrations(crn  ,id ) values (?, ?)";
        jdbcTemplate.update(insertSQL, response.getCrn(),response.getId());
        return "saved";
        
    }
}