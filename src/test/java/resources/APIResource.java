package resources;

public enum APIResource {
	
	addPlaceAPI("/maps/api/place/add/json"),
	
	getPlaceAPI("/maps/api/place/get/json"),
	
	deletePlaceAPI("/maps/api/place/delete/json");

	private String resourse;
	APIResource(String resource){
		this.resourse= resource;
	}
	
	public String getResource()
	{
		return resourse;
	}
}
