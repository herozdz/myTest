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

    static String topNTest = "[\n" +
            "    {\n" +
            "        \"ruleName\": \"规则一\",\n" +
            "        \"topN\": {\n" +
            "            \"2005\": {\n" +
            "                \"type\": 5,\n" +
            "                \"labelName\": \"品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"flag\": \"1\",\n" +
            "                        \"beginValue\": \"100\",\n" +
            "                        \"unit\": \"名\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"2006\": {\n" +
            "                \"type\": 5,\n" +
            "                \"labelName\": \"品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"flag\": \"1\",\n" +
            "                        \"beginValue\": \"100\",\n" +
            "                        \"unit\": \"个\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        },\n" +
            "        \"ruleData\": {\n" +
            "            \"1001\": {\n" +
            "                \"type\": 1,\n" +
            "                \"labelName\": \"品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"itemFirstCateCd\": \"1001\",\n" +
            "                        \"itemFirstCateName\": \"一级品类名称\",\n" +
            "                        \"itemSecondCateCd\": \"2001\",\n" +
            "                        \"itemSecondCateName\": \"二级品类名称\",\n" +
            "                        \"itemThirdCateCd\": \"3001\",\n" +
            "                        \"itemThirdCateName\": \"三级品类名称\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"1002\": {\n" +
            "                \"type\": 2,\n" +
            "                \"labelName\": \"品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"code\": \"2001\",\n" +
            "                        \"name\": \"品牌1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"code\": \"2002\",\n" +
            "                        \"name\": \"品牌2\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"1003\": {\n" +
            "                \"type\": 3,\n" +
            "                \"labelName\": \"品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"code\": \"3001\",\n" +
            "                        \"name\": \"商家1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"code\": \"3002\",\n" +
            "                        \"name\": \"商家2\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"1004\": {\n" +
            "                \"type\": 4,\n" +
            "                \"labelName\": \"品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"code\": \"erp1\",\n" +
            "                        \"name\": \"erp1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"code\": \"erp2\",\n" +
            "                        \"name\": \"erp2\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"1005\": {\n" +
            "                \"type\": 5,\n" +
            "                \"labelName\": \"品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"flag\": \"2\",\n" +
            "                        \"beginValue\": \"200\",\n" +
            "                        \"unit\": \"个\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"flag\": \"3\",\n" +
            "                        \"beginValue\": \"250\",\n" +
            "                        \"unit\": \"个\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"flag\": \"4\",\n" +
            "                        \"beginValue\": \"250\",\n" +
            "                        \"endValue\": \"280\",\n" +
            "                        \"unit\": \"个\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"1006\": {\n" +
            "                \"type\": 6,\n" +
            "                \"labelName\": \"品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"code\": \"1\",\n" +
            "                        \"name\": \"选项1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"code\": \"2\",\n" +
            "                        \"name\": \"选项2\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"1007\": {\n" +
            "                \"type\": 7,\n" +
            "                \"labelName\": \"品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"code\": \"1\",\n" +
            "                        \"name\": \"选项1\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"1008\": {\n" +
            "                \"type\": 8,\n" +
            "                \"labelName\": \"品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"text\": \"保存的文本信息1，保存的文本信息2\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        }\n" +
            "    },\n" +
            "    {\n" +
            "        \"ruleName\": \"规则二\",\n" +
            "        \"topN\": {\n" +
            "            \"2005\": {\n" +
            "                \"type\": 5,\n" +
            "                \"labelName\": \"品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"flag\": \"1\",\n" +
            "                        \"beginValue\": \"99\",\n" +
            "                        \"unit\": \"名\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"2006\": {\n" +
            "                \"type\": 5,\n" +
            "                \"labelName\": \"品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"flag\": \"1\",\n" +
            "                        \"beginValue\": \"50\",\n" +
            "                        \"unit\": \"个\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        },\n" +
            "        \"ruleData\": {\n" +
            "            \"1001\": {\n" +
            "                \"type\": 1,\n" +
            "                \"labelName\": \"品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"itemFirstCateCd\": \"规则二1001\",\n" +
            "                        \"itemFirstCateName\": \"规则二一级品类名称\",\n" +
            "                        \"itemSecondCateCd\": \"规则二2001\",\n" +
            "                        \"itemSecondCateName\": \"二级品类名称\",\n" +
            "                        \"itemThirdCateCd\": \"规则二3001\",\n" +
            "                        \"itemThirdCateName\": \"规则二三级品类名称\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"1002\": {\n" +
            "                \"type\": 2,\n" +
            "                \"labelName\": \"规则二品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"code\": \"规则二2001\",\n" +
            "                        \"name\": \"规则二品牌1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"code\": \"规则二2002\",\n" +
            "                        \"name\": \"规则二品牌2\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"1003\": {\n" +
            "                \"type\": 3,\n" +
            "                \"labelName\": \"规则二品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"code\": \"规则二3001\",\n" +
            "                        \"name\": \"商家1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"code\": \"规则二3002\",\n" +
            "                        \"name\": \"规则二商家2\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"1004\": {\n" +
            "                \"type\": 4,\n" +
            "                \"labelName\": \"规则二品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"code\": \"规则二erp1\",\n" +
            "                        \"name\": \"erp1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"code\": \"规则二erp2\",\n" +
            "                        \"name\": \"规则二erp2\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"1005\": {\n" +
            "                \"type\": 5,\n" +
            "                \"labelName\": \"规则二品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"flag\": \"2\",\n" +
            "                        \"beginValue\": \"200\",\n" +
            "                        \"unit\": \"规则二个\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"flag\": \"3\",\n" +
            "                        \"beginValue\": \"250\",\n" +
            "                        \"unit\": \"规则二个\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"flag\": \"4\",\n" +
            "                        \"beginValue\": \"250\",\n" +
            "                        \"endValue\": \"280\",\n" +
            "                        \"unit\": \"个\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"1006\": {\n" +
            "                \"type\": 6,\n" +
            "                \"labelName\": \"品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"code\": \"规则二1\",\n" +
            "                        \"name\": \"选项1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"code\": \"规则二2\",\n" +
            "                        \"name\": \"选项2\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"1007\": {\n" +
            "                \"type\": 7,\n" +
            "                \"labelName\": \"品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"code\": \"规则二1\",\n" +
            "                        \"name\": \"选项1\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            \"1008\": {\n" +
            "                \"type\": 8,\n" +
            "                \"labelName\": \"品类\",\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"text\": \"规则二保存的文本信息1，保存的文本信息2\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "]";

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Map> rules = JSON.parseArray(topNTest, Map.class);
        System.out.println(rules);
        JSONObject jsonObjectRuleDataFinall = new JSONObject();
        JSONObject jsonObjectTopnFinall = new JSONObject();
        JSONObject jsonObjectFinall = new JSONObject();
        for (Map rule : rules) {//多个规则
            JSONObject jsonObjectTopN = (JSONObject) rule.get("topN");
            if(null != jsonObjectTopN){
                System.out.println("jsonObjectTopN:"+jsonObjectTopN);
                for (Map.Entry<String, Object> m : jsonObjectTopN.entrySet()) {
                    String key = m.getKey();
                    JSONObject value = (JSONObject)m.getValue();
                    if(null == jsonObjectTopnFinall.get(key)){
                        jsonObjectTopnFinall.put(key,value);
                    } else {
                        //source 处理
                        JSONObject source = (JSONObject)jsonObjectTopnFinall.get(key);
                        JSONArray sourceDataArr = (JSONArray)source.get("data");
                        JSONObject sourceTopNData = (JSONObject)sourceDataArr.get(0);
                        Integer sourceBeginValue =  Integer.valueOf((String)sourceTopNData.get("beginValue"));
                        //target 处理
                        JSONArray targetDataArr = (JSONArray)value.get("data");
                        JSONObject targetTopNData = (JSONObject)targetDataArr.get(0);
                        Integer targetBeginValue =  Integer.valueOf((String)targetTopNData.get("beginValue"));
                        if(targetBeginValue.intValue() < sourceBeginValue.intValue()){
                            sourceDataArr.remove(0);
                            sourceDataArr.add(targetTopNData);
                        }
                    }
                }
                jsonObjectFinall.put("topN",jsonObjectTopnFinall);
            }


            JSONObject jsonObject = (JSONObject) rule.get("ruleData");
            if(null != jsonObject){
                System.out.println("ruleDatajsonObject:"+jsonObject);
                for (Map.Entry<String, Object> m : jsonObject.entrySet()) {
                    String key = m.getKey();
                    JSONObject value = (JSONObject)m.getValue();
                    if(null == jsonObjectRuleDataFinall.get(key)){
                        jsonObjectRuleDataFinall.put(key,value);
                    } else {
                        JSONObject source = (JSONObject)jsonObjectRuleDataFinall.get(key);
                        JSONArray data = (JSONArray)source.get("data");
                        if(null != data){
                            data.addAll((JSONArray)value.get("data")) ;
                        }
                    }
                }
                jsonObjectFinall.put("ruleData",jsonObjectRuleDataFinall);
            }

            System.out.println("deepMerge.res:"+jsonObjectFinall);
        }

        Map<String,Object> m = new HashMap<>();
        m.put("1",null);
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
