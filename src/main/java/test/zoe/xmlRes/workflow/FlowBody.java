package test.zoe.xmlRes.workflow;

/**
 * 流程body
 * Created by Witcher on 16-11-30.
 */
public abstract class FlowBody {

    /**
     *  流程id
     */
    private String flowId;

    /**
     * 流程标识
     */
    private String flowSign;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getFlowSign() {
        return flowSign;
    }

    public void setFlowSign(String flowSign) {
        this.flowSign = flowSign;
    }

    @Override
    public String toString() {
        return "{\"FlowBody\":{"
                + "\"flowId\":\"" + flowId + "\""
                + ", \"flowSign\":\"" + flowSign + "\""
                + "}}";
    }
}
