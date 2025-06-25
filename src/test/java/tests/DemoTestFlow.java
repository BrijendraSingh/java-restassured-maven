package tests;

import io.restassured.response.Response;
import models.Customer;
import models.CustomerData;
import steps.DemoTestSteps;
import utils.*;

public class DemoTestFlow {
    DemoTestSteps demoTestSteps;
    Response response;

    DemoTestFlow() {
        demoTestSteps = new DemoTestSteps();
    }

    public DemoTestFlow given() {
        return this;
    }

    public DemoTestFlow when() {
        return this;
    }

    public DemoTestFlow then() {
        return this;
    }

    public void end() {
    }

    public DemoTestFlow demoTest_preparePayload() {
        demoTestSteps.preparePayload();
        return this;
    }

    public DemoTestFlow demoTest_executeRequest() {
        response = demoTestSteps.executeRequest(Methods.GET, EndPoints.GET_CUSTOMER_BY_ID +"?id=2", null);
        TestContext.getTestContext().put(TestDataKey.TEST_1, response);
        return this;
    }

    public DemoTestFlow demoTest_verify200Status() {
        demoTestSteps.validate200Status(TestDataKey.TEST_1);
        return this;
    }

    public DemoTestFlow demoTest_verifySchema() {
        demoTestSteps.validateSchema(TestDataKey.TEST_1, Schema.CUSTOMER);
        return this;
    }

    public DemoTestFlow demoTest_verifyResponse() {
        Assertions.compareObjects(
                TestContext.getTestContext().get(TestDataKey.TEST_1, Response.class)
                        .as(Customer.class),
                getExpectedCustomer()
        );
        return this;
    }

    private static Customer getExpectedCustomer() {
        CustomerData customerData = new CustomerData();
        customerData.setCreatedAt("2024-02-18T12:40:14 ");
        customerData.setEmail("alice.smith@example.com");
        customerData.setId(2);
        customerData.setFirstName("Alice");
        customerData.setLastName("Smith");
        customerData.setIsMaster(true);

        Customer expectedCustomer = new Customer();
        expectedCustomer.setData(customerData);
        expectedCustomer.setError(null);
        expectedCustomer.setSuccess(true);
        return expectedCustomer;
    }

    public DemoTestFlow demoTest_verifyDatabase() {
        demoTestSteps.validateDatabase();
        return this;
    }
}
