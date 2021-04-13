package test.zoe.threadLocalTest;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.ttl.TransmittableThreadLocal;

public class MyTransmittableThreadLocal<T> extends TransmittableThreadLocal<T> {
    /**
     * 重点看最后一条输出日志，age=3，子线程改了threadlocal的值后，主线程的也改变了。这是因为默认情况下是值传递，这里是Stu对象，值传递实际传递的是引用的拷贝。
     * 如果不想值传递怎么办呢？很简单，跟InheritableThreadLocal一样，重写TransmittableThreadLocal的copy方法即可
     * */
    public T copy(T parentValue) {
        String s = JSONObject.toJSONString(parentValue);
        return (T)JSONObject.parseObject(s,parentValue.getClass());
    }
}