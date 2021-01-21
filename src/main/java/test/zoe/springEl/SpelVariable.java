
package test.zoe.springEl;
/**
 * 这个类不能公开，目的就是为了规范使用， 将这个类的使用限制到当前package 下
 *
 * @author : qiujianping
 * @date: 18-3-22
 * Time: 下午5:21
 */
enum SpelVariable {

    /**
     * 美元符号
     **/
    PARAM_VAR("$", "内置变量默认字符"),
    /**
     * 属性变量名称
     **/
    FIELD_VAR("value", "返回list结果集合中的一列字段的值"),
    /**
     * 集合变量名称
     **/
    ITEM_VAR("item", "返回list结果集合中一行元素"),
    /**
     * 返回对象变量名称
     **/
    RESULT_VAR("result", "返回的结果对象");

    private String var, varDesc;


    SpelVariable(String var, String varDesc) {
        this.var = var;
        this.varDesc = varDesc;
    }

    public String getVar() {
        return var;
    }

    public String getVarDesc() {
        return varDesc;
    }
}
