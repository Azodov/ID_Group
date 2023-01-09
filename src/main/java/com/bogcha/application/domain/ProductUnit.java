package com.bogcha.application.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unit_of_measurement", nullable = false, length = 50, unique = true)
    private String unit_of_measurement;
}
