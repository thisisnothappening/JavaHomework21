package com.fasttrackit.JH21.model.movie.actor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private int birthYear;

    public Actor(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }
}
