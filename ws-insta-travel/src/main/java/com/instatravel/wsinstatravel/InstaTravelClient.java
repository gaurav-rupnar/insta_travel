
package com.instatravel.wsinstatravel;

import hello.wsdl.*;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.amadeus.java.handlers.ServiceHandler;

import javax.xml.bind.JAXBElement;

public class InstaTravelClient extends WebServiceGatewaySupport {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(InstaTravelClient.class);

	public GetBankResponseType getQuote(String ticker) throws Exception {

        ObjectFactory objectFactory = new ObjectFactory();
        GetBankType bankType = objectFactory.createGetBankType();
        bankType.setBlz(ticker);

        String WSAP = "1ASIWAWBNLS";
		ServiceHandler handler = new ServiceHandler(WSAP);
        JAXBElement<GetBankType> getBank = objectFactory.createGetBank(bankType);
  

        @SuppressWarnings({ "unchecked", "rawtypes" })
		JAXBElement<GetBankResponseType> response = (JAXBElement)getWebServiceTemplate()
                .marshalSendAndReceive("http://www.thomas-bayer.com/axis2/services/BLZService",
                        getBank,
                        new SoapActionCallback("http://thomas-bayer.com/blz/BLZService/getBankResponse"));


        return response.getValue();

	}

}
