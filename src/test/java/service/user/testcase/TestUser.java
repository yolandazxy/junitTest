package service.user.testcase;

import org.junit.Test;
import service.user.api.User;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @author xiaoyun
 * @description
 * @date 2020/1/8 12:19 AM
 */
public class TestUser {
    static User user = new User();

    @Test
    public void info(){
        user.get("zhumaomao").then().body("name", equalTo("朱毛毛"));
    }
}
