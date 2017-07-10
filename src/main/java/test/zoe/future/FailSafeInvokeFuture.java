/*
 * Copyright (c) 2015 The Jupiter Project
 *
 * Licensed under the Apache License, version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package test.zoe.future;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 用于实现fail-safe集群容错方案的 {@link InvokeFuture}.
 *
 * 同步调用时发生异常时只打印日志.
 *
 * jupiter
 * org.jupiter.rpc.consumer.future
 *
 * @see // org.jupiter.rpc.consumer.cluster.FailSafeClusterInvoker
 *
 * @author jiachun.fjc
 */
@SuppressWarnings("unchecked")
public class FailSafeInvokeFuture<V> implements InvokeFuture<V> {

    private  final Logger logger = LoggerFactory.getLogger(getClass());

    private final InvokeFuture<V> future;

    public static <T> FailSafeInvokeFuture<T> with(InvokeFuture<T> future) {
        return new FailSafeInvokeFuture<T>(future);
    }

    private FailSafeInvokeFuture(InvokeFuture<V> future) {
        this.future = future;
    }

    @Override
    public Class<V> returnType() {
        return future.returnType();
    }

    @Override
    public V getResult() throws Throwable {
        try {
            return future.getResult();
        } catch (Throwable t) {
            if (logger.isWarnEnabled()) {
               // logger.warn("Ignored exception on [Fail-safe]: {}.", stackTrace(t));
            }
        }
        //return (V) Reflects.getTypeDefaultValue(returnType());
        return  null;
    }

    @Override
    public InvokeFuture<V> addListener(JListener<V> listener) {
        future.addListener(listener);
        return this;
    }

    @Override
    public InvokeFuture<V> addListeners(JListener<V>... listeners) {
        future.addListeners(listeners);
        return this;
    }

    @Override
    public InvokeFuture<V> removeListener(JListener<V> listener) {
        future.removeListener(listener);
        return this;
    }

    @Override
    public InvokeFuture<V> removeListeners(JListener<V>... listeners) {
        future.removeListeners(listeners);
        return this;
    }

    public InvokeFuture<V> future() {
        return future;
    }
}
