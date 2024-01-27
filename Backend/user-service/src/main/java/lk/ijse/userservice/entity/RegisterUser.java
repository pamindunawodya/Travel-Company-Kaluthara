package lk.ijse.userservice.entity;


import lk.ijse.userservice.util.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class RegisterUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use GenerationType.IDENTITY for auto-incremented IDs
    private Long id; // Assuming your ID is of type Long

    private String name;
    private String password;
    private String address;
    private String email;
    private  String contact;
    private RoleType role;
    @Lob
    private byte[] fileData;


}
