package com.example.tooltmpl.webdriver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.tooltmpl.webdriver.page.Start;

public class AppMain {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-context.xml");
        addShutdownHook(ctx);

        Start start = ctx.getBean(Start.class);
        start.doProcess();
    }

    private static void addShutdownHook(ApplicationContext ctx) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                ((ConfigurableApplicationContext) ctx).close();
            }
        });
    }

}
