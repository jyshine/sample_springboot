package com.bluff.domain.dto.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity(name = "User")
@Getter
@Setter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;


}
