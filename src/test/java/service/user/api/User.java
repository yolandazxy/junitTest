package service.user.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import service.Common;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @author xiaoyun
 * @description
 * @date 2020/1/7 12:42 AM
 */
public class User {

    public Response get(String userid) {
        return given()
                .queryParam("access_token", Common.getInstance().getToken())   //post下请求方法需为queryParam
                .queryParam("userid", userid)
        .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/user/get")
        .then().log().all()
                .extract().response();
    }
}
