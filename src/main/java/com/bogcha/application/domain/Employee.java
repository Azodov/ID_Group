//package com.bogcha.application.domain;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.List;
//
//@Entity
//@Table(name = "restuarant_employee")
//public class Employee implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String username;
//
//    private String password;
//
//    private String name;
//
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "employee_id")
//    private User user;
//
//}
