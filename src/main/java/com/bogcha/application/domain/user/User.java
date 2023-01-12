package com.bogcha.application.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.YearMonth;
import java.util.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("username")
    private String userName;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_name", referencedColumnName = "name")}
    )
    private Set<Role> roles = new HashSet<>();

    private Boolean enabled = true;

    private Date expireDate = new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * YearMonth.of(
            Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.MONTH) + 1).lengthOfMonth());


//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_restaurants",
//            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "restaurant_id", referencedColumnName = "id")}
//    )
//    private Set<Restaurant> restaurants = new HashSet<>();
}
