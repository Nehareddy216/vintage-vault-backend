package com.vintagevault.service;

import java.util.List;

import com.vintagevault.dto.AdminUserResponse;


public interface AdminService {


    // View all users
    List<AdminUserResponse> getAllUsers();


    // View users by role
    List<AdminUserResponse> getUsersByRole(
            String role
    );


    // Delete user
    String deleteUser(
            Long userId
    );

}