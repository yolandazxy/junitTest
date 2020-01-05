package service.department.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import service.Common;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @author xiaoyun
 * @description
 * @date 2020/1/5 12:36 PM
 */
public class Tag {

    public Response list(){
        return given().
                queryParam("access_token", Common.getInstance().getToken()).
        when().log().all().
                post("https://qyapi.weixin.qq.com/cgi-bin/tag/list").
        then().log().all().
                body("errcode", equalTo(0)).
        extract().response();
    }

    public Response create(String name){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("tagname", name);

        return given()
                .queryParam("access_token", Common.getInstance().getToken())   //post下请求方法需为queryParam
                .contentType(ContentType.JSON)
                .body(data)
        .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/create")
        .then().log().all()
                .body("errcode", equalTo(0))
                .extract().response();
    }

    public Response delete(int id){
        return given().
                queryParam("access_token", Common.getInstance().getToken()).
                queryParam("tagid", id).
        when().log().all().
                post("https://qyapi.weixin.qq.com/cgi-bin/tag/delete").
        then().log().all().
                body("errcode", equalTo(0)).
                extract().response();
    }


}
