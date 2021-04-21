package test.zoe.CacheLoaderTest;

import com.google.common.cache.*;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import test.zoe.completableFutureTest.CompletableFutureTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class MyCacheTest {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(MyCacheTest.class);
    private static final HashMap<String, Employee> emap;
    static {
        emap  = new HashMap<>();
        emap.put("11",new Employee("Employee1","dept1" ,"11" ));
        emap.put("22",new Employee("Employee2","dept2" ,"22" ));
        emap.put("33",new Employee("Employee3","dept3" ,"33" ));
        emap.put("44",new Employee("Employee4","dept4" ,"44" ));
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String eId = "11";
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<3;i++){
                    try {
                        doSth(eId);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread.sleep(2000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<3;i++){
                    try {
                        doSth(eId);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    public static void doSth(String eId) throws ExecutionException, InterruptedException {
        CompletableFuture<Employee> eF = (CompletableFuture<Employee> )CacheMap.get(eId);
        if(null != eF){
            //命中缓存
            System.out.println("命中缓存：Employee.1--->:" + eF.get());
            return;
        }
        CompletableFuture<Employee> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("CompletableFuture.supplyAsync 从redis取数:");
                Employee employee = getEmplyee(eId);
                System.out.println("CompletableFuture.supplyAsync 从redis取数:employee:"+employee);
                return employee;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });
        boolean isComplete = false;
        /*System.out.println("从redis取数:");
        Employee employee = getEmplyee(eId);
        System.out.println("从redis取数:employee:"+employee);
        isComplete = future.complete(employee);*/
        System.out.println("Employee.isComplete--->:" + isComplete);
        System.out.println("未命中缓存，写缓存：Employee.2--->:" + future.get());
        CacheMap.put(eId,future);
        System.out.println("Employee.3--->:" + future.get());
    }

    public static Employee getEmplyee(String id) throws InterruptedException {
        Thread.sleep(1000);
        return emap.get(id);
    }

}
