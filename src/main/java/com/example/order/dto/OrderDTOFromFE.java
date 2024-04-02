package com.example.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTOFromFE {
	
	List<FoodItemsDTO> foodItemList;
	
	private Integer userId;
	
	private Restaurant restaurant;
}
