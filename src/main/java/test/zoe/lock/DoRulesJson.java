package test.zoe.lock;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.apache.cxf.common.util.StringUtils;

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
            "                        \"text\": \"哈哈,呵呵\"\n" +
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
            "                        \"beginValue\": \"50\",\n" +
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
            "\n" +
            "            \"item_id\": {\n" +
            "                \"type\": 90,\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"value\": \"item_id默认值\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "\n" +
            "            \"vender_id\": {\n" +
            "                \"type\": 90,\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"value\": \"vender_id默认值\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "\n" +
            "            \"dept_id\": {\n" +
            "                \"type\": 91,\n" +
            "                \"data\": [\n" +
            "                    {\n" +
            "                        \"deptId1\": \"deptId1默认值\",\n" +
            "                        \"deptId2\": \"deptId1默认值\",\n" +
            "                        \"deptId3\": \"deptId1默认值\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "\n" +
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
            "                        \"text\": \"规则二保存的文本信息1,保存的文本信息2\"\n" +
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
        JSONObject o = mergeRules(rules);
        String sqlObj = doWhereSql(o);
        System.out.println("sqlObj:"+sqlObj);
    }

    /**
     * * or ((dept1 == 1 () and (dept2 == 2) and (dept3 == 3))
     * * or ((dept1 == 1 () and (dept2 == 2) and (dept3 == 3))
     * * or ((dept1 == 1 () and (dept2 == 2) and (dept3 == 3))
     *
     * 处理成 in
     * type
     * 2、品牌
     * 3、商家
     * 4、erp
     * 6、平铺多选
     * 9、下拉固定选项
     * */
    public static String doWhereSql(JSONObject o){
        JSONObject ruleData = (JSONObject)o.get("ruleData");
        System.out.println("ruleData:"+ruleData);
        StringBuffer finalStr = new StringBuffer();

        //"1002":{"type":2,"labelName":"品类","data":[{"code":"2002","name":"品牌2"}]}, // and a = 11 or b =11
        //遍历每个标签 每个字段的where
        for(Map.Entry<String, Object> m : ruleData.entrySet()){

            //
            //标签code
            String field = (String)m.getKey();
            JSONObject dataValue = (JSONObject)m.getValue();
            Integer type = (Integer)dataValue.get("type");
            //遍历 data 属性 ，where 最细粒度的元素
            JSONArray dataArray = (JSONArray)dataValue.get("data");
            //处理 1 ,91 (a = 1001 and b = 2001 and c = 3001 ) or (a = 1001 and b = 2001 and c = 3001 ) 格式的sql
            StringBuffer labelStr = new StringBuffer();
            for(int i=0;i<dataArray.size();i++) {
                JSONObject data = dataArray.getJSONObject(i);
                if(type == 1){
                    labelStr.append("( ");
                    String itemFirstCateCd = (String)data.get("itemFirstCateCd");
                    String itemSecondCateCd = (String)data.get("itemSecondCateCd");
                    String itemThirdCateCd = (String)data.get("itemThirdCateCd");
                    if(!StringUtils.isEmpty(itemFirstCateCd)){
                        labelStr.append("item_first_cate_cd").append(" = '").append(itemFirstCateCd).append("' and ");
                    }

                    if(!StringUtils.isEmpty(itemSecondCateCd)){
                        labelStr.append("item_second_cate_cd").append(" = '").append(itemSecondCateCd).append("' and ");
                    }

                    if(!StringUtils.isEmpty(itemThirdCateCd)){
                        labelStr.append("item_third_cate_cd").append(" = '").append(itemThirdCateCd).append("' and ");
                    }
                }

                if(type == 91){
                    labelStr.append(" ( ");
                    String deptId1 = (String)data.get("deptId1");
                    String deptId2 = (String)data.get("deptId2");
                    String deptId3 = (String)data.get("deptId3");
                    if(!StringUtils.isEmpty(deptId1)){
                        labelStr.append("dept_id_1").append(" = '").append(deptId1).append("' and ");
                    }

                    if(!StringUtils.isEmpty(deptId2)){
                        labelStr.append("dept_id_2").append(" = '").append(deptId2).append("' and ");
                    }

                    if(!StringUtils.isEmpty(deptId3)){
                        labelStr.append("dept_id_3").append(" = '").append(deptId3).append("' and ");
                    }
                }

                if(type == 1 || type == 91){
                    if(i != dataArray.size() - 1){
                        labelStr.delete(labelStr.length()-4, labelStr.length());
                        labelStr.append(") or  ");
                    } else {
                        labelStr.delete(labelStr.length()-4, labelStr.length());
                        labelStr.append(") and");
                    }
                }
            }


            //处理where in 条件
            StringBuffer inAllSql = new StringBuffer();
            //type 2,3,4,6,9 处理成in
            if(type == 2 || type == 3 || type == 4 || type == 6 || type == 9){
                StringBuffer inStr = new StringBuffer();

                for(int i=0;i<dataArray.size();i++) {
                    JSONObject data = dataArray.getJSONObject(i);
                    inStr.append(data.get("code")).append(",");
                }
                inStr.delete(inStr.length()-1, inStr.length());
                inAllSql.append(field).append(" in (").append(inStr.toString()).append(") and ");
            }

            //type 5 大于，小于，between
            //处理where in 条件
            StringBuffer betweenAllSql = new StringBuffer();
            if(type == 5){
                //StringBuffer betweenStr = new StringBuffer();
                for(int i=0;i<dataArray.size();i++) {
                    JSONObject data = dataArray.getJSONObject(i);
                    String flag = (String)data.get("flag");
                    if("2".equals(flag)){//小于
                        betweenAllSql.append(field).append(" < ").append(data.get("beginValue")).append(" and ");
                    }
                    if("3".equals(flag)){//大于
                        betweenAllSql.append(field).append(" > ").append(data.get("beginValue")).append(" and ");
                    }
                    if("4".equals(flag)){////范围数字
                        betweenAllSql.append(field).append(" > ").append(data.get("beginValue")).append(" and ")
                        .append(field).append(" < ").append(data.get("endValue")).append(" and ");
                    }
                }
                //betweenStr.delete(betweenStr.length()-4, betweenStr.length());
                //betweenAllSql.append(betweenStr);
            }

            StringBuffer equalAllSql = new StringBuffer();
            if(type == 90 || type == 7){
                //StringBuffer equalStr = new StringBuffer();
                for(int i=0;i<dataArray.size();i++) {
                    JSONObject data = dataArray.getJSONObject(i);
                    String value = (String)data.get(type == 90 ? "value" : "code");
                    equalAllSql.append(field).append(" = ").append(value).append(" and ");
                    //equalAllSql.append(equalStr.toString());
                }
                //equalStr.delete(betweenStr.length()-4, betweenStr.length());

            }



            StringBuffer likeAllSql = new StringBuffer();
            if(type == 8){
                //StringBuffer likeStr = new StringBuffer();
                for(int i=0;i<dataArray.size();i++) {
                    JSONObject data = dataArray.getJSONObject(i);
                    String texts = (String)data.get("text");
                    String[] textArr = texts.split(",");
                    for(int j = 0; j < textArr.length;j++){
                        likeAllSql.append(field).append(" like '%").append(textArr[j]).append("%' or ");
                    }
                    if(i == (dataArray.size() - 1)){
                        likeAllSql.delete(likeAllSql.length()-5, likeAllSql.length());
                        likeAllSql.append("' and ");
                    }
                    //likeAllSql.append(likeStr.toString());
                }
                //likeAllSql.delete(likeAllSql.length()-4, likeAllSql.length());
            }


            //各个标签之间用and 链接,每种处理的where sql后面都是有 and 字符串，在最终的sql 去掉结尾的and字符串即可
            finalStr.append(labelStr.toString());//部门和分类种类的sql
            finalStr.append(inAllSql.toString());//in 种类的sql
            finalStr.append(betweenAllSql.toString());//范围类的sql
            finalStr.append(equalAllSql.toString());//等于类的sql
            finalStr.append(likeAllSql.toString());//like类的sql


        }////遍历每个标签 每个字段的where for结束
        finalStr.delete(finalStr.length()-4, finalStr.length());
        return finalStr.toString();
    }

    public static JSONObject mergeRules(List<Map> rules){
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
        return jsonObjectFinall;
    }


}
