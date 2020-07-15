package org.example.demo;

import org.example.OrderService;
import org.example.dto.OrderDto;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangdj
 * @date 2020/7/15
 */
@RestController
public class OrderServiceImpl implements OrderService {

    @Override
    public String orders() {
        return null;
    }

    @Override
    public int insert(OrderDto orderDto) {
        return 0;
    }
}
