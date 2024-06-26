package com.example.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.order.dto.OrderDTO;
import com.example.order.dto.OrderDTOFromFE;
import com.example.order.dto.UserDTO;
import com.example.order.entity.Order;
import com.example.order.mapper.OrderMapper;
import com.example.order.repo.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	SequenceGenerator sequenceGenerator;
	
	@Autowired
	RestTemplate restTemplate;

	public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {
		
		Integer newOrderId = sequenceGenerator.generateNextOrderId();
		
		UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
		
		Order orderToBeSaved = new Order(newOrderId , orderDetails.getFoodItemList() , orderDetails.getRestaurant() , userDTO);
		
		orderRepo.save(orderToBeSaved);
				
		return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
	}

	private UserDTO fetchUserDetailsFromUserId(Integer userId) {
		
		return restTemplate.getForObject("http://USER-SERVICE/user/FetchUserById/"+userId, UserDTO.class);
	}
}
