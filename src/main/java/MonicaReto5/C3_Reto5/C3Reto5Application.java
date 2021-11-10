package MonicaReto5.C3_Reto5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"MonicaReto5.C3_Reto5.Model"})
public class C3Reto5Application {

	public static void main(String[] args) {

		SpringApplication.run(C3Reto5Application.class, args);
	}

}
