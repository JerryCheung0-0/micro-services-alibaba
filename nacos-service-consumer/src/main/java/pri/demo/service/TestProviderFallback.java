package pri.demo.service;

/**
 * Created by on 2020-03-08 14:51
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: micro-services-alibaba
 */
public class TestProviderFallback implements TestService{
    @Override
    public String echo(String serviceName) {
        return null;
    }
}
