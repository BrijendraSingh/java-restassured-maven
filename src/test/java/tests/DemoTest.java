package tests;

import hooks.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoTest extends BaseTest {
    DemoTestFlow user;

    @BeforeClass
    public void testSetup(){
        user = new DemoTestFlow();
    }

    @Test
    public void testOne(){
        user
                .given()
                    .demoTest_preparePayload()
                .when()
                    .demoTest_executeRequest()
                    .demoTest_verify200Status()
                .then()
                    .demoTest_verifySchema()
                    .demoTest_verifyResponse()
                    .demoTest_verifyDatabase()
                .end();
    }
}
