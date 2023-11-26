package tests;

import steps.DemoTestSteps;

public class DemoTestFlow {
    DemoTestSteps demoTestSteps;
    DemoTestFlow(){
        demoTestSteps = new DemoTestSteps();
    }
    public DemoTestFlow given() {return this;}
    public DemoTestFlow when() {return this;}
    public DemoTestFlow then() {return this;}
    public void end() {}

    public DemoTestFlow demoTest_preparePayload(){
        demoTestSteps.preparePayload();
        return this;
    }

    public DemoTestFlow demoTest_executeRequest(){
        demoTestSteps.executeRequest();
        return this;
    }

    public DemoTestFlow demoTest_verify200Status(){
        demoTestSteps.validate200Status();
        return this;
    }

    public DemoTestFlow demoTest_verifySchema(){
        demoTestSteps.validateSchema();
        return this;
    }

    public DemoTestFlow demoTest_verifyResponse(){
        demoTestSteps.validateResponse();
        return this;
    }

    public DemoTestFlow demoTest_verifyDatabase(){
        demoTestSteps.validateDatabase();
        return this;
    }
}
