package com.artemstukalenko.library.project_library_boot.dao;

import com.artemstukalenko.library.project_library_boot.entity.Authority;
import com.artemstukalenko.library.project_library_boot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        Query queryForGettingAllUsers = entityManager.createQuery("from User where username not in (from Authority where authority = 'ROLE_ADMIN')");

        return queryForGettingAllUsers.getResultList();
    }

    @Override
    public void blockUser(String username) {
        Query queryForBlockingUser = entityManager.createQuery("update User set enabled = 0 where username =: userUsername");

        queryForBlockingUser.setParameter("userUsername", username);
        queryForBlockingUser.executeUpdate();
    }

    @Override
    public void unblockUser(String username) {
        Query queryForUnblockingUser = entityManager.createQuery("update User set enabled = 1 where username =: userUsername");

        queryForUnblockingUser.setParameter("userUsername", username);
        queryForUnblockingUser.executeUpdate();
    }

    @Override
    @Transactional
    public String getUserRole(String username) {
        Query queryForGettingUserRole = entityManager.createQuery("select authority from Authority where username in " +
                "(select username from User where username =: usernameForSearch)");

        queryForGettingUserRole.setParameter("usernameForSearch", username);
        return (String) queryForGettingUserRole.getSingleResult();

    }

    @Override
    @Transactional
    public User findUserByUsername(String username) {
        return entityManager.find(User.class, username);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
        deleteAuthority(username);

        deleteUserDetails(username);

        Query queryForDeletingUser = entityManager.createQuery("delete from User where username =: username");
        queryForDeletingUser.setParameter("username", username);
        queryForDeletingUser.executeUpdate();
    }

    @Transactional
    protected void deleteAuthority(String username) {
        Query queryForDeletingAuthority = entityManager.createQuery("delete from Authority where username =: username");
        queryForDeletingAuthority.setParameter("username", username);
        queryForDeletingAuthority.executeUpdate();
    }

    @Transactional
    protected void deleteUserDetails(String username) {
        Query queryForDeletingUserDetails = entityManager.createQuery("delete from UserDetails where username =: username");
        queryForDeletingUserDetails.setParameter("username", username);
        queryForDeletingUserDetails.executeUpdate();
    }

    @Override
    @Transactional
    public void registerUser(User user) {
        Authority newUserAuthority = new Authority(user.getUsername(), "ROLE_USER");

        user.setPassword(getEncodedPassword(user.getPassword()));

        entityManager.persist(user);
        entityManager.persist(newUserAuthority);
    }

    public String getEncodedPassword(String rawPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

        return "{bcrypt}" + encoder.encode(rawPassword);
    }
}
