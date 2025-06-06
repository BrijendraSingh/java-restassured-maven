package hooks;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import setup.RestAssuredSetup;

public class BaseTest extends RestAssuredSetup {

    @BeforeSuite
    public void frameworkSetup(){
        TestEnvironment.set();
        restSetup(Auth.OAUTH2);
    }

    @AfterSuite
    public void frameworkTearDown(){}
}
