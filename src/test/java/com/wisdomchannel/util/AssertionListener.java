package com.wisdomchannel.util;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
 
public class AssertionListener extends TestListenerAdapter {
 
    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
        Assertion.flag = true;       
        Assertion.errors.clear();
    }
     
    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        this.handleAssertion(tr);
    }
     
    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
        this.handleAssertion(tr);
    }
     
    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        this.handleAssertion(tr);
    }
     
    private int index = 0;
     
    private void handleAssertion(ITestResult tr){
        if(!Assertion.flag){
//            takeScreenShot(tr);
            Throwable throwable = tr.getThrowable();           
            if(throwable==null){
                throwable = new Throwable();
            }           
            StackTraceElement[] traces = throwable.getStackTrace();
            StackTraceElement[] alltrace = new StackTraceElement[0];           
            for (Error e : Assertion.errors) {
                StackTraceElement[] errorTraces = e.getStackTrace();
                StackTraceElement[] et = this.getKeyStackTrace(tr, errorTraces);
                StackTraceElement[] message = new StackTraceElement[]{new StackTraceElement("message : "+e.getMessage()+" in method : ", tr.getMethod().getMethodName(), tr.getTestClass().getRealClass().getSimpleName(), index)};
                index = 0;
                alltrace = this.merge(alltrace, message);
                alltrace = this.merge(alltrace, et);
            }
            if(traces!=null){
                traces = this.getKeyStackTrace(tr, traces);
                alltrace = this.merge(alltrace, traces);
            }           
            throwable.setStackTrace(alltrace);
            tr.setThrowable(throwable);
            Assertion.flag = true;   
            Assertion.errors.clear();
            tr.setStatus(ITestResult.FAILURE);           
        }
    }
     
    private StackTraceElement[] getKeyStackTrace(ITestResult tr, StackTraceElement[] stackTraceElements){
        List<StackTraceElement> ets = new ArrayList<StackTraceElement>();
        for (StackTraceElement stackTraceElement : stackTraceElements) {           
            if(stackTraceElement.getClassName().equals(tr.getTestClass().getName())){               
                ets.add(stackTraceElement);
                index = stackTraceElement.getLineNumber();
            }
        }
        StackTraceElement[] et = new StackTraceElement[ets.size()];
        for (int i = 0; i < et.length; i++) {
            et[i] = ets.get(i);
        }
        return et;
    }
     
    private StackTraceElement[] merge(StackTraceElement[] traces1, StackTraceElement[] traces2){
        StackTraceElement[] ste = new StackTraceElement[traces1.length+traces2.length];
        for (int i = 0; i < traces1.length; i++) {
            ste[i] = traces1[i];
        }
        for (int i = 0; i < traces2.length; i++) {
            ste[traces1.length+i] = traces2[i];
        }
        return ste;
    }
    //所以这里我执行截图的时候就获取到了我运行过程中实力对象的driver了，懂了吧。所以当我再回去调用我基类的对象时，那么driver就是同一个了
//    private void takeScreenShot(ITestResult tr) {
//        DriverBase b = (DriverBase) tr.getInstance();
//        b.takeScreenShot();
//    }
    @Override
    public void onFinish(ITestContext testContext) {
//         log.info("Test Finish");

         Iterator<ITestResult> listOfFailedTests = testContext.getFailedTests().getAllResults().iterator();
        Iterator<ITestResult> listOfSkipedTests = testContext.getSkippedTests().getAllResults().iterator();
        while (listOfSkipedTests.hasNext()) {
            ITestResult failedTest = listOfSkipedTests.next();
            ITestNGMethod method = failedTest.getMethod();
            if (testContext.getFailedTests().getResults(method).size() > 0) {
                listOfSkipedTests.remove();
            } else {
                if (testContext.getPassedTests().getResults(method).size() > 0) {
                    listOfSkipedTests.remove();
                }
            }
        }

    }
}
