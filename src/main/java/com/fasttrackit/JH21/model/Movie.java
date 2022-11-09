package com.fasttrackit.JH21.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @OneToOne(cascade = CascadeType.ALL)
    private Rating rating;
    @OneToMany(cascade = CascadeType.ALL)
    private final List<Review> reviewList = new ArrayList<>();
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Studio studio;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private final List<Actor> actorList = new ArrayList<>();

    public Movie(String name, Integer releaseYear, Rating rating, Studio studio) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.studio = studio;
    }
}
