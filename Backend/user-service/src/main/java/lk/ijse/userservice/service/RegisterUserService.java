package lk.ijse.userservice.service;
import lk.ijse.userservice.dto.LoginDTO;
import lk.ijse.userservice.dto.RegiterUerDTO;
import lk.ijse.userservice.entity.RegisterUser;
import lk.ijse.userservice.response.LoginMessage;

import java.util.ArrayList;
import java.util.List;

public interface RegisterUserService {
     void addUsers(RegiterUerDTO regiterUerDTO);

     void updateUsers(RegisterUser regiterUerDTO);

     void deleteUsers(String email);

    RegisterUser findByEmail(String email);

     ArrayList<RegiterUerDTO> getAllUsers();

    List<RegiterUerDTO> searchUserByName(String name);

     RegisterUser getUserById(long id);

     LoginMessage loginUser(LoginDTO loginDTO);


}
