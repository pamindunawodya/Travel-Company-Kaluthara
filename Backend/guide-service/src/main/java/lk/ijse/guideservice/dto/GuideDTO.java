package lk.ijse.guideservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GuideDTO {

    private Long id;

    private String guidename;

    private String guideaddress;

    private  int age;

    private String gender;

    private String contactnumber;

   private byte[] guideimage;

    private byte[] guide_nic_image;

    private String exeprience;

    private double man_day_value;


}
