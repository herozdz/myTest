package test.zoe.xmlRes.entity;

import java.util.List;

/**
 * 流程整合
 * Created by Witcher on 16-11-25.
 */
public class FlowWorker {

    private List<FlowDefain> flows;

    public List<FlowDefain> getFlows() {
        return flows;
    }

    public void setFlows(List<FlowDefain> flows) {
        this.flows = flows;
    }

    @Override
    public String toString() {
        return "{\"FlowWorker\":{"
                + "\"flows\":" + flows
                + "}}";
    }
}
