package framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoyun
 * @description
 * @date 2020/1/18 1:21 PM
 */
public class PageObjectModel {
    public String engine="http";
    public HashMap<String, PageObjectElement> elements = new HashMap<>();
    public HashMap<String, PageObjectMethod> methods = new HashMap<>();

    public PageObjectModel(String engine){
        this.engine=engine;
    }

    public PageObjectModel() {

    }

    public PageObjectMethod getMethod(String method) {
        return methods.get(method);
    }

    public Response runHttp(String method){
        System.out.println(method);
        return null;
    }

    public Object run(String method){
        if(engine.equals("http")){
            return runHttp(method);
        }else if(engine.equals("appium")){
            return null;//runAppium(method);
        }else {
            System.out.println("please set engine var");
            return null;
        }
    }






}