package org.apache.dubbo.demo.provider;

import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.demo.TestService;

/**
 * @author ssk
 * @date 2020/11/22
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String hello() {
        return "hello";
    }
}
