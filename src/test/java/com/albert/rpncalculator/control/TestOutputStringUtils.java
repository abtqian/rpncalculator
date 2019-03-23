package com.albert.rpncalculator.control;

import com.albert.rpncalculator.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Stack;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = TestConfig.class)
public class TestOutputStringUtils {

    @Test
    public void TestGetStackContent() {
        Stack<Double> stack = new Stack<>();
        stack.push(1.0);
        stack.push(2.0);
        Assert.assertEquals("stack: 1 2", OutputStringUtils.GetStackContent(stack));
    }

    @Test
    public void TestGetExceptionString(){
        Assert.assertEquals("operator name (position: 0): message", OutputStringUtils.GetExceptionString("name", 0, "message"));
    }


}
