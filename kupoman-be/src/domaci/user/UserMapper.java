package domaci.user;

import domaci.util.Random;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public UserEntity mapToEntity(User user){
        if(user == null){
            return null;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setPrivilegeLevel(user.getPrivilegeLevel());
        return userEntity;
    }

    public User mapToModel(UserEntity userEntity){
        if(userEntity == null){
            return null;
        }

        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setPrivilegeLevel(userEntity.getPrivilegeLevel());
        return user;
    }

    public List<User> mapToModelList(List<UserEntity> userEntities) {
        if(userEntities == null){
            return null;
        }
        return userEntities.stream().map(this::mapToModel).collect(Collectors.toList());
    }

}
