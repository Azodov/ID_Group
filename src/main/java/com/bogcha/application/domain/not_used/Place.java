//package com.bogcha.application.domain;
//
//import lombok.*;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "places")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Place {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotNull
//    private String place_number;
//
//    @NotNull
//    private Boolean isBusy = false;
//
//    @NotNull
//    private Boolean isReserved = false;
//
//    private String reservedBy;
//
//    private String reservedFor;
//
//    private Double pledge;
//
//
//
//}
