package System.User;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public String addNewUser(@RequestBody  User user) {
        userService.addNewUser(user);
        return "User Added Successfully";
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") UUID userId,
                              @RequestBody User updatedUser) {
        userService.updateUser(userId, updatedUser);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable("userId") UUID userId) {
        userService.deleteStudent(userId);
    }

}
