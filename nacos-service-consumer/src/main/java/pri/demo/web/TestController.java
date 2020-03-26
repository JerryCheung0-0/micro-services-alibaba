package pri.demo.web;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pri.demo.service.TestService;

import java.util.List;


/**
 * Created by on 2020-02-28 16:58
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: micro-services-alibaba
 */
@Slf4j
@RestController
public class TestController {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private TestService echoService;

    @GetMapping("/echo/{serviceName}")
    public String echoAppName(@PathVariable String serviceName){
        //方法1 使用 LoadBalanceClient 和 RestTemolate 结合的方式来访问
//        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceName);
//        String url = String.format("http://%s:%s/echo/%s",serviceInstance.getHost(),serviceInstance.getPort(),serviceName);

        //方法二 将注解@LoadBalanced 添加到restTemplate bean上 有集成feign的效果
//        String url = String.format("http://%s/echo/%s",serviceName,serviceName);
//        return restTemplate.getForObject(url,String.class);

        //方法三 使用Feign接口
        return echoService.echo(serviceName);
    }

    @NacosInjected
    private NamingService namingService;

    @GetMapping(value = "/get")
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }

}
