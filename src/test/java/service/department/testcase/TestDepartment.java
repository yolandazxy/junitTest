package service.department.testcase;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import service.department.api.Department;

import java.util.ArrayList;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

/**
 * @author xiaoyun
 * @description
 * @date 2020/1/4 6:18 PM
 */
public class TestDepartment {
    static Department department = new Department();

    @BeforeClass
    public static void beforeall(){
        // 数据清理
        ArrayList<Integer> ids= department.list(department.parentDepartId).then()
                             .extract().body().path("department.findAll {item -> item.parentid=="+ department.parentDepartId +" }.id");
        System.out.println(ids);
        ids.forEach(id -> department.delete(id));

    }

    @Test
    public void testList(){
        department.list(department.parentDepartId).then().body("errmsg", equalTo("ok"));

    }

    @Test
    public void testCreate(){
        String name = "部门2";
        department.create(name).then().body("errmsg", equalTo("created"));
        department.list(department.parentDepartId)
                .then().body("department.findAll {item -> item.name=='"+ name +"' }.id", hasSize(1));

    }

    @Test
    public void testDelete(){
        int id = department.create("部门3").then().body("errmsg", equalTo("created"))
                .extract().body().path("id");
        department.delete(id).then().body("errmsg", equalTo("deleted"));

    }
}
