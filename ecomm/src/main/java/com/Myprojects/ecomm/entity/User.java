package com.Myprojects.ecomm.entity;


import com.Myprojects.ecomm.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    private String password;

    private String name;

    private UserRole role;

//    to store large data we use Lob
    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img;
}
