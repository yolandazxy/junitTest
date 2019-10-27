/**
 * @author xiaoyun
 * @description
 * @date 2019/10/27 3:17 PM
 */
public class Calculator {
    public Integer divid(Integer a,Integer b){
        if(b==0){
            return null;
        }else {
            return a / b;
        }
    }

    public Integer add(Integer a,Integer b){
        if(a<0 || b< 0){
            return null;
        }else{
            return a + b;
        }
    }
}
