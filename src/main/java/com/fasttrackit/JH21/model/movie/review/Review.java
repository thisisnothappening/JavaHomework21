package com.fasttrackit.JH21.model.movie.review;

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
public class Review {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String text;
    @Column
    private String reviewer;

    public Review(String text, String reviewer) {
        this.text = text;
        this.reviewer = reviewer;
    }
}
