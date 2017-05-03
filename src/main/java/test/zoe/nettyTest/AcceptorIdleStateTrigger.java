package test.zoe.nettyTest;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/5/3
 * Time: 17:25
 * To change this template use File | Settings | File Templates.
 * 单独写一个AcceptorIdleStateTrigger，其实也是继承ChannelInboundHandlerAdapter，
 * 重写userEventTriggered方法，
 * 因为客户端是write，那么服务端自然是read，设置的状态就是IdleState.READER_IDLE，源码如下
 * */
@ChannelHandler.Sharable
public class AcceptorIdleStateTrigger extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleState state = ((IdleStateEvent) evt).state();
            if (state == IdleState.READER_IDLE) {
                throw new Exception("idle exception");
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }
}