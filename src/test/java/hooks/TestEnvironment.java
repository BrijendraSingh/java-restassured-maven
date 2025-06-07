package hooks;

import utils.ConfigLoader;

public class TestEnvironment {
    public static String set(){
        String env = System.getProperty("env", System.getenv("TEST_ENV")!=null ? System.getenv("TEST_ENV"): "local");
        ConfigLoader.loadConfig(env);
        System.out.println("[" + env +"] environment is loaded");
        return env;
    }
}
