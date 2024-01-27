package lk.ijse.userservice.controller;


import lk.ijse.userservice.dto.LoginDTO;
import lk.ijse.userservice.response.LoginMessage;
import lk.ijse.userservice.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/app1/log")
@CrossOrigin
public class UserLoginController {

    @Autowired
    RegisterUserService registerUserService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public LoginMessage loginUser(@RequestBody LoginDTO loginDTO){
        System.out.println(loginDTO.toString());
        return registerUserService.loginUser(loginDTO);
    }
}
