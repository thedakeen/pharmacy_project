package pharmacy.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;
@Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void signUp(String username, String password){
        jdbcTemplate.update("INSERT INTO users(username,password) VALUES (?,?)",username,password);
    }

    public boolean isUserExists(String username){
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users WHERE username=?",Integer.class,username);
        return count != null && count > 0;
    }


    public boolean signIn(String username, String password){
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users WHERE username=? AND password=?", Integer.class,username,password);
        return count != null && count > 0;
    }

    public void deleteUser(String username, String password) {
        jdbcTemplate.update("DELETE FROM users WHERE username=? AND password=?", username, password);
    }




}
