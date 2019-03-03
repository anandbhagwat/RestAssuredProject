package payload;

public class Payload {
	
	public static String getPostPayload() {
		String postPayload ="{"+

	  		    "\"location\":{"+

	  		        "\"lat\" : -38.383494,"+

	  		        "\"lng\" : 33.427362"+

	  		    "},"+

	  		    "\"accuracy\":100,"+

	  		    "\"name\":\"Bhagwat House\","+

	  		    "\"phone_number\":\"(+91) 7276261087\","+

	  		    "\"address\" : \"Shehar Peth\","+

	  		    "\"types\": [\"shoe park\",\"shop\"],"+

	  		    "\"website\" : \"http://google.com\","+

	  		    "\"language\" : \"French-IN\""+

	  		"}";
		return postPayload;
	}
	
	public static String getDeletePayload(String place_id) {
		String deletePayload = "{"+
	 		    "\"place_id\":\""+place_id+"\""+
	 		"}";
		return deletePayload;
	}
}
