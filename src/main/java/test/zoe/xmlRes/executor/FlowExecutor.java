package test.zoe.xmlRes.executor;


import test.zoe.xmlRes.entity.FlowCommond;
import test.zoe.xmlRes.workflow.FlowEntity;

import java.util.Map;

/**
 * 流程执行器定义
 * Created by Witcher on 16-11-29.
 */
public interface FlowExecutor<T extends FlowEntity> {

    public String exec(T flowEntity, FlowCommond flowCommond, Map<String, Object> params);

}
