package com.fasttrackit.JH21.model.movie.studio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Studio {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private String address;

    public Studio(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
