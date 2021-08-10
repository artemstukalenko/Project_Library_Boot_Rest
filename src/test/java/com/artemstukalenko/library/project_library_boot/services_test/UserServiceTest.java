package com.artemstukalenko.library.project_library_boot.services_test;

import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.entity.UserDetails;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    User userForTest;

    @Before
    public void addUserForTestToDB() {
        userForTest = new User("test", "test");
        userService.registerUser(userForTest);
    }

    @After
    public void deleteUserForTestFromDB() {
        userService.deleteUser(userForTest.getUsername());
    }

    @Test
    public void testGetAllUsers() {
        userService.getAllUsers();
    }

    @Test
    public void testBlockUser() {
        Assert.assertTrue(userService.blockUser(userForTest.getUsername()));
    }

    @Test
    public void testUnblockUser() {
        Assert.assertTrue(userService.unblockUser(userForTest.getUsername()));
    }

    @Test
    public void testGetUserRole() {
        Assert.assertTrue(userService.getUserRole(userForTest.getUsername()).equals("ROLE_USER"));
    }

    @Test
    public void testFindUserByUsername() {
        Assert.assertTrue(userForTest.equals(
                userService.findUserByUsername(userForTest.getUsername())
        ));
    }

    @Test
    public void testUpdateUser() {
        userForTest.setPassword("Qwerty123");
        userService.updateUser(userForTest);
        Assert.assertTrue(userForTest.equals(userService.findUserByUsername(userForTest.getUsername())));
    }

    @Test
    public void testDeleteUser() {
        Assert.assertTrue(userService.deleteUser(userForTest.getUsername()));
    }

    @Test
    public void testMakeUserLibrarian() {
        Assert.assertTrue(userService.makeUserLibrarian(userForTest.getUsername()));
    }

    @Test
    public void testDepriveLibrarianPrivileges() {
        Assert.assertTrue(userService.depriveLibrarianPrivileges(userForTest.getUsername()));
    }

    @Test
    public void testUpdatePenaltyInfo() {
        userForTest.setUserDetails(new UserDetails("Test", "Test", "test@test.com",
                "+380670000000", "Test st. 1"));

        final int penaltyBeforeUpdate = userForTest.getUserDetails().getUserPenalty();
        final int updateSum = 10;

        userService.updatePenaltyInfo(userForTest.getUsername(), updateSum);
        Assert.assertTrue(penaltyBeforeUpdate == userForTest.getUserDetails().getUserPenalty());
    }

    @Test
    public void testRegisterUser() {
        userService.deleteUser(userForTest.getUsername());
        Assert.assertTrue(userService.registerUser(userForTest));
    }
}
