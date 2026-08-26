package com.ai.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "product_store")
@AllArgsConstructor
@NoArgsConstructor
public class ProductStore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String store_id;
	
	private Integer product_store_count;
	
	private boolean product_store_view;
	

}
