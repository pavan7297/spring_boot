package com.ai.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_ratings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRating {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productRatingId;

    private Double productRatingAvgRate;

    private String productRatingMessage;

    private Double productRatingRate;
}