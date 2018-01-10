package com.instatravel.wsinstatravel;

import hello.wsdl.GetBankResponseType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WsInstaTravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsInstaTravelApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(InstaTravelClient instaTravelClient) {
		return args -> {
			String ticker = "10000000";

			if (args.length > 0) {
				ticker = args[0];
			}
			GetBankResponseType response = instaTravelClient.getQuote(ticker);
			System.err.println(response.getDetails().getBezeichnung());
		};
	}

}
