package com.vintagevault.serviceimpl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vintagevault.dto.AdminUserResponse;
import com.vintagevault.entity.User;
import com.vintagevault.repository.UserRepository;
import com.vintagevault.service.AdminService;



@Service
public class AdminServiceImpl implements AdminService {


    private final UserRepository userRepository;



    public AdminServiceImpl(
            UserRepository userRepository) {

        this.userRepository = userRepository;

    }



    @Override
    public List<AdminUserResponse> getAllUsers() {


        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

    }





    @Override
    public List<AdminUserResponse> getUsersByRole(
            String role) {


        return userRepository.findAll()
                .stream()
                .filter(user ->
                        user.getRole()
                        .name()
                        .equalsIgnoreCase(role))
                .map(this::mapToResponse)
                .collect(Collectors.toList());

    }





    @Override
    public String deleteUser(
            Long userId) {


        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found"));



        userRepository.delete(user);


        return "User deleted successfully";

    }





    private AdminUserResponse mapToResponse(
            User user) {


        return new AdminUserResponse(

                user.getId(),

                user.getFirstName(),

                user.getLastName(),

                user.getEmail(),

                user.getPhoneNumber(),

                user.getRole().name()

        );

    }

}