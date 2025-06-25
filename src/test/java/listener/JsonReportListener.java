package listener;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReportListener implements ITestListener {
    private List<JSONObject>  testResults = new ArrayList<>();
    private int totalTests=0;
    private int passedCount=0;
    private int failedCount=0;
    private int skippedCount=0;

    @Override
    public void onTestStart(ITestResult result) {
        totalTests++;
    }

    @Override
    public void onTestSuccess(ITestResult result) {
//        ITestListener.super.onTestSuccess(result);
        addTestResult(result, "PASSED");
        passedCount++;
    }

    @Override
    public void onFinish(ITestContext context) {
        JSONObject report = new JSONObject();
        report.put("suiteName", context.getSuite().getName());
        report.put("executionStatus", failedCount > 0 ? "FAILED": "PASSED");
        report.put("totalTestCases" , totalTests);
        report.put("passedTestCases", passedCount);
        report.put("failedTestCases", failedCount);
        report.put("skippedTestCases", skippedCount);
        report.put("testResults", new JSONArray(testResults));


        try(FileWriter file = new FileWriter("testng-report.json")){
            file.write(report.toString(4));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        addTestResult(result, "FAILED");
        failedCount++;
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        addTestResult(result, "SKIPPED");
        skippedCount++;
    }

    private void addTestResult(ITestResult result, String status){
        JSONObject testResult = new JSONObject();
        testResult.put("testName", result.getMethod().getMethodName());
        testResult.put("status", status);
        testResult.put("className", result.getTestClass().getName());
        testResult.put("executionTime", result.getEndMillis()- result.getStartMillis());
        if( result.getThrowable() !=null){
            testResult.put("errorMessage", result.getThrowable().getMessage());
            testResult.put("errorStackTrace", result.getThrowable().getStackTrace());
        }
        testResults.add(testResult);
    }

}
