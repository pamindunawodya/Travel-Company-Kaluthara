package lk.ijse.guideservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity

public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String guidename;

    @Column(nullable = false)
    private String guideaddress;

    @Column(nullable = false)
    private  int age;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String contactnumber;

    @Column(nullable = false)
    @Lob
    private byte[] guideimage;

    @Column(nullable = false)
    @Lob
    private byte[] guide_nic_image;

    @Column(nullable = false)
    private String exeprience;

    @Column(nullable = false)
    private double man_day_value;




}
