package com.instatravel.wsinstatravel;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
import com.amadeus.xml.fmptbr_14_3_1a.FareMasterPricerTravelBoardSearchReply.FlightIndex;
import com.amadeus.xml.fmptbr_14_3_1a.FareMasterPricerTravelBoardSearchReply.FlightIndex.GroupOfFlights;
import com.amadeus.xml.fmptbr_14_3_1a.FareMasterPricerTravelBoardSearchReply.FlightIndex.GroupOfFlights.FlightDetails;
import com.amadeus.xml.fmptbr_14_3_1a.FareMasterPricerTravelBoardSearchReply.FlightIndex.GroupOfFlights.PropFlightGrDetail.FlightProposal;
import com.amadeus.xml.fmptbr_14_3_1a.FareMasterPricerTravelBoardSearchReply.Recommendation;
import com.amadeus.xml.fmptbr_14_3_1a.FareMasterPricerTravelBoardSearchReply.Recommendation.PaxFareProduct.Fare;
import com.amadeus.xml.fmptbr_14_3_1a.FareMasterPricerTravelBoardSearchReply.Recommendation.SegmentFlightRef;
import com.amadeus.xml.fmptbr_14_3_1a.FareMasterPricerTravelBoardSearchReply.Recommendation.SegmentFlightRef.ReferencingDetail;
import com.xtravels.obj.Connect;
import com.xtravels.obj.FlgtDtls;
import com.xtravels.obj.FlgtSrchReq;
import com.xtravels.obj.FlgtSrchRes;
import com.xtravels.obj.FrRls;
import com.xtravels.obj.FromLoc;
import com.xtravels.obj.Frrl;
import com.xtravels.obj.Pngrs;
import com.xtravels.obj.Pricing;
import com.xtravels.obj.Rcmd;
import com.xtravels.obj.Rcmds;
import com.xtravels.obj.ReqSgmt;
import com.xtravels.obj.ResSgmt;
import com.xtravels.obj.ToLoc;

/**
 * 
 * @author xtravels
 *
 *
 *         Logging and Exception handling needs to be implemented
 */
public class TravelBoardSearchService {

	/**
	 * 
	 * @param uiRequest
	 * @return
	 * @throws Exception
	 */
	public FlgtSrchRes flightDetails(FlgtSrchReq uiRequest) throws Exception {

		// ServiceHandler will cinfigur the value in property files
		ServiceHandler serviceHandler = new ServiceHandler("1ASIWAWBNLS");

		// ValidateUIRequest - Needs to be implemented

		// Mapping UI Request to Amadeus webserive request
		System.out.println("Request construction starts @ " + System.currentTimeMillis());
		FareMasterPricerTravelBoardSearch searchReq = populateFareMaster(uiRequest);
		System.out.println("Request construction ends @ " + System.currentTimeMillis());

		// Amadeus webserice call to get flight details for all segments
		System.out.println("Request amedues starts@ " + System.currentTimeMillis());
		FareMasterPricerTravelBoardSearchReply amadeusResponse = serviceHandler.masterFligthSearch(searchReq,
				TransactionStatusCode.NONE, TransactionFlowLinkAction.NEW);
		System.out.println("Request amedues ends@ " + System.currentTimeMillis());

		return populateUIResponse(amadeusResponse);

	}

	/**
	 * 
	 * @param amadeusResponse
	 * @return
	 * @throws ParseException
	 */
	private FlgtSrchRes populateUIResponse(FareMasterPricerTravelBoardSearchReply amadeusResponse)
			throws ParseException {

		System.out.println("Response construction starts @ " + System.currentTimeMillis());

		FlgtSrchRes flgtSrchRes = new FlgtSrchRes();

		Map<String, Map<String, ResSgmt>> flightIndexDetails = populateAllFlighIndexes(amadeusResponse);

		Rcmds rcmds = new Rcmds();
		List<Rcmd> rcmdList = new ArrayList<Rcmd>();

		List<Recommendation> recommendations = amadeusResponse.getRecommendation();

		int recommendationIndex = 1;

		for (Recommendation recommendation : recommendations) {

			// Pricing details
			Pricing pricing = new Pricing();
			pricing.setTotalFare(recommendation.getRecPriceInfo().getMonetaryDetail().get(0).getAmount() + "");
			pricing.setBaseFare(recommendation.getRecPriceInfo().getMonetaryDetail().get(1).getAmount() + "");

			FrRls frRls = new FrRls();
			List<Frrl> frrlList = new ArrayList<Frrl>();

			for (Fare fare : recommendation.getPaxFareProduct().get(0).getFare()) {

				Frrl frRl = new Frrl();
				frRl.setId(fare.getPricingMessage().getFreeTextQualification().getInformationType());
				frRl.setName(fare.getPricingMessage().getFreeTextQualification().getTextSubjectQualifier());

				frRl.setDesc1(fare.getPricingMessage().getDescription().get(0));

				// Handling description
				// Handling monetaryInformation
				frrlList.add(frRl);
			}
			frRls.setFrrl(frrlList);

			for (SegmentFlightRef seg : recommendation.getSegmentFlightRef()) {
				Rcmd rcmd = new Rcmd();
				rcmd.setPricing(pricing);
				rcmd.setFrRls(frRls);

				rcmd.setRecmIndexId(recommendationIndex + "");

				List<ResSgmt> resSgmt = new ArrayList<ResSgmt>();
				int segIndex = 1;
				for (ReferencingDetail refDetail : seg.getReferencingDetail()) {

					if (!"B".equalsIgnoreCase(refDetail.getRefQualifier())) {

						// System.out.println(flightIndexDetails.get(segIndex + ""));

						// System.out.println(refDetail.getRefNumber());

						Map<String, ResSgmt> dattaa = flightIndexDetails.get(segIndex + "");
						if (null == dattaa) {
							continue;
						}
						dattaa.get(refDetail.getRefNumber() + "");

						resSgmt.add(flightIndexDetails.get(segIndex + "").get(refDetail.getRefNumber() + ""));
					}
					segIndex++;
				}
				rcmd.setResSgmt(resSgmt);

				rcmdList.add(rcmd);
				recommendationIndex++;
			}
		}

		rcmds.setRcmd(rcmdList);
		flgtSrchRes.setRcmds(rcmds);

		System.out.println("Response construction ends @ " + System.currentTimeMillis());
		return flgtSrchRes;

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

	/**
	 * populate flight details
	 * 
	 * @param respons
	 * @return
	 * @throws ParseException
	 */
	private static Map<String, Map<String, ResSgmt>> populateAllFlighIndexes(
			FareMasterPricerTravelBoardSearchReply respons) throws ParseException {

		Map<String, Map<String, ResSgmt>> flightIndexs = new HashMap<String, Map<String, ResSgmt>>();

		int recSegIndex = 1;
		for (FlightIndex flightIndex : respons.getFlightIndex()) {

			int propFlightIndex = 1;
			Map<String, ResSgmt> propSegFlightDetails = new HashMap<String, ResSgmt>();
			for (GroupOfFlights groupOfFlights : flightIndex.getGroupOfFlights()) {
				ResSgmt resSgmt = new ResSgmt();

				for (FlightProposal flightProposal : groupOfFlights.getPropFlightGrDetail().getFlightProposal()) {

					if (null != flightProposal.getUnitQualifier()) {
						if (flightProposal.getUnitQualifier().equalsIgnoreCase("EFT")) {
							resSgmt.setEFT(flightProposal.getRef());
							resSgmt.setTtlTripTm(
									flightProposal.getRef());

						} else if (flightProposal.getUnitQualifier().equalsIgnoreCase("MCX"))
							resSgmt.setMCX(flightProposal.getRef());
					}
				}

				resSgmt.setNoOfHops(groupOfFlights.getFlightDetails().size() - 1 + "");

				List<Connect> connectFilighDetails = new ArrayList<Connect>();

				int orderId = 1;
				for (FlightDetails flightDetails : groupOfFlights.getFlightDetails()) {

					Connect connect = new Connect();

					connect.setOrder(orderId + "");

					FlgtDtls flgtDtls = new FlgtDtls();
					flgtDtls.setMrktFlgtId(flightDetails.getFlightInformation().getCompanyId().getMarketingCarrier());
					flgtDtls.setOptFlight(flightDetails.getFlightInformation().getCompanyId().getOperatingCarrier());

					FromLoc fromLoc = new FromLoc();
					fromLoc.setDtTime(flightDetails.getFlightInformation().getProductDateTime().getDateOfDeparture()
							+ " " + flightDetails.getFlightInformation().getProductDateTime().getTimeOfDeparture());
					fromLoc.setLoc(flightDetails.getFlightInformation().getLocation().get(0).getLocationId());
					fromLoc.setTrmnl(flightDetails.getFlightInformation().getLocation().get(0).getTerminal());
					flgtDtls.setFromLoc(fromLoc);

					ToLoc toLoc = new ToLoc();
					toLoc.setDtTime(flightDetails.getFlightInformation().getProductDateTime().getDateOfArrival() + " "
							+ flightDetails.getFlightInformation().getProductDateTime().getTimeOfArrival());
					toLoc.setLoc(flightDetails.getFlightInformation().getLocation().get(1).getLocationId());
					toLoc.setTrmnl(flightDetails.getFlightInformation().getLocation().get(1).getTerminal());

					flgtDtls.setToLoc(toLoc);
					if (orderId != 1) {
						SimpleDateFormat format = new SimpleDateFormat("ddMMyy HHmm");
						Date departureTime = format.parse(flightDetails.getFlightInformation().getProductDateTime()
								.getDateOfDeparture() + " "
								+ flightDetails.getFlightInformation().getProductDateTime().getTimeOfDeparture());

						Date arrivalTime = format.parse(
								connectFilighDetails.get((orderId - 1) - 1).getFlgtDtls().getToLoc().getDtTime());

						// long diff = departureTime.getTime() - arrivalTime.getTime();

						// long layOverInMin = TimeUnit.MILLISECONDS.toMinutes(diff);

						connectFilighDetails.get((orderId - 1) - 1).getFlgtDtls()
								.setLayOverDuriation(getTimeDiff(departureTime, arrivalTime));
						// flgtDtls.getLayOverDuriation()

					}

					flightDetails.getFlightInformation().getLocation().get(0);
					flightDetails.getFlightInformation().getLocation().get(1);

					connect.setFlgtDtls(flgtDtls);
					connectFilighDetails.add(connect);

					orderId++;
				}
				resSgmt.setConnect(connectFilighDetails);
				propSegFlightDetails.put(propFlightIndex + "", resSgmt);
				propFlightIndex++;
			}
			flightIndexs.put(recSegIndex + "", propSegFlightDetails);
			recSegIndex++;
		}

		return flightIndexs;
	}

	/**
	 * 
	 * @param dateOne
	 * @param dateTwo
	 * @return
	 */
	public static String getTimeDiff(Date dateOne, Date dateTwo) {
		String diff = "";
		long timeDiff = Math.abs(dateOne.getTime() - dateTwo.getTime());
		diff = String.format("%d hour's %d min's", TimeUnit.MILLISECONDS.toHours(timeDiff),
				TimeUnit.MILLISECONDS.toMinutes(timeDiff)
						- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeDiff)));
		return diff;
	}

}
