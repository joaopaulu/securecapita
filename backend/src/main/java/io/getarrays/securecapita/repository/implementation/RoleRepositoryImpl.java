package io.getarrays.securecapita.repository.implementation;

import io.getarrays.securecapita.domain.model.Role;
import io.getarrays.securecapita.exception.ApiException;
import io.getarrays.securecapita.repository.RoleRepository;
import io.getarrays.securecapita.rowmapper.RoleRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

import static io.getarrays.securecapita.constant.RoleExceptionConstant.ROLE_NOT_FOUND;
import static io.getarrays.securecapita.constant.UserExceptionConstant.ERROR_OCCURRED;
import static io.getarrays.securecapita.domain.enumeration.RoleType.ROLE_USER;
import static io.getarrays.securecapita.query.RoleQuery.*;
import static java.util.Objects.requireNonNull;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RoleRepositoryImpl implements RoleRepository<Role> {
    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public Role create(Role data) {
        return null;
    }

    @Override
    public Collection<Role> list(int page, int pageSize) {
        return null;
    }

    @Override
    public Role get(Long id) {
        return null;
    }

    @Override
    public Role update(Role data) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public void addRoleToUser(Long userId, String roleName) {
        log.info("Adding role {} to user id: {}", roleName, userId);
        try {
            Role role = jdbc.queryForObject(SELECT_ROLE_BY_NAME_QUERY, Map.of("roleName", roleName), new RoleRowMapper());
            jdbc.update(INSERT_ROLE_TO_USER_QUERY, Map.of("userId", userId, "roleId", requireNonNull(role).getId()));

        } catch (
                EmptyResultDataAccessException exception) {
            throw new ApiException(String.format(ROLE_NOT_FOUND, ROLE_USER.name()));
        } catch (Exception exception) {
            throw new ApiException(ERROR_OCCURRED);
        }
    }


    @Override
    public Role getRoleByUserId(Long userId) {
        return null;
    }

    @Override
    public Role getRoleByUserEmail(String eemail) {
        return null;
    }

    @Override
    public void updateUserRole(Long userId, String roleName) {

    }
}
