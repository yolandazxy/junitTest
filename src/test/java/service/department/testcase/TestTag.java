package service.department.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import service.department.api.Tag;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

/**
 * @author xiaoyun
 * @description
 * @date 2020/1/5 12:36 PM
 */
public class TestTag {
    static Tag tag = new Tag();

    @BeforeClass
    public static void beforeall(){
        // 数据清理
        ArrayList<Integer> ids= tag.list().then()
                .extract().body().path("taglist.findAll { item -> item.tagid>0 }.tagid");
        System.out.println(ids);
        ids.forEach(id -> tag.delete(id));

    }

    @Test
    public void testList(){
        tag.list().then().body("errmsg", equalTo("ok"));

    }

    @Test
    public void testCreate(){
        String name = "标签2";
        tag.create(name).then().body("errmsg", equalTo("created"));
        tag.list()
                .then().body("taglist.findAll { item -> item.tagid>0 }.tagid", hasSize(1));

    }

    @Test
    public void testDelete(){
        int id = tag.create("标签3").then().body("errmsg", equalTo("created"))
                .extract().body().path("tagid");
        tag.delete(id).then().body("errmsg", equalTo("deleted"));

    }
}
