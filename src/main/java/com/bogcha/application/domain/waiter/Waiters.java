package com.bogcha.application.domain.WAITERS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "waiters")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Waiters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;

    private String username;

    private String password;
}
