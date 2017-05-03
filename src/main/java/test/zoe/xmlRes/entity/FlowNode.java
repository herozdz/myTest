package test.zoe.xmlRes.entity;

import java.util.List;

/**
 * 流程节点
 * Created by Witcher on 16-11-25.
 */
public class FlowNode {

    /**
     * 流程节点id
     */
    private String id;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 流程节点名称
     */
    private String role;

    /**
     * 节点命令
     */
    private List<FlowCommond> commonds;

    public FlowNode() {
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<FlowCommond> getCommonds() {
        return commonds;
    }

    public void setCommonds(List<FlowCommond> commonds) {
        this.commonds = commonds;
    }

    @Override
    public String toString() {
        return "{\"FlowNode\":{"
                + "\"id\":\"" + id + "\""
                + ", \"name\":\"" + name + "\""
                + ", \"role\":\"" + role + "\""
                + ", \"commonds\":" + commonds
                + "}}";
    }
}
