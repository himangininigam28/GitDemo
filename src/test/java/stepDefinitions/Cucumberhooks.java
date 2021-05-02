package stepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.junit.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Cucumberhooks {
	StepDefinition sD = new StepDefinition();
	@Before("@Delete" )
	public void BeforeDeletePlace() throws MalformedURLException, IOException, URISyntaxException {
		try {	
			if(StepDefinition.placeId ==  (null)) {
				sD.AddPlacePayload("Jaipur", "Urdu", "Moonstar lane, Kochi");
				sD.ApiRequestTrigger("AddPlaceAPI", "post");
				sD.placeid_is_successfully_generated("GetPlaceAPI", "get");
				StepDefinition.placeId = StepDefinition.amr1.getPlace_id();
				
				System.out.println(StepDefinition.placeId);
			}
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
			
	}

	
	/*@After
	public void AfterE2E() {
		
		if(StepDefinition.placeIdList.size()>0) {
			for(int i=0; i<StepDefinition.placeIdList.size();i++) {
				sD.DeleteAllPlaceIds(StepDefinition.placeIdList.get(i));
			}
		}
		
	}*/

}
