package io.getarrays.securecapita.service;

import io.getarrays.securecapita.domain.dto.UserDTO;
import io.getarrays.securecapita.domain.model.User;

public interface UserService {
    UserDTO createUser(User user);
}
