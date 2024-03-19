package com.blanco.ExamenADAT.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "store")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Integer stock;

}
