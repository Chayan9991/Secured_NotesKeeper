package com.chayan.controller;

import com.chayan.model.User;
import com.chayan.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class AuthenticationController  {



    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(
            @RequestParam("profileImage") MultipartFile multipartFile,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password , Model model) throws IOException, SQLException {

        //Creating a Blob using incoming multipartFile
        byte[] bytes = multipartFile.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        //user.setRegistrationTimestamp(new Timestamp(new Date().getTime()));
        user.setProfileImage(blob);
        user.setRegistrationTimestamp(Timestamp.valueOf(LocalDateTime.now()));

        //Registering the User
            User returnedValue = userService.saveUser(user);
            System.out.println(returnedValue);
            System.out.println(user.toString());
            return "redirect:/";


    }
}
