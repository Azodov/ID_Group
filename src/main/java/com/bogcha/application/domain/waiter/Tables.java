package com.bogcha.application.domain.waiter;

import com.bogcha.application.domain.order.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tables")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tableNumber;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "waiter_id")
    private Waiters waiter;
}
