//package com.bogcha.application.domain;
//
//import lombok.*;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.sql.Timestamp;
//
//@Entity
//@Table(name = "orders")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotNull
//    private Long quantity;
//
//    private Double price;
//
//    private Timestamp orderTime;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "employee_id")
//    private Employee employee;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "place_id")
//    private Place place;
//
//}
