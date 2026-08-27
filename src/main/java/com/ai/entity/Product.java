package com.ai.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productId;

    private String productName;


    @OneToOne(cascade = CascadeType.ALL)
    private ProductDetails productDetails;

    @OneToOne(cascade = CascadeType.ALL)
    private ProductRating productRateing;

    @OneToOne(cascade = CascadeType.ALL)
    private ProductCategory productCategory;

    @OneToOne(cascade = CascadeType.ALL)
    private ProductStore productStore;

    @CreationTimestamp
    private LocalDateTime productCreatedAt;

    @UpdateTimestamp
    private LocalDateTime productUpdatedAt;
}