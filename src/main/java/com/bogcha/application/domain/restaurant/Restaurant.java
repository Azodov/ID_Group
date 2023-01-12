package com.bogcha.application.domain.restaurant;

import com.bogcha.application.domain.user.User;
import com.bogcha.application.domain.waiter.Waiters;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "restaurants")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Restaurant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String address;

    @NonNull
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
}

