package org.example.clients;

import org.example.OrderService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author huangdj
 * @date 2020/7/15
 */
@FeignClient("order-service")
public interface OrderServiceFeign extends OrderService {
}
