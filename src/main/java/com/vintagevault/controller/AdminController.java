package com.vintagevault.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vintagevault.dto.AdminUserResponse;
import com.vintagevault.service.AdminService;



@RestController
@RequestMapping("/api/admin")
public class AdminController {


    private final AdminService adminService;



    public AdminController(
            AdminService adminService) {

        this.adminService = adminService;

    }



    // Get all users
    @GetMapping("/users")
    public ResponseEntity<List<AdminUserResponse>> getAllUsers() {


        return ResponseEntity.ok(
                adminService.getAllUsers()
        );

    }




    // Get users by role
    @GetMapping("/users/{role}")
    public ResponseEntity<List<AdminUserResponse>> getUsersByRole(
            @PathVariable String role) {


        return ResponseEntity.ok(
                adminService.getUsersByRole(role)
        );

    }





    // Delete user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable Long id) {


        return ResponseEntity.ok(
                adminService.deleteUser(id)
        );

    }

}