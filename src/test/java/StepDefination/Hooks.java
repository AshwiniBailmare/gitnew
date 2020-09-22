package StepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
@Before("@DeletePlace")
public void beforeScenario() throws IOException
{
		StepDefination sd= new StepDefination();
		if(StepDefination.placeid== null) {

	 sd.add_place_payload_with("AshPratu", "Marathi", "RAMtek");
	 sd.user_calls_with_http_request("addPlaceAPI", "POST");
	 sd.verify_place_id_created_maps_to_with("AshPratu", "getPlaceAPI");
	}
}
}
