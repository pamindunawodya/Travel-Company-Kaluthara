package lk.ijse.userservice.service.impl;


import lk.ijse.userservice.dto.LoginDTO;
import lk.ijse.userservice.dto.RegiterUerDTO;
import lk.ijse.userservice.entity.RegisterUser;
import lk.ijse.userservice.repo.RegisterUserRepo;
import lk.ijse.userservice.response.LoginMessage;
import lk.ijse.userservice.service.RegisterUserService;
import lk.ijse.userservice.util.RoleType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class RegisterUserImpl implements RegisterUserService {

   @Autowired
   RegisterUserRepo registerUserRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public void addUsers(RegiterUerDTO regiterUerDTO) {

        if (registerUserRepo.existsByEmail(regiterUerDTO.getEmail())) {
            throw new RuntimeException("RegisterUser" + regiterUerDTO.getEmail() + "Already Exists!");
        }
        RegisterUser registerUser = new RegisterUser();
        registerUser.setRole(RoleType.ROLE_ADMIN);
//        registerUser = modelMapper.map(regiterUerDTO, RegisterUser.class);
        registerUser.setName(regiterUerDTO.getName());
        registerUser.setPassword(regiterUerDTO.getPassword());
        registerUser.setAddress(regiterUerDTO.getAddress());
        registerUser.setFileData(regiterUerDTO.getFileData());
        registerUser.setContact(regiterUerDTO.getContact());
        registerUser.setEmail(regiterUerDTO.getEmail());

        registerUserRepo.save(registerUser);



    }

    @Override
    public void updateUsers(RegisterUser regiterUerDTO) {
        RegisterUser entity = modelMapper.map(regiterUerDTO, RegisterUser.class);
        registerUserRepo.save(entity);

    }

    @Override
    public void deleteUsers(String email) {
        if (!registerUserRepo.existsByEmail(email)) {
            throw new RuntimeException("RegisterUser" + email + "Not available deleted");
        }
        registerUserRepo.deleteByEmail(email);
    }

    @Override
    public RegisterUser findByEmail(String email) {
        if (!registerUserRepo.existsByEmail(email)) {
            throw new RuntimeException("RegisterUser" + email + "Not Available");
        }
        Optional<RegisterUser> c1=registerUserRepo.findByEmail(email);

        return c1.get();
    }

    @Override
    public ArrayList<RegiterUerDTO> getAllUsers() {
        return modelMapper.map(registerUserRepo.findAll(), new TypeToken<ArrayList<RegiterUerDTO>>() {
        }.getType());
    }

    @Override
    public List<RegiterUerDTO> searchUserByName(String name) {
        return modelMapper.map(registerUserRepo.findRegisterUserByName(name), new TypeToken<ArrayList<RegiterUerDTO>>() {
        }.getType());

    }

    @Override
    public RegisterUser getUserById(long id) {
        return registerUserRepo.findById(id).orElse(null);
    }


    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
        String msg = "";
        Optional<RegisterUser> byEmail = registerUserRepo.findByEmail(loginDTO.getEmail());

        if (byEmail.isEmpty())
            throw new RuntimeException("Email doesn't exist");

        RegisterUser user = byEmail.get();

            // Check if the password matches the one in the database
            if (user.getPassword().equals(loginDTO.getPassword())) {

                return new LoginMessage("Login Success", true);
            } else {
                throw new RuntimeException("Password is incorrect ");
            }

        }
    }







