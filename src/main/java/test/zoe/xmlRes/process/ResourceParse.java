package test.zoe.xmlRes.process;



import test.zoe.xmlRes.entity.FlowCommond;
import test.zoe.xmlRes.entity.FlowDefain;
import test.zoe.xmlRes.entity.FlowNode;
import test.zoe.xmlRes.entity.FlowStart;

import java.util.List;

/**
 * 配置解析接口
 * Created by lifengwei on 16-2-3.
 */
public interface ResourceParse {

    /**
     * 找出流程定义
     * @param flowId
     * @return
     */
    public FlowDefain getFlowDefain(String flowId);

    /**
     * 找出流程起始节点
     *
     * @param flowId
     * @return
     */
    public FlowStart getFlowStart(String flowId);


    /**
     * 找出流程下的所有节点
     *
     * @param flowId
     * @return
     */
    public List<FlowNode> getFlowNode(String flowId);

    /**
     * 根据id查询流程节点
     * @param nodeId
     * @return
     */
    public FlowNode getFlowNode(String flowId, String nodeId);

    /**
     * 根据role查询所有节点
     * @param roleId
     * @return
     */
    public List<FlowNode> findFlowNodeByRoleId(String roleId);


    /**
     * 查找下一个流程节点
     * @param flowId
     * @param nodeId
     * @return
     */
    public FlowNode  getNextFlowNode(String flowId, String nodeId);

    /**
     * 获得某个节点下的执行命令
     * @param flowId
     * @param nodeId
     * @param commond
     * @return
     */
    public FlowCommond getFlowCommond(String flowId, String nodeId, String commond);

}
