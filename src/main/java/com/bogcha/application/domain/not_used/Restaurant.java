//package com.bogcha.application.domain;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Table(name = "restaurants")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Restaurant {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NonNull
//    private String name;
//
//    @NonNull
//    private String address;
//
//    @NonNull
//    private String phoneNumber;
//
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "restaurants_employees",
//            joinColumns = {@JoinColumn(name = "restaurant_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")}
//    )
//    private Set<Employee> employees = new HashSet<>();
//}
