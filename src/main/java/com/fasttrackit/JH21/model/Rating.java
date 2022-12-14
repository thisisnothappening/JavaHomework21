package com.fasttrackit.JH21.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Double rating;
    @Column
    private String agency;

    public Rating(Double rating, String agency) {
        this.rating = rating;
        this.agency = agency;
    }
}
