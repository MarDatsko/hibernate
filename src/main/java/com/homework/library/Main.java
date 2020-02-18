package com.homework.library;

import com.homework.library.entity.User;
import com.homework.library.service.UserService;
import com.homework.library.service.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        context.getBean("executor", Executor.class).run();
        System.out.println(context.getBeanDefinitionCount());
    }
}
