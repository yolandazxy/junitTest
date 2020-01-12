package service.user.api;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import service.Common;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;

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

    public Response getDepartMem(int department_id, boolean fetch_child) {
        return given()
                .queryParam("access_token", Common.getInstance().getToken())
                .queryParam("department_id", department_id)
                .queryParam("fetch_child", fetch_child)
        .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/user/simplelist")
        .then().log().all()
                .extract().response();
    }

    public Response update(String userid, HashMap<String, Object> data){
        data.put("userid", userid);
        return given()
                .queryParam("access_token", Common.getInstance().getToken())   //post下请求方法需为queryParam
                .queryParam("userid", userid)
                .body(data)
        .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/user/update")
        .then().log().all()
                .extract().response();

    }

    public Response create(String userid, HashMap<String, Object> data){
        data.put("userid", userid);
        return given()
                .queryParam("access_token", Common.getInstance().getToken())   //post下请求方法需为queryParam
                .body(data)
        .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/user/create")
        .then().log().all()
                .extract().response();
    }

    public Response delete(String userid){
        return given()
                .queryParam("access_token", Common.getInstance().getToken())
                .queryParam("userid", userid)
        .when().log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/user/delete")
        .then().log().all()
                .extract().response();
    }

    public Response batchDelete(HashMap<String, ArrayList<String>> data){
        return given()
                .queryParam("access_token", Common.getInstance().getToken())
                .body(data)
        .when().log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete")
        .then().log().all()
                .extract().response();
    }



    public Response clone(String userid, HashMap<String, Object> data) {
        data.put("userid", userid);
        //todo: 使用模板技术

        String body=template("/service/user/api/user.json", data);

        return given()
                .queryParam("access_token", Common.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(body)
                .when().log().all().post("https://qyapi.weixin.qq.com/cgi-bin/user/create")
                .then().log().all().extract().response();
    }


    public String template(String templatePath, HashMap<String, Object> data){
        Writer writer = new StringWriter();
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(this.getClass().getResource(templatePath).getPath());
        mustache.execute(writer, data);
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }


}
