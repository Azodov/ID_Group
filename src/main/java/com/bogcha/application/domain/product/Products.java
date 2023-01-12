package com.bogcha.application.domain.product;

import com.bogcha.application.domain.restaurant.Restaurant;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private String productType;
}
