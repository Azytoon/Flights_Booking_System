package System.User;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserDataAccessService {

    private final JdbcTemplate jdbcTemplate;

    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> selectAllUsers() {
        String sql = "" +
                "SELECT " +
                " user_id, " +
                " user_name " +
                "FROM users";

        return jdbcTemplate.query(sql, mapUserFomDb());
    }
    
    public int insertUser(UUID userId, User user) {
        String sql = "" +
                "INSERT INTO users (" +
                " user_id, " +
                " user_name) " +
                "VALUES (?, ?)";
        return jdbcTemplate.update(
                sql,
                userId,
                user.getName()
        );
    }

   
    private RowMapper<User> mapUserFomDb() {
        return (resultSet, i) -> {
            String userIdStr = resultSet.getString("user_id");
            UUID UserId = UUID.fromString(userIdStr);

            String Name = resultSet.getString("user_name");
            
            return new User(
                    UserId,
                    Name
            );
        };
    }

    int updateName(UUID userId, String Name) {
        String sql = "" +
                "UPDATE users " +
                "SET user_name = ? " +
                "WHERE user_id = ?";
        return jdbcTemplate.update(sql, Name, userId);
    }

    public int deleteUserById(UUID UserId) {
        String sql = "" +
                "DELETE FROM users " +
                "WHERE user_id = ?";
        return jdbcTemplate.update(sql, UserId);
    }
}
