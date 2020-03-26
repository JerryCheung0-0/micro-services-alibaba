package pri.demo.web;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.pojo.Instance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping
public class TestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/echo/{serviceName}")
    public String test(@PathVariable String serviceName) throws NacosException {
        return "hello " + serviceName + "from "+ port;
    }

}
