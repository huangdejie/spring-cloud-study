package org.example.userservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author huangdj
 * @date 2020/7/20
 */
@RestController
public class HystrixController {

    @Resource
    private RestTemplate restTemplate;

    /**
     * 熔断
     * @param num
     * @return
     */
    @HystrixCommand(commandProperties = {
            //开启熔断
            @HystrixProperty(name="circuitBreaker.enabled",value="true"),
            //最小的请求次数
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "5"),
            //时间窗口
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="5000"),
            //
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="50")
    },fallbackMethod = "queryOrderFallback")
    @GetMapping("/hystrix/order/{num}")
    public String queryOrder(@PathVariable("num") int num){
        if(num%2==0){
            return "正常访问。";
        }
        //restTemplate默认有一个请求超时时间
        return restTemplate.getForObject("http://order-service/orders",String.class);
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    },fallbackMethod = "timeoutFallback")
    @GetMapping("/hystrix/timeout")
    public String queryOrderTimeout(){
        return restTemplate.getForObject("http://localhost:8080/orders",String.class);
    }

    public String queryOrderFallback(int num){
        return "queryOrderFallback...";
    }

    public String timeoutFallback(){
        return "timeoutFallback....";
    }



}
