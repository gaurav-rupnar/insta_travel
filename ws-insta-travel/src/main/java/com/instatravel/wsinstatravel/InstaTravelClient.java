
package com.instatravel.wsinstatravel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.amadeus.java.handlers.ServiceHandler;
import com.amadeus.java.handlers.SessionHandler.TransactionStatusCode;
import com.amadeus.java.handlers.TransactionFlowLinkHandler.TransactionFlowLinkAction;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch.FareOptions;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch.FareOptions.PricingTickInfo;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch.FareOptions.PricingTickInfo.PricingTicketing;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch.Itinerary;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch.Itinerary.ArrivalLocalization;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch.Itinerary.ArrivalLocalization.ArrivalPointDetails;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch.Itinerary.DepartureLocalization;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch.Itinerary.DepartureLocalization.DeparturePoint;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch.Itinerary.RequestedSegmentRef;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch.Itinerary.TimeDetails;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch.Itinerary.TimeDetails.FirstDateTimeDetail;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch.NumberOfUnit;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch.NumberOfUnit.UnitNumberDetail;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch.PaxReference;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch.PaxReference.Traveller;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch.TravelFlightInfo;
import com.amadeus.xml.fmptbq_14_3_1a.FareMasterPricerTravelBoardSearch.TravelFlightInfo.CabinId;
import com.amadeus.xml.fmptbr_14_3_1a.FareMasterPricerTravelBoardSearchReply;
import com.xtravels.obj.FlgtSrchReq;
import com.xtravels.obj.Pngrs;
import com.xtravels.obj.ReqSgmt;

import hello.wsdl.GetBankResponseType;
import hello.wsdl.GetBankType;
import hello.wsdl.ObjectFactory;

public class InstaTravelClient extends WebServiceGatewaySupport {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(InstaTravelClient.class);

	public GetBankResponseType getQuote(String ticker) throws Exception {

        ObjectFactory objectFactory = new ObjectFactory();
        GetBankType bankType = objectFactory.createGetBankType();
        bankType.setBlz(ticker);

        String WSAP = "1ASIWAWBNLS";
		ServiceHandler serviceHandler = new ServiceHandler(WSAP);
        JAXBElement<GetBankType> getBank = objectFactory.createGetBank(bankType);
        FlgtSrchReq uiRequest = new FlgtSrchReq();

    	System.out.println("Request construction starts @ " + System.currentTimeMillis());
		FareMasterPricerTravelBoardSearch searchReq = populateFareMaster(uiRequest);
		System.out.println("Request construction ends @ " + System.currentTimeMillis());

		// Amadeus webserice call to get flight details for all segments
		System.out.println("Request amedues starts@ " + System.currentTimeMillis());
		
		
		FareMasterPricerTravelBoardSearchReply amadeusResponse = serviceHandler.masterFligthSearch(searchReq,
				TransactionStatusCode.NONE, TransactionFlowLinkAction.NEW);
		System.out.println("Request amedues ends@ " + System.currentTimeMillis());
        
        
        @SuppressWarnings({ "unchecked", "rawtypes" })
		JAXBElement<GetBankResponseType> response = (JAXBElement)getWebServiceTemplate()
                .marshalSendAndReceive("http://www.thomas-bayer.com/axis2/services/BLZService",
                        getBank,
                        new SoapActionCallback("http://thomas-bayer.com/blz/BLZService/getBankResponse"));


        return response.getValue();

	}
	
	/**
	 * 
	 * @param uiRequest
	 * @return
	 */
	private FareMasterPricerTravelBoardSearch populateFareMaster(FlgtSrchReq uiRequest) {
		FareMasterPricerTravelBoardSearch req = new FareMasterPricerTravelBoardSearch();

		setItineraryData(req, uiRequest.getReqSgmt(), getPassengetsCounst(uiRequest.getPngrs()));

		req.setFareOptions(getFareOptions());

		req.getPaxReference().addAll(getPaxReference(uiRequest));

		req.setNumberOfUnit(searchOptions(uiRequest));

		req.setTravelFlightInfo(populateTravelFlightInro(uiRequest));
		return req;

	}
	
	/**
	 * 
	 * @param req
	 * @param reqSgmt
	 * @param pngrsCount
	 */
	private void setItineraryData(FareMasterPricerTravelBoardSearch req, List<ReqSgmt> reqSgmt, BigDecimal pngrsCount) {

		for (ReqSgmt reqSgmtData : reqSgmt) {
			Itinerary itinerary = new Itinerary();

			RequestedSegmentRef requestedSegmentRef = new RequestedSegmentRef();
			requestedSegmentRef.setSegRef(pngrsCount);

			DepartureLocalization departureLocalization = new DepartureLocalization();

			DeparturePoint departurePoint = new DeparturePoint();
			departurePoint.setLocationId(reqSgmtData.getSFrom());
			departureLocalization.setDeparturePoint(departurePoint);

			ArrivalLocalization arrivalLocalization = new ArrivalLocalization();
			ArrivalPointDetails arrivalPointDetails = new ArrivalPointDetails();
			arrivalPointDetails.setLocationId(reqSgmtData.getSTo());
			arrivalLocalization.setArrivalPointDetails(arrivalPointDetails);

			TimeDetails timeDetails = new TimeDetails();

			FirstDateTimeDetail firstDateTimeDetail = new FirstDateTimeDetail();
			firstDateTimeDetail.setDate(reqSgmtData.getDtTrvlDate());
			timeDetails.setFirstDateTimeDetail(firstDateTimeDetail);
			itinerary.setTimeDetails(timeDetails);
			itinerary.setArrivalLocalization(arrivalLocalization);
			itinerary.setDepartureLocalization(departureLocalization);
			itinerary.setRequestedSegmentRef(requestedSegmentRef);

			req.getItinerary().add(itinerary);
		}
	}

	
	private TravelFlightInfo populateTravelFlightInro(FlgtSrchReq uiRequest) {

		Map<String, String> flightClassMap = new HashMap<String, String>();
		flightClassMap.put("Economy", "Y");
		flightClassMap.put("Premium Economy", "P");
		flightClassMap.put("Business", "M");

		TravelFlightInfo travelFlightInfo = new TravelFlightInfo();
		if (null != uiRequest.getTravelFlightClassInfo()) {
			CabinId cabinId = new CabinId();
			cabinId.setCabinQualifier(flightClassMap.get(uiRequest.getTravelFlightClassInfo()));
			travelFlightInfo.setCabinId(cabinId);
		}

		return travelFlightInfo;
	}

	private NumberOfUnit searchOptions(FlgtSrchReq uiRequest) {
		NumberOfUnit numberOfUnit = new NumberOfUnit();

		UnitNumberDetail unitNumberDetail1 = new UnitNumberDetail();
		// BigDecimal nUnit = new BigDecimal("1");
		unitNumberDetail1.setNumberOfUnits(getPassengetsCounst(uiRequest.getPngrs()));
		unitNumberDetail1.setTypeOfUnit("PX");

		UnitNumberDetail unitNumberDetail2 = new UnitNumberDetail();
		// Will be configured in propertyFiles
		// BigDecimal nUnit1 = new BigDecimal("50");
		unitNumberDetail2.setNumberOfUnits(uiRequest.getNoOfRecmdations());
		unitNumberDetail2.setTypeOfUnit("RC");

		numberOfUnit.getUnitNumberDetail().add(unitNumberDetail1);
		numberOfUnit.getUnitNumberDetail().add(unitNumberDetail2);
		return numberOfUnit;
	}

	private List<PaxReference> getPaxReference(FlgtSrchReq uiRequest) {

		List<PaxReference> paxRefList = new ArrayList<PaxReference>();
		int adltCount = Integer.parseInt(uiRequest.getPngrs().getNAdlts());

		int totalNoOfSeats = 1;
		int i = 1;
		while (i <= adltCount) {
			PaxReference paxReference = new PaxReference();
			paxReference.getPtc().add("ADT");

			Traveller traveller = new Traveller();
			traveller.setRef(new BigDecimal(totalNoOfSeats));
			paxReference.getTraveller().add(traveller);
			paxRefList.add(paxReference);
			i++;
			totalNoOfSeats++;
		}

		int childCount = Integer.parseInt(uiRequest.getPngrs().getNAdlts());
		i = 1;
		while (i <= childCount) {
			PaxReference paxReference = new PaxReference();
			paxReference.getPtc().add("ADT");

			Traveller traveller = new Traveller();
			traveller.setRef(new BigDecimal(totalNoOfSeats));
			paxReference.getTraveller().add(traveller);
			paxRefList.add(paxReference);
			i++;
			totalNoOfSeats++;
		}

		return paxRefList;
	}

	private FareOptions getFareOptions() {
		FareOptions fareOptions = new FareOptions();
		PricingTickInfo pricingTickInfo = new PricingTickInfo();

		PricingTicketing pricingTicketing = new PricingTicketing();
		pricingTicketing.getPriceType().add("RP");
		pricingTicketing.getPriceType().add("RU");
		pricingTicketing.getPriceType().add("TAC");

		pricingTickInfo.setPricingTicketing(pricingTicketing);
		fareOptions.setPricingTickInfo(pricingTickInfo);
		return fareOptions;
	}
	
	/**
	 * 
	 * @param pngrs
	 * @return
	 */
	private BigDecimal getPassengetsCounst(Pngrs pngrs) {

		BigDecimal count = new BigDecimal(pngrs.getNAdlts());
		BigDecimal count1 = new BigDecimal(pngrs.getNChldrn());
		count.add(new BigDecimal(pngrs.getNChldrn()));
		// count.add(new BigDecimal(pngrs.getNInfnts()));
		count = count.add(count1);
		return count;
	}


}
