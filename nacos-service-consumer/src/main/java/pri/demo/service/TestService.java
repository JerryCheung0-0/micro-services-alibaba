package pri.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by on 2020-03-08 14:54
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: micro-services-alibaba
 */
@FeignClient(value = "nacos-service-provider")
public interface TestService {
    /**
     * @FeignClient 加服务名的时候 一定要带上 value 不然无法识别
     * @param serviceName
     * @return
     */
    @GetMapping("/echo/{serviceName}")
    String echo(@PathVariable String serviceName);


}
