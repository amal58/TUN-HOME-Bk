package com.pfe.tunhome.models;


import javax.persistence.*;

@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue
    public Integer id;
    @Column(name = "description", nullable = false)
    public String description;
    @Column(name = "imageUrl", nullable = false)
    public String imageUrl;
    @Column(name = "price", nullable = false)
    public Double price;
    @ManyToOne
    @JoinColumn(name = "idcategory")
    public Category category;



}
