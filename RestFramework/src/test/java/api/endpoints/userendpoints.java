package api.endpoints;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class userendpoints {
	
	public static Response createuser(user payload) {
		
		System.out.println("the create user is implementing ");
		
		Response response=given().accept(ContentType.JSON).contentType(ContentType.JSON).
		body(payload).when().post(Routers.post_url);
		
		return response;
		
	}
	
	public static Response getuser(String userName) {
		Response response=given().accept(ContentType.JSON).
				pathParam("username",userName).when().get(Routers.get_url);
		
		return response;
	}
	
	public static Response updateuser(String userName,user payload) {
		Response response=given().accept(ContentType.JSON).contentType(ContentType.JSON).
		pathParam("username",userName).body(payload).when().put(Routers.put_url);
		
		return response;
	}

}
