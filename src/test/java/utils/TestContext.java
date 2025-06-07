package utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestContext {
    private static TestContext testContext;
    private final Map<TestDataKey, Object> dataStore;

    public TestContext() {
        this.dataStore = new ConcurrentHashMap<>();
    }

    public static synchronized TestContext getTestContext() {
        if (testContext == null) {
            testContext = new TestContext();
        }
        return testContext;
    }

    public void put(TestDataKey key, Object object) {
        dataStore.put(key, object);
    }

    public Object get(TestDataKey key){
        return dataStore.get(key);
    }

    public <T> T get(TestDataKey key, Class<T> type){
        return type.cast(dataStore.get(key));
    }

    public void clear(){
        dataStore.clear();
    }
}
