package test.zoe.springEl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zoe
 * @date 2020/8/13 下午5:34
 */
public class TestEL {
    public static void main(String[] args) {
        Map<String,Object> var= new HashMap<>();
        var.put("value", "2020-08-13 17:24:52");
        Object parse = SpringElUtils.parse("value.substring(0,10)", var);
        System.out.println(parse);
    }
}
