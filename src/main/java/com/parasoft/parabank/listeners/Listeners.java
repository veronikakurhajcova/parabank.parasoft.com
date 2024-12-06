package com.parasoft.parabank.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + "Test started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test was successfull");

	}

	@Override
	public void onTestFailure(ITestResult result) {

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test starts");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test is finished");
	}

}
