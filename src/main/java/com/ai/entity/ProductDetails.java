package com.ai.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productDetailId;

    private String productImgUrl;

    @ElementCollection
    @CollectionTable(
        name = "product_descriptions",
        joinColumns = @JoinColumn(name = "product_detail_id")
    )
    private List<String> productDescription;

    @ElementCollection
    @CollectionTable(
        name = "product_sizes",
        joinColumns = @JoinColumn(name = "product_detail_id")
    )
    private List<String> productSizes;

    private Double productPrice;

    private Double productOfferPrice;
}