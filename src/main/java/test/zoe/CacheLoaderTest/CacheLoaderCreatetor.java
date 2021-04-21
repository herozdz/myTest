package test.zoe.CacheLoaderTest;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class CacheLoaderCreatetor {
    public static com.google.common.cache.CacheLoader<String, Employee> createCacheLoader() {
        return new com.google.common.cache.CacheLoader<String, Employee>() {
            @Override
            public Employee load(String key) throws Exception {
                log.info("加载创建key:" + key);
                return new Employee(key, key + "dept", key + "id");
            }
        };
    }

    public static com.google.common.cache.CacheLoader<String, Employee> createNUllCacheLoader() {
        return new com.google.common.cache.CacheLoader<String, Employee>() {
            @Override
            public Employee load(String key) throws Exception {
                log.info("加载创建key:" + key);
                if (key.equals("null")) {
                    return null;
                }
                return new Employee(key, key + "dept", key + "id");
            }
        };
    }

    public static com.google.common.cache.CacheLoader<String, Optional<Employee>> createNullValueUseOptionalCacheLoader() {
        return new com.google.common.cache.CacheLoader<String, Optional<Employee>>() {
            @Override
            public Optional<Employee> load(String key) throws Exception {
                log.info("加载创建key:" + key);
                if (key.equals("null")) {
                    return Optional.ofNullable(null);
                } else {
                    return Optional.ofNullable( new Employee(key, key + "dept", key + "id"));
                }
            }


        };
    }
}