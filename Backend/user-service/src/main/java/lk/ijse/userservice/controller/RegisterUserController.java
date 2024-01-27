package lk.ijse.userservice.controller;


import lk.ijse.userservice.dto.RegiterUerDTO;
import lk.ijse.userservice.entity.RegisterUser;
import lk.ijse.userservice.service.RegisterUserService;
import lk.ijse.userservice.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;


@RestController
@RequestMapping("api/user")
@CrossOrigin
@RequiredArgsConstructor
public class RegisterUserController {

    @Autowired
    RegisterUserService registerUserService;

    @Autowired
    ModelMapper modelMapper;




    @PostMapping("new/user")
    public ResponseUtil saveImg(@RequestParam("file") MultipartFile file,
                                @RequestParam("name")String name,
                                @RequestParam("password")String password,
                                @RequestParam("address")String address,
                                @RequestParam("email")String email,
                                @RequestParam("contact")String contact) throws IOException {

        RegiterUerDTO registerUser = new RegiterUerDTO( name, password, address, email, contact, file.getBytes());
        registerUserService.addUsers(registerUser);
        System.out.println(registerUser.getEmail());
        return new ResponseUtil("200",registerUser.toString(),registerUser);
    }

    @PatchMapping
    public ResponseUtil updateRegisterUser(@RequestParam("file") MultipartFile file,
                                           @RequestParam("name") String name,
                                           @RequestParam("password") String password,
                                           @RequestParam("address") String address,
                                           @RequestParam("email") String email,
                                           @RequestParam("contact") String contact) throws IOException {

        RegisterUser existingUser = registerUserService.findByEmail(email);

        if (existingUser != null) {
            // Update the properties of the existing user
            existingUser.setName(name);
            existingUser.setPassword(password);
            existingUser.setAddress(address);
            existingUser.setContact(contact);
            existingUser.setFileData(file.getBytes());
            // You may want to handle file updates as needed, e.g., if the file is optional or needs special handling.

            // Save the updated user entity
            registerUserService.updateUsers(existingUser);

            return new ResponseUtil("200", "User updated successfully", null);
        } else {
            return new ResponseUtil("404", "User not found", null);
        }
    }

    @DeleteMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteRegisterUser(@RequestParam String email){

     registerUserService.deleteUsers(email);
        return new ResponseUtil("200",email+ ":Deletd Sucessfull",null);
    }
    @GetMapping(value = "api/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRegisterUsers(){
       ArrayList<RegiterUerDTO>allRegisterUsers=registerUserService.getAllUsers();
       return new ResponseUtil("200","allCustomers",allRegisterUsers);
    }

    @GetMapping("user/search")
    public ResponseUtil searchCustomerByName(String name){

        return  new ResponseUtil("200",name+"searching",registerUserService.searchUserByName(name));
    }

    @GetMapping
    public ResponseEntity<RegisterUser> getUserById(long id) {
        RegisterUser user = registerUserService.getUserById(id);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}









