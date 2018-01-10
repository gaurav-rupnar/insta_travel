package com.instatravel.wsinstatravel;

import hello.wsdl.GetBankResponseType;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.xtravels.obj.FlgtSrchReq;
import com.xtravels.obj.FlgtSrchRes;

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
			
			
			String filenm = "C:\\Data\\code\\Insta\\InstaTravelIp.txt";
			
			InputStream is = new FileInputStream(filenm);
			@SuppressWarnings("resource")
			BufferedReader buf = new BufferedReader(new InputStreamReader(is));
			String line = buf.readLine();
			StringBuilder sb = new StringBuilder();
			while (line != null) {
				sb.append(line).append("\n");
				line = buf.readLine();
			}
			String fileAsString = sb.toString();
			System.out.println("Contents : " + fileAsString);

			ObjectMapper mapper = new ObjectMapper();
			FlgtSrchReq obj = mapper.readValue(fileAsString, FlgtSrchReq.class);
			System.out.println(obj.toString());


			//System.exit(0);
			FlgtSrchReq flgtSrcReq = new FlgtSrchReq();
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			try {
				String json = ow.writeValueAsString(flgtSrcReq);

				System.out.println(json);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			TravelBoardSearchService searchService = new TravelBoardSearchService();
			FlgtSrchRes flgtSrchRes = searchService.flightDetails(obj);
			try {
				String json = ow.writeValueAsString(flgtSrchRes);
				System.out.println(json);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
			
			
			
		/*
			
			
			
			GetBankResponseType response = instaTravelClient.getQuote(ticker);
			System.err.println(response.getDetails().getBezeichnung());*/
		};
	}

}
