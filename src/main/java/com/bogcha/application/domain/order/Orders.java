package com.bogcha.application.domain.order;

import com.bogcha.application.domain.product.Products;
import com.bogcha.application.domain.waiter.Tables;
import com.bogcha.application.domain.waiter.Waiters;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Tables table;

    private Timestamp orderTime = new Timestamp(System.currentTimeMillis());
    @ManyToMany
    @JoinTable(name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Products> products = new HashSet<>();

}
