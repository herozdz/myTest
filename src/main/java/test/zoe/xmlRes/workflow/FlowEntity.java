package test.zoe.xmlRes.workflow;


import java.util.Date;
import java.util.List;

/**
 * Created by Witcher on 16-11-29.
 */
public abstract class FlowEntity<T extends  FlowBody> extends IdEntity {
    /**
     * 流程id
     */
    private String flowId;

    /**
     * 流程唯一标识
     */
    private String flowSign;

    /**
     * 上一个审核节点
     */
    private String prevNode;

    /**
     * 下一个审核节点
     */
    private String nextNode;

    /**
     * 流程状态
     */
    private String flowState;

    /**
     * 流程开始时间
     */
    private Date flowStartTime;

    /**
     * 流程结束时间
     */
    private Date flowUpdateTime;

    /**
     * 流程实体
     */
    private T flowBody;

    /**
     *  批次使用
     */
    private List<String> flowSigns;

    protected FlowEntity() {
    }

    protected FlowEntity(String flowId, String flowSign, String prevNode, String nextNode,String flowState) {
        this.flowId = flowId;
        this.flowSign = flowSign;
        this.prevNode = prevNode;
        this.nextNode = nextNode;
        this.flowState = flowState;
    }

    protected FlowEntity(String flowSign, String prevNode, String nextNode,String flowState) {
        this.flowSign = flowSign;
        this.prevNode = prevNode;
        this.nextNode = nextNode;
        this.flowState = flowState;
    }

    protected FlowEntity(List<String> flowSigns) {
        this.flowSigns = flowSigns;
    }

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

    public String getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(String prevNode) {
        this.prevNode = prevNode;
    }

    public String getNextNode() {
        return nextNode;
    }

    public void setNextNode(String nextNode) {
        this.nextNode = nextNode;
    }

    public Date getFlowStartTime() {
        return flowStartTime;
    }

    public void setFlowStartTime(Date flowStartTime) {
        this.flowStartTime = flowStartTime;
    }

    public Date getFlowUpdateTime() {
        return flowUpdateTime;
    }

    public void setFlowUpdateTime(Date flowUpdateTime) {
        this.flowUpdateTime = flowUpdateTime;
    }

    public List<String> getFlowSigns() {
        return flowSigns;
    }

    public void setFlowSigns(List<String> flowSigns) {
        this.flowSigns = flowSigns;
    }

    public T getFlowBody() {
        return flowBody;
    }

    public void setFlowBody(T flowBody) {
        this.flowBody = flowBody;
    }

    public String getFlowState() {
        return flowState;
    }

    public void setFlowState(String flowState) {
        this.flowState = flowState;
    }

    public static class Builder{
        protected String flowId;
        protected String flowSign;
        protected String prevNode;
        protected String nextNode;
        protected String flowState;

        public Builder setFlowId(String flowId) {
            this.flowId = flowId;
            return this;
        }

        public Builder setFlowSign(String flowSign) {
            this.flowSign = flowSign;
            return this;
        }

        public Builder setPrevNode(String prevNode) {
            this.prevNode = prevNode;
            return this;
        }

        public Builder setNextNode(String nextNode) {
            this.nextNode = nextNode;
            return this;
        }

        public Builder setFlowState(String flowState) {
            this.flowState = flowState;
            return this;
        }
    }

    public static class ParamBuilder{
        protected String flowSign;
        protected String prevNode;
        protected String nextNode;
        protected String flowState;

        public ParamBuilder setFlowSign(String flowSign) {
            this.flowSign = flowSign;
            return this;
        }

        public ParamBuilder setPrevNode(String prevNode) {
            this.prevNode = prevNode;
            return this;
        }

        public ParamBuilder setNextNode(String nextNode) {
            this.nextNode = nextNode;
            return this;
        }

        public ParamBuilder setFlowState(String flowState) {
            this.flowState = flowState;
            return this;
        }
    }

    public static class BatchBuilder{
        protected  List<String> flowSigns;

        public BatchBuilder setFlowSigns(List<String> flowSigns) {
            this.flowSigns = flowSigns;
            return this;
        }
    }

    @Override
    public String toString() {
        return "{\"FlowEntity\":"
                + super.toString()
                + ", \"flowId\":\"" + flowId + "\""
                + ", \"flowSign\":\"" + flowSign + "\""
                + ", \"prevNode\":\"" + prevNode + "\""
                + ", \"nextNode\":\"" + nextNode + "\""
                + ", \"flowState\":\"" + flowState + "\""
                + ", \"flowStartTime\":" + flowStartTime
                + ", \"flowUpdateTime\":" + flowUpdateTime
                + ", \"flowBody\":" + flowBody
                + ", \"flowSigns\":" + flowSigns
                + "}";
    }
}
