package domaci.user;

import domaci.enums.PrivilegeLevel;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private PrivilegeLevel privilegeLevel;
    private String username;
    private String password;

}
