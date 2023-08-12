package com.ritesh.springapp.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.ritesh.springapp.hello.app.json.Greeting;

@SpringBootTest
public class DemoApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void printScopes() {

        System.out.println(String.format("There are %d beans in application context",
                applicationContext.getBeanDefinitionCount()));

        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println("Bean - " + beanName);
        }

    }

    @Test
    public void noGreetingBeanDefinition() {

        assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean(Greeting.class),
                "checking for Greeting class");

        Greeting greeting1 = applicationContext.getBean("englishGreeting", Greeting.class);
        Greeting greeting2= applicationContext.getBean("englishGreeting",   Greeting.class);

        // assertEquals(greeting1, greeting2, "Checking bean ");
        System.out.println(greeting1.equals(greeting2) );
    }

}
