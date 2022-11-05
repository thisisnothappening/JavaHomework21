package com.fasttrackit.JH21.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer releaseYear;

    public Movie(String name, Integer releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }
}
