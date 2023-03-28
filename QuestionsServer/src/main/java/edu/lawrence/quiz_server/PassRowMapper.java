
package edu.lawrence.quiz_server;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PassRowMapper implements RowMapper<Pass>  {
     @Override
    public Pass mapRow(ResultSet row, int rowNum) throws SQLException {
        Pass q = new Pass();
   
        q.setCrn(row.getInt("crn"));
      q.setSeats(row.getInt("seats"));
        q.setEnrolled(row.getInt("enrolled"));
        return q;
    }
    
}
