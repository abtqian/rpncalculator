package com.albert.rpncalculator.storage;

import com.albert.rpncalculator.TestConfig;
import com.albert.rpncalculator.control.OutputStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = TestConfig.class)
public class TestPreservableStack {

    @Autowired
    private PreservableStack preservableStack;

    @Test
    public void stackSaveLoadTest() {
        preservableStack.clear();
        preservableStack.push(1.0);
        preservableStack.save();
        preservableStack.push(2.0);
        preservableStack.save();
        Assert.assertEquals("stack: 1 2", OutputStringUtils.GetStackContent(preservableStack));

        preservableStack.push(3.0);
        preservableStack.save();

        preservableStack.load();
        Assert.assertEquals("stack: 1 2", OutputStringUtils.GetStackContent(preservableStack));
    }

    @Test
    public void stackRecoveryTest() {
        preservableStack.clear();
        preservableStack.push(1.0);
        preservableStack.save();
        preservableStack.push(2.0);
        preservableStack.save();
        Assert.assertEquals("stack: 1 2", OutputStringUtils.GetStackContent(preservableStack));

        preservableStack.push(3.0);
        preservableStack.recovery();
        Assert.assertEquals("stack: 1 2", OutputStringUtils.GetStackContent(preservableStack));

    }

}
