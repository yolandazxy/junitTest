package service.department;

import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @author xiaoyun
 * @description
 * @date 2020/1/4 3:27 PM
 */
public class TestClassicDepart {
    static String token;
    static int parentDepartId = 2;
    static String my_corpid = "wwa57d7a5a44da3733";
    static String my_corpsecret = "C9gXelbZunpIOKV_1sp7QjmWrza_rnVVmw2DBxVkna8";


    @BeforeClass
    public static void getToken(){
        token =
        given()
                .param("corpid", my_corpid)
                .param("corpsecret", my_corpsecret)
        .when()
                .log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
        .then()
                .body("errcode", equalTo(0))
        .extract().body().path("access_token");
        System.out.println(token);
    }

    @Test
    public void testDepartCreate(){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("name", "毛毛top1");
        data.put("parentid", parentDepartId);
        System.out.println(data);

        given()
                .queryParam("access_token", token)   //post下请求方法需为queryParam
                .contentType(ContentType.JSON)
                .body(data)
        .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
        .then().log().all()
                .body("errcode", equalTo(0));
        // todo 校验过程中可能用到list接口，但如果编写list请求，会导致代码冗余所带来的维护问题，所以引入PO思想
    }

    @Test
    public void testDepartList(){
        given().
                queryParam("access_token", token).
                queryParam("id", parentDepartId).
        when().
                log().all().
                post("https://qyapi.weixin.qq.com/cgi-bin/department/list").
        then().log().all().
                body("errcode", equalTo(0));
    }
}
