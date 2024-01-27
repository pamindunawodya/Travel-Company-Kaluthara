package lk.ijse.userservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data


public class RegiterUerDTO {


    private String name;
    private String password;
    private String address;
    private String email;
    private  String contact;
    private byte[] fileData;



}
