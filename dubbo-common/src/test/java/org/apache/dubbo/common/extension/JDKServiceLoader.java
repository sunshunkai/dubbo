package org.apache.dubbo.common.extension;

import org.apache.dubbo.common.extension.ssk.jdk.UploadService;
import org.junit.jupiter.api.Test;

import java.util.ServiceLoader;

/**
 * @author ssk
 * @date 2020/12/16
 */
public class JDKServiceLoader {

    /**
     * 测试JDK SPI
     */
    @Test
    public void test(){
        ServiceLoader<UploadService> load = ServiceLoader.load(UploadService.class);
        for (UploadService uploadService : load) {
            uploadService.upload("abc");
        }
    }



}
