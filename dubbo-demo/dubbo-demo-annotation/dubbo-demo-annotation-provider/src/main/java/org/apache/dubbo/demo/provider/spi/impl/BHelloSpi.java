package org.apache.dubbo.demo.provider.spi.impl;

import org.apache.dubbo.demo.provider.spi.HelloSpi;

/**
 * @author ssk
 * @date 2020/12/24
 */
public class BHelloSpi implements HelloSpi {
    @Override
    public void hello() {
        System.out.println("B HELLO");
    }
}
