package test.zoe.lock;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Zoe
 * @date 2020/7/2 下午2:08
 */
public class DoRulesJson {
    static String tree = "[\n" +
            "{\"ruleName\":\"规则一\",\"ruleData\":{\n" +
            "\n" +
            "\"1001\":{\"type\":1,\"labelName\":\"品类\",\"data\":[{\"itemFirstCateCd\":\"1001\",\"itemFirstCateName\":\"一级品类名称\",\"itemSecondCateCd\":\"2001\",\"itemSecondCateName\":\"二级品类名称\",\"itemThirdCateCd\":\"3001\",\"itemThirdCateName\":\"三级品类名称\"}]},\n" +
            "\n" +
            "\"1002\":{\"type\":2,\"labelName\":\"品类\",\"data\":[{\"code\":\"2001\",\"name\":\"品牌1\"},{\"code\":\"2002\",\"name\":\"品牌2\"}]},\n" +
            "\"1003\":{\"type\":3,\"labelName\":\"品类\",\"data\":[{\"code\":\"3001\",\"name\":\"商家1\"},{\"code\":\"3002\",\"name\":\"商家2\"}]},\n" +
            "\"1004\":{\"type\":4,\"labelName\":\"品类\",\"data\":[{\"code\":\"erp1\",\"name\":\"erp1\"},{\"code\":\"erp2\",\"name\":\"erp2\"}]},\n" +
            "\"1005\":{\"type\":5,\"labelName\":\"品类\",\"data\":[\n" +
            "{\"flag\":\"1\",\"beginValue\":\"100\",\"unit\":\"名\"} ,\n" +
            "\n" +
            "{\"flag\":\"2\",\"beginValue\":\"200\",\"unit\":\"个\"},\n" +
            "\n" +
            "{\"flag\":\"3\",\"beginValue\":\"250\",\"unit\":\"个\"},\n" +
            "\n" +
            "{\"flag\":\"4\",\"beginValue\":\"250\",\"endValue\":\"280\",\"unit\":\"个\"}\n" +
            "\n" +
            "]},\n" +
            "\n" +
            "\"1006\":{\"type\":6,\"labelName\":\"品类\",\"data\":[{\"code\":\"1\",\"name\":\"选项1\"},{\"code\":\"2\",\"name\":\"选项2\"}]},\n" +
            "\"1007\":{\"type\":7,\"labelName\":\"品类\",\"data\":[{\"code\":\"1\",\"name\":\"选项1\"}]},\n" +
            "\"1008\":{\"type\":8,\"labelName\":\"品类\",\"data\":[{\"text\":\"保存的文本信息1，保存的文本信息2\"}]}\n" +
            "}\n" +
            "},{\"ruleName\":\"规则二\",\"ruleData\":{\n" +
            "\n" +
            "\"1001\":{\"type\":1,\"labelName\":\"规则-品类\",\"data\":[{\"itemFirstCateCd\":\"规则-1001\",\"itemFirstCateName\":\"规则-一级品类名称\",\"itemSecondCateCd\":\"规则-2001\",\"itemSecondCateName\":\"规则-二级品类名称\",\"itemThirdCateCd\":\"规则-3001\",\"itemThirdCateName\":\"规则-三级品类名称\"}]},\n" +
            "\n" +
            "\"1002\":{\"type\":2,\"labelName\":\"规则-品类\",\"data\":[{\"code\":\"规则-2001\",\"name\":\"规则-品牌1\"},{\"code\":\"规则-2002\",\"name\":\"规则-品牌2\"}]},\n" +
            "\"1003\":{\"type\":3,\"labelName\":\"规则-品类\",\"data\":[{\"code\":\"规则-3001\",\"name\":\"规则-商家1\"},{\"code\":\"3002\",\"name\":\"规则-商家2\"}]},\n" +
            "\"1004\":{\"type\":4,\"labelName\":\"规则-品类\",\"data\":[{\"code\":\"规则-erp1\",\"name\":\"规则-erp1\"},{\"code\":\"规则-erp2\",\"name\":\"规则-erp2\"}]},\n" +
            "\"1005\":{\"type\":5,\"labelName\":\"规则-品类\",\"data\":[\n" +
            "{\"flag\":\"1\",\"beginValue\":\"100\",\"unit\":\"规则-名\"} ,\n" +
            "\n" +
            "{\"flag\":\"2\",\"beginValue\":\"200\",\"unit\":\"规则-个\"},\n" +
            "\n" +
            "{\"flag\":\"3\",\"beginValue\":\"250\",\"unit\":\"规则-个\"},\n" +
            "\n" +
            "{\"flag\":\"4\",\"beginValue\":\"250\",\"endValue\":\"280\",\"unit\":\"个\"}\n" +
            "\n" +
            "]},\n" +
            "\n" +
            "\"1006\":{\"type\":6,\"labelName\":\"品类\",\"data\":[{\"code\":\"规则-1\",\"name\":\"选项1\"},{\"code\":\"2\",\"name\":\"选项2\"}]},\n" +
            "\"1007\":{\"type\":7,\"labelName\":\"品类\",\"data\":[{\"code\":\"规则-1\",\"name\":\"选项1\"}]},\n" +
            "\"1008\":{\"type\":8,\"labelName\":\"品类\",\"data\":[{\"text\":\"保存的文本信息1，保存的文本信息2\"}]}\n" +
            "}\n" +
            "}\n" +
            "\n" +
            "]";

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        JSONArray array = JSON.parseArray(tree);
        List<Map> rules = JSON.parseArray(tree, Map.class);
        /*for(int i=0;i<array.size();i++){
            JSONObject level1Obj = array.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
            String valueLevel1 = (String)level1Obj.get("1008");
            JSONArray data = (JSONArray)level1Obj.get("ruleData");
            System.out.println(level1Obj);
            System.out.println("*************");
            System.out.println(data);
        }*/
        System.out.println(rules);
        JSONObject jsonObjectFinall = new JSONObject();
        for (Map rule : rules) {//多个规则
            System.out.println(rule.get("ruleData"));
            JSONObject jsonObject = (JSONObject) rule.get("ruleData");
            for (Map.Entry<String, Object> m : jsonObject.entrySet()) {
                String key = m.getKey();
                JSONObject value = (JSONObject)m.getValue();
                if(null == jsonObjectFinall.get(key)){
                    jsonObjectFinall.put(key,value);
                } else {
                    JSONObject source = (JSONObject)jsonObjectFinall.get(key);
                    JSONArray data = (JSONArray)source.get("data");
                    if(null != data){
                        data.addAll((JSONArray)value.get("data")) ;
                    }
                }
            }
            System.out.println("deepMerge.res:"+jsonObjectFinall);
        }

        Map<String,Object> m = new HashMap<>();
        m.put("1","");
        System.out.println("mmmmm:"+m);
    }

    /**
     *
     * @param source
     * @param target
     * @return
     * @throws JSONException
     */
    public static JSONObject deepMerge(JSONObject source, JSONObject target) throws JSONException {


        for (String key: source.keySet()) {
            Object value = source.get(key);
            if (!target.containsKey(key)) {
                // new value for "key":
                target.put(key, value);
            } else {
                // existing value for "key" - recursively deep merge:
                if (value instanceof JSONObject) {
                    JSONObject valueJson = (JSONObject)value;
                    deepMerge(valueJson, target.getJSONObject(key));
                } else {
                    target.put(key, value);
                }
            }
        }
        return target;

    }

}
