package resources;

public class Resources {
		
	public static String postData() {
		String placePostData = "/maps/api/place/add/json";
		return placePostData;
	}
	public static String deleteData() {
		String placeDeleteData = "/maps/api/place/delete/json";
		return placeDeleteData;
	}
}
