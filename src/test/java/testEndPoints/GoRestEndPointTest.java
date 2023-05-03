package testEndPoints;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import goRestUser.GoRestEndPoint;
import io.restassured.response.Response;
import payload.User;
import routes.Routes;
import utilities.FileUtil;

public class GoRestEndPointTest {

	static Faker faker = new Faker();
    static User userpayload = new User();
	
	public static Logger loger = LogManager.getLogger("gorest");
    @Test(priority=2)
    public void testGetRequest() throws IOException {
    	
    	String endpoint = Routes.get_url;
        String httpMethod = "get";
        Response response = GoRestEndPoint.sendRequest(endpoint, httpMethod, null,null);
        
        loger.log(Level.INFO, "*****testGetRequest User Details Saved to gorest.log *****\n");
        loger.log(Level.INFO, response.prettyPrint());
     
    }

    @Test(priority=1)
    public void testPostRequest() throws IOException {
        String endpoint = Routes.post_url;
        String httpMethod = "post";
        userpayload.setName(faker.name().fullName());
        userpayload.setEmail(faker.internet().emailAddress());
        userpayload.setGender("Male");
        userpayload.setStatus("inactive");
        
        Response response = GoRestEndPoint.sendRequest(endpoint, httpMethod, userpayload,null);
        String id = response.body().jsonPath().getString("id").toString();
        FileUtil.writeToFile("./src/test/resources/UserId.txt",id);
        loger.log(Level.INFO, "*****testPostRequest-- data saved in gorest.log  *****\n");
        loger.log(Level.INFO, response.prettyPrint());
    }
    
    
    @Test(priority=3)
    public void testPatchRequest() throws IOException {
        String endpoint = Routes.update_url;
        String httpMethod = "patch";
        userpayload.setEmail(faker.internet().emailAddress());
        userpayload.setStatus("active");
        Path path = Paths.get("./src/test/resources/UserId.txt");
		String id = Files.readString(path);
        Response response = GoRestEndPoint.sendRequest(endpoint, httpMethod, userpayload,id);
        loger.log(Level.INFO, "*****testPatchRequest-- data saved in gorest.log  *****\n");
        loger.log(Level.INFO, response.prettyPrint());
    }
    
    @Test(priority=4)
    public void testDeleteRequest() throws IOException {
        String endpoint = Routes.delete_url;
        String httpMethod = "delete";
        Path path = Paths.get("./src/test/resources/UserId.txt");
		String id = Files.readString(path);
        Response response = GoRestEndPoint.sendRequest(endpoint, httpMethod, userpayload,id);
        loger.log(Level.INFO, "*****testDeleteRequest-- data saved in gorest.log  *****\n");
        loger.log(Level.INFO, response.prettyPrint());
    }

 
}
