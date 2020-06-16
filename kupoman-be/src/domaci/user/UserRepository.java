package domaci.user;

import domaci.enums.PrivilegeLevel;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static List<UserEntity> USER_LIST;

    static {
        USER_LIST = generateUsers();
    }

    private static List<UserEntity> generateUsers() {
        List<UserEntity> users = new ArrayList<>();

        UserEntity userEntity = new UserEntity();
        userEntity.setId((long) 1);
        userEntity.setUsername("slatt");
        userEntity.setPassword("slatt");
        userEntity.setFirstName("Milan");
        userEntity.setLastName("Mitic");
        userEntity.setPrivilegeLevel(PrivilegeLevel.ADMINISTRATOR);
        users.add(userEntity);

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setId((long) 2);
        userEntity1.setUsername("slime");
        userEntity1.setPassword("slime");
        userEntity1.setFirstName("Marko");
        userEntity1.setLastName("Vukicevic");
        userEntity1.setPrivilegeLevel(PrivilegeLevel.OPERATOR);
        users.add(userEntity1);

        return users;
    }


    public synchronized static List<UserEntity> getUsers() {
        return USER_LIST;
    }

    public synchronized static void addUser(UserEntity userEntity){
        USER_LIST.add(userEntity);
    }
}
