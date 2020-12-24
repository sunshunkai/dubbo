package org.apache.dubbo.demo.provider.spi.impl;


import org.apache.dubbo.demo.TestService;
import org.apache.dubbo.demo.provider.spi.HelloSpi;


/**
 * @author ssk
 * @date 2020/12/24
 */
public class AHelloSpi implements HelloSpi {


    private TestService testService;

//    public void setTestService(TestService testService){
//        this.testService = testService;
//    }

    @Override
    public void hello() {
        System.out.println("A HELLO");
        System.out.println(testService);
    }
}
