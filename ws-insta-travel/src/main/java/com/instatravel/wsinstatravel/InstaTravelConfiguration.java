
package com.instatravel.wsinstatravel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


@Configuration
public class InstaTravelConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml

		marshaller.setContextPath("hello.wsdl");
		return marshaller;
	}

	@Bean
	public InstaTravelClient quoteClient(Jaxb2Marshaller marshaller) {
		InstaTravelClient client = new InstaTravelClient();
		client.setDefaultUri("http://www.thomas-bayer.com/axis2/services/BLZService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
