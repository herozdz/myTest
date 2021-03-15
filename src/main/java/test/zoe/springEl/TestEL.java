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
        var.put("value1", "2020-08-12 17:24:52");
        Object parse = SpringElUtils.parse("value1.substring(0,10)", var);
        System.out.println(parse);

        int a = 200;
        Long b = 1L;
        int c = 200;
        ;
        System.out.println("2020+07".substring(0, 7));

    }
}
