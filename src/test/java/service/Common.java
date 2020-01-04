package service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @author xiaoyun
 * @description
 * @date 2020/1/4 6:43 PM
 */
public class Common {
    // 公共方法，使用单例
    private static Common common;
    String token;


    public static Common getInstance(){
        if(common==null){
            common = new Common();
        }
        return common;
    }

    public String getToken(){
        if(token==null) {
            token =
                    given()
                            .param("corpid", "wwa57d7a5a44da3733")
                            .param("corpsecret", "C9gXelbZunpIOKV_1sp7QjmWrza_rnVVmw2DBxVkna8")
                            .when()
                            .log().all()
                            .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                            .then()
                            .body("errcode", equalTo(0))
                            .extract().body().path("access_token");
            System.out.println(token);
        }
        return token;
    }
}
