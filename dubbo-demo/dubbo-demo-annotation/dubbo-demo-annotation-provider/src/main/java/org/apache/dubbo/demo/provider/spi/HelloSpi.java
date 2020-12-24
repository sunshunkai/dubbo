package org.apache.dubbo.demo.provider.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author ssk
 * @date 2020/12/24
 */
@SPI
public interface HelloSpi {
    void hello();
}
