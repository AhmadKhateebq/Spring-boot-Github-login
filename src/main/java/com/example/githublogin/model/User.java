package com.example.githublogin.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Setter
@Getter
@Table(name = "user")
public class User {
    @Id
    private Integer id;

    @Column(name = "s_id")
    private String socialId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
}
