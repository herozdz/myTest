package test.zoe.xmlRes.entity;

import java.util.List;

/**
 * 流程定义
 * Created by Witcher on 16-11-25.
 */
public class FlowDefain {

    /**
     * 流程定义id
     */
    private String id;

    /**
     * 流程名称
     */
    private String name;

    /**
     * 流程开始节点
     */
    private FlowStart start;

    /**
     * 流程解析节点
     */
    private List<FlowNode> nodes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FlowStart getStart() {
        return start;
    }

    public void setStart(FlowStart start) {
        this.start = start;
    }

    public List<FlowNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<FlowNode> nodes) {
        this.nodes = nodes;
    }
}
