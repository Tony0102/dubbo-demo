package com.tao.dubbo.consumer;

import com.tao.dubbo.demo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by taoyunkun on 2018/2/12.
 */
public class Consumer {

    public static void main(String[] args) {
        System.setProperty("java.net.preferIPv4Stack", "true");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-demo-consumer.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService");

        while (true) {
            try {
                Thread.sleep(1000);
                String hello = demoService.sayHello("world");
                System.out.println(hello);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
