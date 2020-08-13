package test.zoe.springEl;
import com.alibaba.fastjson.JSON;
import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * spring el 工具类，所有和el解析相关的包括设置变量部分都放到这里面,后续方便维护代码
 *
 * @author liutao19
 * @date 2018/1/10.
 * Spring EL表达式工具类
 */
public class SpringElUtils {

    /**
     * 表达式执行引擎
     *
     * @param expression
     * @param rootValue
     * @param vars
     * @return
     */
    private static Object parse(String expression, Object rootValue, Map<String, Object> vars) {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.addPropertyAccessor(new MapAccessor());
        if (vars != null && !vars.isEmpty()) {
            context.setVariables(vars);
        }
        Expression exp = parser.parseExpression(expression);
        return exp.getValue(context, rootValue);
    }

    public static Object parse(String expression, Object rootValue) {
        return parse(expression, rootValue, null);
    }

    /**
     * 只能只用变量 result.
     * 执行 结果集合字段表达式
     *
     * @param expression
     * @param jsfResult
     * @return
     */
    public static Object evalResultListExpression(String expression, Object jsfResult) {
        Map<String, Object> resultMap = new HashMap<>();
        //二选一，不能都设置，不然 map里面如果有个字段是 result 就歇菜了
        if (jsfResult instanceof Map) {
            resultMap.putAll((Map) jsfResult);
        } else {
            //这个主要是设置 接口返回值是JSON格式的
            resultMap.put(SpelVariable.RESULT_VAR.getVar(), jsfResult);
        }
        return parse(expression, resultMap);
    }

    /**
     * 只能只用变量 result.
     * 执行 结果集合字段表达式
     *
     * @param expression
     * @param replaceValues
     * @return
     */
    public static Object evalFileNameRuleExpression(String expression, Object[] replaceValues) {
        if (replaceValues == null) {
            return null;
        }
        Map<String, Object> elMap = new HashMap<>(replaceValues.length);
        if (replaceValues != null) {
            for (int i = 0; i < replaceValues.length; i++) {
                elMap.put(SpelVariable.PARAM_VAR.getVar().concat(String.valueOf(i)), replaceValues[i]);
            }
        }
        return parse(expression, elMap);
    }

    /**
     * 解析数据源 表达式
     *
     * @param replaceValues      数据源表达式
     * @param record             上一个数据源返回的 list中的一条
     * @param clientReqInfoParam 客户端请求的参数
     * @param parentDsResult     上一个数据源返回的结果
     * @return
     */
    public static Object evalDataSourceReqExpression(Object[] replaceValues, Object record, Object[] clientReqInfoParam, Object parentDsResult) {
        Map<String, Object> elContext = new HashMap<>();
        //设置父级数据源请求参数变量
        if (record != null) {
            elContext.put(SpelVariable.ITEM_VAR.getVar(), record);
        }
        //父级数据员返回的结果
        if (parentDsResult != null) {
            elContext.put(SpelVariable.RESULT_VAR.getVar(), parentDsResult);
        }

        //设置客户端请求参数变量
        if (clientReqInfoParam != null) {
            for (int i = 0; i < clientReqInfoParam.length; i++) {
                elContext.put(SpelVariable.PARAM_VAR.getVar().concat(String.valueOf(i)), clientReqInfoParam[i]);
            }
        }

        //设置客户端请求参数变量
        for (int i = 0; i < replaceValues.length; i++) {
            Object value = replaceValues[i];
            if (value instanceof Map) {//如果是对象
                Map<String, Object> valueMap = (Map) value;
                //将表达式解析成 对象，支持无限极嵌套设置值
                valueMap.keySet().stream().forEach(key -> {
                    Object elVal = parse((String) valueMap.get(key), elContext);
                    setDeepMapValue(valueMap, key, elVal);
                });
            } else if (value instanceof String) {//如果是字符串
                replaceValues[i] = parse((String) value, elContext);
            } else {
                throw new RuntimeException("不支持的数据源层级表达式配置:" + JSON.toJSONString(replaceValues));
            }
        }
        return replaceValues;
    }

    /**
     * 分页参数设置 el
     *
     * @param expression
     * @param replaceValues
     * @param value
     * @return
     */
    public static Object evalPageExpression(String expression, Object[] replaceValues, Integer value) {

        String simpleEl = expression;
        if (!StringUtils.hasLength(simpleEl)) {
            return null;
        }
        if (!simpleEl.startsWith(SpelVariable.PARAM_VAR.getVar())) {
            simpleEl = "$0.".concat(simpleEl);
        }
        try {
            //第一个点的位置
            int firstDot = simpleEl.indexOf(".");

            //客户端直接传的 $0这样的表达式
            if (firstDot == -1) {
                //表达式传的是 $0 $1 $2 这样的格式
                int index = Integer.parseInt(simpleEl.replaceAll("\\D", ""));
                replaceValues[index] = value;
                return replaceValues;
            }

            String positionStr = simpleEl.substring(0, firstDot);
            String keyStr = simpleEl.substring(firstDot + 1);

            //获取表达式在数组中的位置
            int index = Integer.parseInt(positionStr.replaceAll("\\D", ""));

            if (index >= replaceValues.length) {
                throw new RuntimeException("分页参数下标设置超过参数个数");
            }
            //剩下的就是对象格式的{a:xx.b:aa}
            if (!(replaceValues[index] instanceof Map)) {
                throw new RuntimeException("分页参数设置错误,分页表达式:" + expression);
            }
            Map<String, Object> param = (Map<String, Object>) replaceValues[index];
            setDeepMapValue(param, keyStr, value);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return replaceValues;
    }

    /**
     * 单元格数据值转换
     *
     * @param jsfResult   jsf 返回的元素数据
     * @param rowMap      当前一行数据
     * @param pValue      当前值
     * @param pExpression 表达式的值
     * @return
     */
    public static Object evalCellExpression(Object jsfResult, Map rowMap, Object pValue, String pExpression) {

        if (!StringUtils.hasText(pExpression)) {//没有表达式
            return pValue;
        }
        Map<String, Object> map = new HashMap();

        //用到 $result 结果表达式但是用到
        map.put(SpelVariable.RESULT_VAR.getVar(), jsfResult);
        //当前list item
        map.put(SpelVariable.ITEM_VAR.getVar(), rowMap);
        //表达式中包含value字段
        map.put(SpelVariable.FIELD_VAR.getVar(), pValue);
        return parse(pExpression, map);
    }

    /**
     * 深度设置复杂表达式的值
     * eg:  deepKey="a.b.c.d.e" value="abc"
     * 结果: {"a":{"b":{"c":{"d":{"e":"abc"}}}}}
     *
     * @param replaceMap
     * @param deepKey    要设置的key
     * @param value      要设置的值
     */
    private static Map setDeepMapValue(Map replaceMap, String deepKey, Object value) {
        String[] keys = deepKey.split("\\.");
        Map currentMap = replaceMap;
        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            Object valueLink = currentMap.get(key);
            if (valueLink == null && i != keys.length - 1) {
                currentMap.put(key, currentMap = new HashMap<>());
            }
            //最后一次循环
            if (i == keys.length - 1) {
                currentMap.put(key, value);
            }
        }
        return replaceMap;
    }
}
