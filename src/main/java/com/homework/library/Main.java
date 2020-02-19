package com.homework.library;

import com.homework.library.logic.Executor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        context.getBean("executor", Executor.class).fillDatabase();
        System.out.println(context.getBeanDefinitionCount());
    }
}
