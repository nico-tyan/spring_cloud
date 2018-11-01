package spring_cloud_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer
@RestController
@ComponentScan()
public class Application {

	@RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
    }

}
