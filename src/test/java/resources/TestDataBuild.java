package resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;

public class TestDataBuild {

	public AddPlace addplacePayload(String name,String language,String address)
	{
		AddPlace p = new AddPlace ();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		p.setName(name);

		List<String> mylist = new ArrayList<String>();

		mylist.add("shoe park");
		mylist.add("shop");

		p.setTypes(mylist);

		Location l = new Location();
		l.setLat(-38.4885758);
		l.setLng(33.5845145);
		p.setLocation(l);
		return p;

	}
	
	public String deletePlacePayload(String placeid)
	{
		return "{\r\n \"place_id\": \""+placeid+"\"\r\n}";
	}
}
