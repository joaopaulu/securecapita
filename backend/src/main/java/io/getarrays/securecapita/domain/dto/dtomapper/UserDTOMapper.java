package io.getarrays.securecapita.domain.dto.dtomapper;

import io.getarrays.securecapita.domain.dto.UserDTO;
import io.getarrays.securecapita.domain.model.User;
import org.springframework.beans.BeanUtils;

public class UserDTOMapper {
    public static UserDTO fromUser(User user){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
    public static User toUser(UserDTO userDTO){
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }
}
