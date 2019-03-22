package GT.GT;
//import static com.jayway.restassured.RestAssured.get;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import com.jayway.restassured.response.Response;
//
//public class RestApiTest {
//
//	@Test
//	public void getRequestFindCapital() throws JSONException {
//		
//		//make get request to fetch capital of norway
//		Response resp = get("http://restcountries.eu/rest/v1/name/norway");
//		
//		//Fetching response in JSON
//		JSONArray jsonResponse = new JSONArray(resp.asString());
//		
//		//Fetching value of capital parameter
//		String capital = jsonResponse.getJSONObject(0).getString("capital");
//		
//		//Asserting that capital of Norway is Oslo
//		Assert.assertEquals(capital, "Oslo");
//	}
//	
//}

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApiTest {

	@Test
	public void getWeatherDetails()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "/Hyderabad");

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		int statusCode = response.getStatusCode();
		System.out.println("Status code is::"+statusCode);
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	}

	@Test
	public void GetWeatherDetailsInvalidCity()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/78789798798");
		int statusCode = response.getStatusCode();
		System.out.println("Status code is::"+statusCode);
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	}
	
	@Test
	public void RegistrationSuccessful()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "sdimpleuser2dd2011");
		requestParams.put("Password", "password1");

		requestParams.put("Email",  "sample2ee26d9@gmail.com");
	//	request.header("Content-Type", "application/json");
		request.body(requestParams.toString());
		Response response = request.post("/register");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		//Assert.assertEquals( 200, statusCode);
	}
	
	
	@Test
	public void createNewCall()
	{		
//		RestAssured.baseURI ="https://restapi.smscountry.com/v0.1/Accounts/sIkXPrYqDPe6xxjZgT1z/Calls/";
//		RequestSpecification request =  RestAssured.given().auth().preemptive().basic("sIkXPrYqDPe6xxjZgT1z", "hd5W2d2bcAzs8tmRMawxWJTw1qWpVe5og0sM2CMV");
////		RestAssured.baseURI ="https://restapi.smscountry.com/v0.1/Accounts/sIkXPrYqDPe6xxjZgT1z/Calls/";
////		Header acceptJson = new Header("Accept", "application/json");
////		Header authorizationJson = new Header("Authorization", "Basic c0lrWFByWXFEUGU2eHhqWmdUMXo6aGQ1VzJkMmJjQXpzOHRtUk1hd3hXSlR3MXFXcFZlNW9nMHNNMkNNVg==");
////		//RestAssured.authentication = RestAssured.basic("sIkXPrYqDPe6xxjZgT1z", "hd5W2d2bcAzs8tmRMawxWJTw1qWpVe5og0sM2CMV");
////		RequestSpecification request = RestAssured.given();	
////		//.auth().preemptive().basic("sIkXPrYqDPe6xxjZgT1z", "hd5W2d2bcAzs8tmRMawxWJTw1qWpVe5og0sM2CMV");
////		
//		//RestAssured.authentication = RestAssured.basic("sIkXPrYqDPe6xxjZgT1z", "hd5W2d2bcAzs8tmRMawxWJTw1qWpVe5og0sM2CMV");
//		//RequestSpecification request = RestAssured.given();
////		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
////		authScheme.setUserName("sIkXPrYqDPe6xxjZgT1z");
////		authScheme.setPassword("hd5W2d2bcAzs8tmRMawxWJTw1qWpVe5og0sM2CMV");
////		RestAssured.authentication = authScheme;
//		//RequestSpecification request = RestAssured.given().authentication().preemptive().basic("sIkXPrYqDPe6xxjZgT1z", "hd5W2d2bcAzs8tmRMawxWJTw1qWpVe5og0sM2CMV");
//		//RequestSpecification request = RestAssured.given();
//		
//		JSONObject requestParams = new JSONObject();
//		requestParams.put("Number", "918331996838");
//		requestParams.put("CallerId", "+914038119515");
//		requestParams.put("Xml", "<Response><play>https://gaana.com/song/peniviti</play><play>https://new.grptalk.com/voicefiles/numbersclips/OnceAgain.mp3</play><Hangup/></Response>");
//		requestParams.put("AnswerUrl", "www.grtalk.com");
//		request.header("Content-Type", "application/json");
//		request.header("Authorization","Basic c0lrWFByWXFEUGU2eHhqWmdUMXo6aGQ1VzJkMmJjQXpzOHRtUk1hd3hXSlR3MXFXcFZlNW9nMHNNMkNNVg==");
//		System.out.println(requestParams.toString());
//		request.body(requestParams.toJSONString());
//		
//		//Response response = request.get();
//		Response response = request.post();
//	//	  String authorizationHeader = response.getHeader("Basic c0lrWFByWXFEUGU2eHhqWmdUMXo6aGQ1VzJkMmJjQXpzOHRtUk1hd3hXSlR3MXFXcFZlNW9nMHNNMkNNVg==");
//		//Response response = request.header("Authorization","Basic c0lrWFByWXFEUGU2eHhqWmdUMXo6aGQ1VzJkMmJjQXpzOHRtUk1hd3hXSlR3MXFXcFZlNW9nMHNNMkNNVg==").post("");
//		int statusCode = response.getStatusCode();
//		Assert.assertEquals(statusCode, 202);
//		
		
//		 String restAPIUrl = "https://restapi.smscountry.com/v0.1/Accounts/sIkXPrYqDPe6xxjZgT1z/Calls/";
//		 
//		 //API Body
//		 String apiBody = "{\"Number\":\"918331996838\",\"CallerId\":\"+914038119515\",\"Xml\":\"<Response><play>https://gaana.com/song/peniviti</play><play>https://new.grptalk.com/voicefiles/numbersclips/OnceAgain.mp3</play><Hangup/></Response>\",\"AnswerUrl\":\"www.grptalk.com\"}";
//		 
//		 // Building request by using requestSpecBuilder
//		 RequestSpecBuilder builder = new RequestSpecBuilder();
//		 
//		 //Set API's Body
//		 builder.setBody(apiBody);
//		 
//		 //Setting content type as application/json
//		 builder.setContentType("application/json; charset=UTF-8");
//		 
//		 RequestSpecification requestSpec = builder.build();
//		 
//		 //Making post request with authentication or leave blank if you don't have credentials like: basic("","")
//		 Response response = RestAssured.given().auth().preemptive().basic("sIkXPrYqDPe6xxjZgT1z", "hd5W2d2bcAzs8tmRMawxWJTw1qWpVe5og0sM2CMV")
//		 .spec(requestSpec).when().post(restAPIUrl);
//		 
//		 JSONObject JSONResponseBody = new JSONObject(response.body().asString());
//		 
//		 //Get the desired value of a parameter
//		 String result = JSONResponseBody.getString("{apiBody}");
//		 
//		 //Check the Result
	//	 Assert.assertEquals(result, "{expectedValue}");
		 
//		 int statusCode = response.getStatusCode();
//		 System.out.println("res::::::"+statusCode);
//		Assert.assertEquals(statusCode, 202);
		
		
		  
		  JSONObject requestParams = new JSONObject();
			requestParams.put("Number", "+918331996838");
			requestParams.put("CallerId", "+914038119515");
			requestParams.put("Xml", "<Response><play>https://gaana.com/song/peniviti</play><play>https://new.grptalk.com/voicefiles/numbersclips/OnceAgain.mp3</play><Hangup/></Response>");
			requestParams.put("AnswerUrl", "www.grtalk.com");
			
			RestAssured.baseURI  = "https://restapi.smscountry.com/v0.1/Accounts/sIkXPrYqDPe6xxjZgT1z/"; 
			RequestSpecification request= RestAssured.given().auth().preemptive().basic("sIkXPrYqDPe6xxjZgT1z", "hd5W2d2bcAzs8tmRMawxWJTw1qWpVe5og0sM2CMV");
		  //  		 .contentType("application/json").body("{\"Number\":\"918331996838\",\"CallerId\":\"+914038119515\",\"Xml\":\"<Response><play>https://gaana.com/song/peniviti</play><play>https://new.grptalk.com/voicefiles/numbersclips/OnceAgain.mp3</play><Hangup/></Response>\",\"AnswerUrl\":\"www.grptalk.com\"}").
		 //   when().post("");
		// Response response = request.post("{\"Number\":\"918331996838\",\"CallerId\":\"+914038119515\",\"Xml\":\"<Response><play>https://gaana.com/song/peniviti</play><play>https://new.grptalk.com/voicefiles/numbersclips/OnceAgain.mp3</play><Hangup/></Response>\",\"AnswerUrl\":\"www.grptalk.com\"}");
		//  request.header("Content-Type", "application/json");
			request.body(requestParams.toString());
			Response response = request.post("Calls/");
		  int statusCode = response.getStatusCode();
		 System.out.println("Status code is::"+statusCode);
		 Assert.assertEquals(statusCode, 200 );
		// String body = response.getBody().asString();
		// System.out.println(body);
		 
	}
	
	@Test
	public void getTemplate()
	{	
		RestAssured.baseURI ="https://restapi.smscountry.com/v0.1/Accounts/sIkXPrYqDPe6xxjZgT1z/Templates/";
		RequestSpecification request =  RestAssured.given().auth().preemptive().basic("sIkXPrYqDPe6xxjZgT1z", "hd5W2d2bcAzs8tmRMawxWJTw1qWpVe5og0sM2CMV");
		Response response = request.get();
		int statusCode = response.getStatusCode();
		System.out.println("Status code is::"+statusCode);
		Assert.assertEquals(statusCode, 200 );
	}
}


