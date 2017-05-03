package test.zoe.xmlRes.workflow;


import java.util.Date;

/**
 * 审批流程表
 * Created by Witcher on 16-12-1.
 */
public abstract class FlowProcess extends IdEntity{

    /**
     * 流程唯一标示
     */
    private String flowSign;

    /**
     * 执行角色
     */
    private String execRole;

    /**
     * 执行节点编号
     */
    private String execNode;

    /**
     * 执行节点名称
     */
    private String execNodeName;

    /**
     * 执行命令编号
     */
    private String execCommond;

    /**
     * 审批意见
     */
    private String opinion;

    /**
     * 执行时间
     */
    private Date execTime;

    protected FlowProcess() {
    }

    protected FlowProcess(String flowSign,String execRole, String execNode, String execNodeName, String execCommond, String opinion) {
        this.flowSign = flowSign;
        this.execRole = execRole;
        this.execNode = execNode;
        this.execNodeName = execNodeName;
        this.execCommond = execCommond;
        this.opinion = opinion;
    }



    public String getFlowSign() {
        return flowSign;
    }

    public void setFlowSign(String flowSign) {
        this.flowSign = flowSign;
    }

    public String getExecNode() {
        return execNode;
    }

    public void setExecNode(String execNode) {
        this.execNode = execNode;
    }

    public String getExecCommond() {
        return execCommond;
    }

    public void setExecCommond(String execCommond) {
        this.execCommond = execCommond;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Date getExecTime() {
        return execTime;
    }

    public void setExecTime(Date execTime) {
        this.execTime = execTime;
    }

    public String getExecRole() {
        return execRole;
    }

    public void setExecRole(String execRole) {
        this.execRole = execRole;
    }

    public String getExecNodeName() {
        return execNodeName;
    }

    public void setExecNodeName(String execNodeName) {
        this.execNodeName = execNodeName;
    }

    public abstract static class Builder{
        protected String flowSign;
        protected String execRole;
        protected String execNode;
        protected String execNodeName;
        protected String execCommond;
        protected String opinion;
        protected Date execTime;

        public Builder setFlowSign(String flowSign) {
            this.flowSign = flowSign;
            return this;
        }

        public Builder setExecRole(String execRole) {
            this.execRole = execRole;
            return this;
        }

        public Builder setExecNode(String execNode) {
            this.execNode = execNode;
            return this;
        }

        public Builder setExecNodeName(String execNodeName) {
            this.execNodeName = execNodeName;
            return this;
        }

        public Builder setExecCommond(String execCommond) {
            this.execCommond = execCommond;
            return this;
        }

        public Builder setOpinion(String opinion) {
            this.opinion = opinion;
            return this;
        }

        public Builder setExecTime(Date execTime) {
            this.execTime = execTime;
            return this;
        }
    }
}
