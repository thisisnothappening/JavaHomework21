package com.fasttrackit.JH21.model.movie.rating;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private double rating;
    @Column
    private String agency;

    public Rating(double rating, String agency) {
        this.rating = rating;
        this.agency = agency;
    }
}
