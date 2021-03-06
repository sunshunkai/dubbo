/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.demo.DemoService;
import org.apache.dubbo.demo.TestService;
import org.apache.dubbo.demo.consumer.comp.DemoServiceComponent;

import org.apache.dubbo.rpc.service.EchoService;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;

public class Application {
    /**
     * In order to make sure multicast registry works, need to specify '-Djava.net.preferIPv4Stack=true' before
     * launch the application
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();

        DemoService service = context.getBean("demoServiceComponent", DemoServiceComponent.class);
        String hello = service.sayHello("world");
        System.out.println("result :" + hello);

        // 泛化调用
//        testGenericService();

        // 回声测试
//        testEcho();

    }

    @Configuration
    @EnableDubbo(scanBasePackages = "org.apache.dubbo.demo.consumer.comp")
    @PropertySource("classpath:/spring/dubbo-consumer.properties")
    @ComponentScan(value = {"org.apache.dubbo.demo.consumer.comp"})
    static class ConsumerConfiguration {

    }

    /**
     * 泛化调用测试
     */
    private static void testGenericService(){
        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<GenericService>();
        referenceConfig.setInterface("org.apache.dubbo.demo.TestService");
        referenceConfig.setGeneric(true);
        GenericService genericService = referenceConfig.get();
        Object hello = genericService.$invoke("hello", new String[]{"java.lang.String"}, new Object[]{"world"});
        System.out.println("返回调用测试结果:" + hello);
    }

    /**
     * 回声测试
     */
    private static void testEcho(){
        ReferenceConfig<EchoService> referenceConfig = new ReferenceConfig<EchoService>();
        referenceConfig.setInterface("org.apache.dubbo.demo.TestService");
        EchoService genericService = referenceConfig.get();
        Object hello = genericService.$echo("你好");
        System.out.println("回声测试:" + hello);
    }

}
