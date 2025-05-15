package com.Goibibo;
import org.testng.annotations.Test;

import pages.JsExecutor;

public class JsExecutorTest {
	@Test
	public void test1() {
		JsExecutor js = new JsExecutor();
		js.jsExecutor();
	}

}
