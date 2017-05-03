package test.zoe.xmlRes.entity;

/**
 * 节点命令
 * Created by Witcher on 16-11-28.
 */
public class FlowCommond {

    /**
     * 执行命令
     */
    private String code;
    /**
     * 执行器
     */
    private String executor;

    /**
     * 执行后状态
     */
    private String flowState;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getFlowState() {
        return flowState;
    }

    public void setFlowState(String flowState) {
        this.flowState = flowState;
    }


    @Override
    public String toString() {
        return "{\"FlowCommond\":{"
                + "\"code\":\"" + code + "\""
                + ", \"executor\":\"" + executor + "\""
                + ", \"flowState\":\"" + flowState + "\""
                + "}}";
    }
}
