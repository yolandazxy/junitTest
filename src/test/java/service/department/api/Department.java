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
 * @date 2020/1/4 6:39 PM
 */
public class Department {
    public int parentDepartId = 2;

    public Response list(int id){
        return given().
                queryParam("access_token", Common.getInstance().getToken()).
                queryParam("id", id).
                when().
                log().all().
                post("https://qyapi.weixin.qq.com/cgi-bin/department/list").
                then().log().all().
                body("errcode", equalTo(0)).
                extract().response();
    }

    public Response create(String name, int parentid){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("name", name);
        data.put("parentid", parentid);

        return given()
                .queryParam("access_token", Common.getInstance().getToken())   //post下请求方法需为queryParam
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all()
                .body("errcode", equalTo(0))
                .extract().response();
    }

    public Response create(String name){
        return create(name, parentDepartId);
    }

    public Response delete(int id){
        return given().
                queryParam("access_token", Common.getInstance().getToken()).
                queryParam("id", id).
        when().
                post("https://qyapi.weixin.qq.com/cgi-bin/department/delete").
        then().
                body("errcode", equalTo(0)).
        extract().response();
    }
}
