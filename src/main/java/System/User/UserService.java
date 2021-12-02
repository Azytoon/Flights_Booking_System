package System.User;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserDataAccessService userDataAccessService;

    public UserService(UserDataAccessService UserDataAccessService) {
			this.userDataAccessService = UserDataAccessService;
	}

    public List<User> getAllUsers() {
        return userDataAccessService.selectAllUsers();
    }

    public void addNewUser(User user) {
        addNewUser(null, user);
    }

    void addNewUser(UUID userId, User user) {
        UUID newUserId = Optional.ofNullable(userId)
                .orElse(UUID.randomUUID());

        userDataAccessService.insertUser(newUserId, user);
    }
    public void updateUser(UUID userId, User updatedUser) {
        Optional.ofNullable(updatedUser.getName())
                .filter(Name -> Name!= null)
                .map(StringUtils::capitalize)
                .ifPresent(Name -> userDataAccessService.updateName(userId, Name));        
    }
    public void deleteStudent(UUID userId) {
        userDataAccessService.deleteUserById(userId);
    }
}
