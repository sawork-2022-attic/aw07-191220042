package com.micropos.order.controller;

import com.micropos.cart.mapper.CartMapper;
import com.micropos.cart.model.Cart;
import com.micropos.order.mapper.OrderMapper;
import com.micropos.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.micropos.api.OrdersApi;
import com.micropos.dto.OrderDto;
import com.micropos.dto.CartDto;


import java.util.List;

@RestController
//@RequestMapping("api")
public class OrderController implements OrdersApi {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @Override
    public ResponseEntity<OrderDto> createOrder(CartDto cartDto) {
        Cart cart = cartMapper.toCart(cartDto);
        return new ResponseEntity<>(orderMapper.toOrderDto(orderService.createOrder(cart)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<OrderDto>> listOrders() {
        List<OrderDto> orderDtos = orderMapper.toOrderDtos(orderService.listOrders());
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDto> deliverOrder(Integer orderId) {
        com.micropos.dto.OrderDto orderDto = orderMapper.toOrderDto(orderService.deliverById(orderId));
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

}
