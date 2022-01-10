package stock.example.stockMaintain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StockMaintainApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMaintainApplication.class, args);
	}

}
