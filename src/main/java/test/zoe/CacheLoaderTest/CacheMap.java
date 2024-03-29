package test.zoe.CacheLoaderTest;

import com.google.common.cache.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * descrption:
 * authohr: wangji
 * date: 2018-02-05 19:55
 */
public class CacheMap {
    private static final Logger log = LoggerFactory.getLogger(CacheMap.class);

    /**
     * @desction: 使用google guava缓存处理
     * @author: wangji
     * @date: 2017/11/22 9:59
     */
    private static Cache<String,Object> cache;
    static {
        /*cache = CacheBuilder.newBuilder().maximumSize(10000)
                .expireAfterWrite(24, TimeUnit.HOURS)
                .initialCapacity(10)
                .removalListener(new RemovalListener<String, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, Object> rn) {
                        if(log.isInfoEnabled()){
                            log.info("被移除缓存{}:{}",rn.getKey(),rn.getValue());
                        }
                    }
                }).build();*/
        cache = CacheBuilder.newBuilder().maximumSize(3)
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .initialCapacity(2)
                .removalListener(new RemovalListener<String, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, Object> rn) {
                        if(log.isInfoEnabled()){
                            log.info("被移除缓存{}:{}",rn.getKey(),rn.getValue());
                        }
                    }
                }).build(new CacheLoader<String, Object>() {
                    @Override
                    public Employee load(String key) throws Exception {
                        log.info("加载创建key:" + key);
                        return new Employee(key, key + "dept", key + "id");
                    }
                });
    }

    /**
     * @desction: 获取缓存
     * @author: wangji
     * @date: 2017/11/22 9:50
     */
    public  static Object get(String key){
        return StringUtils.isNotEmpty(key)?cache.getIfPresent(key):null;
    }
    /**
     * @desction: 放入缓存
     * @author: wangji
     * @date: 2017/11/22 9:50
     */
    public static void put(String key,Object value){
        if(StringUtils.isNotEmpty(key) && value !=null){
            cache.put(key,value);
        }
    }
    /**
     * @desction: 移除缓存
     * @author: wangji
     * @date: 2017/11/22 9:50
     */
    public static void remove(String key){
        if(StringUtils.isNotEmpty(key)){
            cache.invalidate(key);
        }
    }
    /**
     * @desction: 批量删除缓存
     * @author: wangji
     * @date: 2017/11/22 9:49
     */
    public static void remove(List<String> keys){
        if(keys !=null && keys.size() >0){
            cache.invalidateAll(keys);
        }
    }
}
