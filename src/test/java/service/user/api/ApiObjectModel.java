package service.user.api;

import java.util.HashMap;

/**
 * @author xiaoyun
 * @description
 * @date 2020/1/17 12:58 AM
 */
public class ApiObjectModel {
    HashMap<String,Object> query;
    HashMap<String,Object> header;
    HashMap<String,Object> postBody;
    String postBodyRaw;
    String method = "get";
    String url = "";

}
