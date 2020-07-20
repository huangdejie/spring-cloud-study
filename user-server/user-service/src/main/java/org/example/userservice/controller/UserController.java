package org.example.userservice.controller;

import org.example.clients.OrderServiceFeign;
import org.example.dto.OrderDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: huangdj
 * @Date: 2020/7/20
 */
@RestController
public class UserController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private OrderServiceFeign orderServiceFeign;

    /**
     * 通过ribbon
     * @return
     */
    @GetMapping("/user/getOrder")
    public String getOrders(){
        return restTemplate.getForObject("http://order-service/orders",String.class);
    }

    /**
     * 通过feign
     * @return
     */
    @GetMapping("/user/orders")
    public String orders(){
        return orderServiceFeign.orders();
    }

    /**
     * 通过feign
     * @return
     */
    @PostMapping("/user/order")
    public int order(){
        OrderDto orderDto = new OrderDto();
        return orderServiceFeign.insert(orderDto);
    }



}
