package service.user.testcase;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.junit.Test;
import service.user.api.User;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;

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

    @Test
    public void departMemInfo(){
        int departmentid = 2;
        boolean fetch_child = false;
        user.getDepartMem(departmentid,fetch_child).then().body("errcode", equalTo(0));
    }

    @Test
    public void update(){
        String userid = "zhuyunyun";
        String nameNew = "name for testing";
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", nameNew);
        data.put("address","address for testing");
        user.update(userid, data);
        user.get(userid).then().body("name", equalTo(nameNew));
    }

    @Test
    public void create(){
        String nameNew = "name for testing";
        String userid = "maomao" + System.currentTimeMillis();

        HashMap<String, Object> data = new HashMap<>();
        data.put("name", nameNew);
        data.put("department",new int[]{2});
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0,11));
        data.put("address","address for testing");

        user.create(userid, data).then().body("errcode", equalTo(0));

        user.get(userid).then().body("name", equalTo(nameNew));

    }

    @Test
    public void createFromTemplate(){
        user.get("maomao_1");
        String nameNew = "name for testing";
        String userid = "maomao" + System.currentTimeMillis();

        HashMap<String, Object> data = new HashMap<>();
        data.put("name", nameNew);
        data.put("department",new int[]{2});
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0,11));

        user.create(userid, data).then().body("errcode", equalTo(0));

        user.get(userid).then().body("name", equalTo(nameNew));
    }

    @Test
    public void cloneUser(){
        String nameNew = "name for testing";
        String userid = "maomao" + System.currentTimeMillis();

        HashMap<String, Object> data = new HashMap<>();
        data.put("name", nameNew);
        // data.put("department",new int[]{2});
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0,11));

        user.clone(userid, data).then().body("errcode", equalTo(0));

        user.get(userid).then().body("name", equalTo(nameNew));
    }

    @Test
    public void delete(){
        String nameNew = "name for testing";
        String userid = "maomao" + System.currentTimeMillis();

        HashMap<String, Object> data = new HashMap<>();
        data.put("name", nameNew);
        // data.put("department",new int[]{2});
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0,11));

        user.clone(userid, data).then().body("errcode", equalTo(0));

        user.delete(userid).then().body("errcode", equalTo(0));
        user.get(userid).then().body("errcode", not(0));

    }

    @Test
    public void batchdelete(){
        ArrayList<String> userids = new ArrayList<>();
        int n = 3;
        String nameNew = "name for testing";
        for(int i=0;i<n;i++) {
            String userid = "maomao" + System.currentTimeMillis();
            HashMap<String, Object> data = new HashMap<>();
            data.put("name", nameNew);
            // data.put("department",new int[]{2});
            data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0,11));

            user.clone(userid, data).then().body("errcode", equalTo(0));
            userids.add(userid);
        }
        HashMap<String, ArrayList<String>> batchdata = new HashMap<>();
        batchdata.put("useridlist", userids);

        user.batchDelete(batchdata).then().body("errcode", equalTo(0));

        for(int i=0;i<n;i++){
            user.get(userids.get(i)).then().body("errcode", not(equalTo(0)));

        }
    }




    /*
    @Test
    public void template() throws IOException {
        HashMap<String, Object> data = new HashMap<String, Object>();
        String nameNew = "name for testing";

        data.put("name", nameNew);
        data.put("userid","maomao" + System.currentTimeMillis());
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0,11));

        Writer writer = new OutputStreamWriter(System.out);
        MustacheFactory mf = new DefaultMustacheFactory();
        // Mustache mustache = mf.compile("/Users/xiaoyun/git_pro/junitTest/src/main/resources/service/user/api/user.json");
        Mustache mustache = mf.compile("/Users/xiaoyun/git_pro/junitTest/src/main/resources/service/user/api/user.json");
        mustache.execute(writer, data);
        writer.flush();
    }
    */

}
