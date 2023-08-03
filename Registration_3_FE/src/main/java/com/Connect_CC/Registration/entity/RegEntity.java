package com.Connect_CC.Registration.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Reg_Table")
public class RegEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long regId;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "EMAIL_ID" , unique=true , nullable = false)
    private String emailId;

    @Column(name = "PHONE_NO")
    private long phoneNo;

    @Column(name = "PASSWORD")
    private String password;

}
