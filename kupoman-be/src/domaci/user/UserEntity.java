package domaci.user;
import domaci.enums.PrivilegeLevel;
import lombok.Data;



@Data
public class UserEntity{
    private Long id;
    private String firstName;
    private String lastName;
    private PrivilegeLevel privilegeLevel;
    private String username;
    private String password;

}