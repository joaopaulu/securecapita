package io.getarrays.securecapita.repository.implementation;

import io.getarrays.securecapita.domain.model.Role;
import io.getarrays.securecapita.domain.model.User;
import io.getarrays.securecapita.exception.ApiException;
import io.getarrays.securecapita.repository.RoleRepository;
import io.getarrays.securecapita.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

import static io.getarrays.securecapita.domain.enumeration.RoleType.ROLE_USER;
import static io.getarrays.securecapita.query.UserQuery.COUNT_USER_EMAIL_QUERY;
import static io.getarrays.securecapita.query.UserQuery.INSERT_USER_QUERY;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository<User> {

    private final NamedParameterJdbcTemplate jdbc;

    private final RoleRepository<Role> roleRepository;

    @Override
    public User create(User user) {
        if(getEmailCount(user.getEmail().trim().toLowerCase()) > 0){
            throw new ApiException("Email already in use. Please use a different email and try again");
        }
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource parameterSource = getSqlParameterSource(user);
            jdbc.update(INSERT_USER_QUERY, parameterSource, holder);
            user.setId(Objects.requireNonNull(holder.getKey()).longValue());
            roleRepository.addRoleToUser(user.getId(), ROLE_USER.name());
        }catch (EmptyResultDataAccessException exception){

        }
        return null;
    }

    @Override
    public Collection<User> list(int page, int pageSize) {
        return null;
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public User update(User data) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    private Integer getEmailCount(String email){
        return jdbc.queryForObject(COUNT_USER_EMAIL_QUERY, Map.of("email", email), Integer.class);
    }

    private SqlParameterSource getSqlParameterSource(User user){
        return null;
    }
}
