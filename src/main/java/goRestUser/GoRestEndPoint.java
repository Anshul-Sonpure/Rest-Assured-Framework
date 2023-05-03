package goRestUser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GoRestEndPoint {

	public static Response sendRequest(String endpoint, String httpMethod, Object payload, String id)
			throws IOException {

		Path path = Paths.get("./src/main/java/goRestUser/token.txt");
		String token = Files.readString(path);
		Response response = null;
		switch (httpMethod.toLowerCase()) {
		case "get":
			response = RestAssured.given().when().get(endpoint).then().extract().response();
			break;
		case "post":
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + token).contentType(ContentType.JSON).accept(ContentType.JSON)
					.body(payload).when().post(endpoint).then().extract().response();
			break;
		case "patch":
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + token).pathParam("id", id).contentType(ContentType.JSON)
					.body(payload).when().patch(endpoint).then().extract().response();
			break;
		case "delete":
			response = RestAssured.given().header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + token).pathParam("id", id).when().delete(endpoint).then()
					.extract().response();
			break;
		default:
			System.out.println("Unsupported HTTP method");
			break;
		}
		return response;
	}
}
