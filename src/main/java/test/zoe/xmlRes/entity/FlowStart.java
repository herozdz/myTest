package test.zoe.xmlRes.entity;

/**
 * 流程启动器
 * Created by Witcher on 16-11-25.
 */
public class FlowStart {

    /**
     * 节点id
     */
    private String id;

    /**
     * 启动执行器
     */
    private String executor;

    /**
     * 执行后状态
     */
    private String flowState;

    public FlowStart() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "{\"FlowStart\":{"
                + "\"id\":\"" + id + "\""
                + ", \"executor\":\"" + executor + "\""
                + ", \"flowState\":\"" + flowState + "\""
                + "}}";
    }
}
