//package com.bogcha.application.domain;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "employees")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Employee {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//    private String username;
//
//    private String password;
//    @NotNull
//    private Boolean isBusy = false;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "position_id")
//    private Position position;
//
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "waiters_places",
//            joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "place_id", referencedColumnName = "id")}
//    )
//    private Set<Place> places = new HashSet<>();
//}
