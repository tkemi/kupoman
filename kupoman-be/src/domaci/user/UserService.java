package domaci.user;

import java.util.List;

public class UserService {
    private final UserMapper userMapper;

    public UserService() {
        this.userMapper = new UserMapper();
    }

    public User getUser(User user) {
        List<User> users = userMapper.mapToModelList(UserRepository.getUsers());

        for (User u : users) {
            if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
                return u;
            }
        }
        return null;
    }

    public void makeUser(User user){

        UserRepository.addUser(userMapper.mapToEntity(user));


    }
}
