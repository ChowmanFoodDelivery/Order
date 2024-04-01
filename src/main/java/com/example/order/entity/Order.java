package com.example.order.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.order.dto.FoodItemsDTO;
import com.example.order.dto.RestaurantDTO;
import com.example.order.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
	
	private Integer orderId;
	
	private List<FoodItemsDTO> foodItemList;
	
	private RestaurantDTO restaurantDTO;
	
	private UserDTO userDTO;
}
