package com.pfe.tunhome.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(name = "name", unique = true, nullable = false)
    public String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnoreProperties("category")
    public List<Offer> offers ;

}
