package test.zoe.xmlRes.process;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.XStream;
import org.apache.cxf.helpers.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import test.zoe.xmlRes.entity.*;

import java.util.List;

/**
 * xml流程文件解析器
 * Created by lifengwei on 16-2-3.
 */
public class XMLResourceParse implements ResourceParse {

    private FlowWorker flowWorker;

    public FlowWorker getFlowWorker() {
        return flowWorker;
    }

    public void setFlowWorker(FlowWorker flowWorker) {
        this.flowWorker = flowWorker;
    }

    public XMLResourceParse(Resource path) throws Exception {
        this.flowWorker = parseResource(path);
    }


    public FlowWorker parseResource(Resource path) throws Exception {
        XStream xStream = new XStream();
        xStream.alias("flows", FlowWorker.class);

        xStream.alias("flow", FlowDefain.class);
        xStream.useAttributeFor(FlowDefain.class, "id");


        xStream.alias("start", FlowStart.class);
        xStream.useAttributeFor(FlowStart.class, "id");
        xStream.useAttributeFor(FlowStart.class, "executor");
        xStream.useAttributeFor(FlowStart.class, "flowState");

        xStream.alias("node", FlowNode.class);
        xStream.useAttributeFor(FlowNode.class, "id");
        xStream.useAttributeFor(FlowNode.class, "role");
        xStream.useAttributeFor(FlowNode.class,"name");

        xStream.alias("commond", FlowCommond.class);
        xStream.useAttributeFor(FlowCommond.class, "code");
        xStream.useAttributeFor(FlowCommond.class, "executor");
        xStream.useAttributeFor(FlowCommond.class, "flowState");

        xStream.addImplicitCollection(FlowWorker.class, "flows");
        xStream.addImplicitCollection(FlowDefain.class, "nodes");
        xStream.addImplicitCollection(FlowNode.class, "commonds");

        String xml = IOUtils.toString(path.getInputStream());
        FlowWorker flowWorker = (FlowWorker) xStream.fromXML(xml);
        return flowWorker;
    }


    public FlowDefain getFlowDefain(String flowId) {
        for (FlowDefain def : getFlowWorker().getFlows()) {
            if (def.getId().equals(flowId))
                return def;
        }
        return null;
    }

    public FlowStart getFlowStart(String flowId) {
        for (FlowDefain def : getFlowWorker().getFlows()) {
            if (def.getId().equals(flowId))
                return def.getStart();
        }
        return null;
    }


    public List<FlowNode> getFlowNode(String flowId) {
        for (FlowDefain def : getFlowWorker().getFlows()) {
            if (def.getId().equals(flowId))
                return def.getNodes();
        }
        return null;
    }

    public FlowNode getFlowNode(String flowId,String id) {
        for (FlowDefain def : getFlowWorker().getFlows()) {
            if (def.getId().equals(flowId)){
                for(FlowNode node:def.getNodes()){
                    if(node.getId().equals(id))
                        return node;
                }
            }
        }
        return null;
    }

    public List<FlowNode> findFlowNodeByRoleId(String roleId) {
        List<FlowNode> nodes = Lists.newArrayList();
        for (FlowDefain def : getFlowWorker().getFlows()) {
            for(FlowNode node:def.getNodes()){
                if(node.getRole().equals(roleId))
                    nodes.add(node);
            }
        }
        return nodes;
    }

    public FlowNode getNextFlowNode(String flowId, String id) {
        List<FlowNode> nodes = Lists.newArrayList();
        for (FlowDefain def : getFlowWorker().getFlows()) {
            if (def.getId().equals(flowId)){
                nodes = def.getNodes();
            }
        }

        Assert.notEmpty(nodes,"流程节点为空!");

//        FlowStart flowStart  =  getFlowStart(flowId);
//        if(flowStart.getId().equals(id))
//            return nodes.get(0);

        int index = 0;
        for(FlowNode node:nodes){
            if(node.getId().equals(id)){
                if((index + 1) < nodes.size())
                     return nodes.get(index + 1);
                else
                     return node;
            }
            index++;
        }

        return null;
    }

    public FlowCommond getFlowCommond(String flowId, String nodeId, String commond) {
        FlowNode flowNode = getFlowNode(flowId,nodeId);
        for(FlowCommond comm: flowNode.getCommonds()){
            if(comm.getCode().equals(commond))
                return comm;
        }
        return null;
    }
}
