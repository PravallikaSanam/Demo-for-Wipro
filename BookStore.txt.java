//Name:S.N.S.Pravallika
//UserId: 24NAG1900_51
//Date:28-08-2024

package Milestone4;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BookStore {
	public class ReqResTest {
		  
		  
		  @BeforeClass
		  public void setUp() {
			  RestAssured.baseURI = "https://reqres.in";
			  
			  
		  }
		  @Test(priority=1)
		  public void GetUsers() {
			  RestAssured.given()
			     .when()
			     .get("/api/users?page=2")
			     .then()
			     .statusCode(200)
			     .body("page",equalTo(2))
			     .body("data",notNullValue())
			     .log().all();
		  }
		  
			  
		  @Test(priority=2)
		  public void GetUserById() {
			  RestAssured.given()
			     .when()
			     .get("/api/users/2")
			     .then()
			     .statusCode(200)
			     .body("data.id",equalTo(2))
			     .body("data.email",equalTo("janet.weaver@reqres.in"))
			     .body("data.first_name",equalTo("Janet"))
			     .body("data.last_name",equalTo("Weaver"));
		  }
		  @Test(priority=3)
		  public void postCreateUser() {
			  String requestBody = "{\"name\":\"morpheus\",\"job\":\"leader\"}";
			  
			  RestAssured.given()
			  
			     .body(requestBody)
			     .when()
			       .post("/api/users")
			      .then()
			        .statusCode(201);
		  }
		  @Test(priority=4)
		  public void putUpdateUser() {
			  String requestBody ="{\"name\":\"morpheus\",\"job\":\"zion resident\"}";
			  
			  RestAssured.given()
			   
			  .body(requestBody)
			     .when()
			       .put("/api/users/2")
			      .then()
			        .statusCode(200);
		  }
		  
		  @Test(priority=5)
		  public void PatchUser() {
			  String requestBody ="{\"name\":\"morpheus\",\"job\":\"zion resident\"}";
			  
			  RestAssured.given()
			   
			  .body(requestBody)
			     .when()
			       .patch("/api/users/2")
			      .then()
			        .statusCode(200);
		  }
		  
		  @Test(priority=6)
		  public void DeleteUser() {
			  RestAssured.given()
			    .when()
			        .delete("/api/users/2")
			    .then()
			       .statusCode(204);
			
		  
		  }

		}

}
