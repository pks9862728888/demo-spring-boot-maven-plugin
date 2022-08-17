package com.demo.demospringbootmavenplugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * mvn com.demo:demo-spring-boot-maven-plugin:0.1.0:demo1-cmd
 */
@Mojo(name = "demo1-cmd", defaultPhase = LifecyclePhase.INTEGRATION_TEST)
@SpringBootApplication
public class Demo1Application extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("Started execution");
        try {
            ConfigurableApplicationContext context = SpringApplication.run(Demo1Application.class);
            Impl impl = context.getBean(Impl.class);
            impl.print();
            context.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
