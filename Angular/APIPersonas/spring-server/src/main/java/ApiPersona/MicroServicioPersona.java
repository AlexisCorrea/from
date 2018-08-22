package ApiPersona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MicroServicioPersona {

    public static void main(String[] args) throws Exception {
    	
        new SpringApplication(MicroServicioPersona.class).run(args);
    }

}
