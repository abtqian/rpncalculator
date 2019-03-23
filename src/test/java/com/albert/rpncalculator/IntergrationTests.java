package com.albert.rpncalculator;

import com.albert.rpncalculator.control.OpController;
import com.albert.rpncalculator.storage.PreservableStack;
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
public class IntergrationTests {

    @Autowired
    private PreservableStack preservableStack;

    @Autowired
    private OpController opController;

    @Test
    public void TestCase1() {
        preservableStack.clear();
        Assert.assertEquals("stack: 5 2", opController.ProcessInput("5 2"));
    }

    @Test
    public void TestCase2() {
        preservableStack.clear();
        Assert.assertEquals("stack: 1.4142135623", opController.ProcessInput("2 sqrt"));
        Assert.assertEquals("stack: 3", opController.ProcessInput("clear 9 sqrt"));
    }

    @Test
    public void TestCase3() {
        preservableStack.clear();
        Assert.assertEquals("stack: 3", opController.ProcessInput("5 2 - "));
        Assert.assertEquals("stack: 0", opController.ProcessInput("3 -"));
        Assert.assertEquals("stack:", opController.ProcessInput("clear"));
    }

    @Test
    public void TestCase4() {
        preservableStack.clear();
        Assert.assertEquals("stack: 5 4 3 2", opController.ProcessInput("5 4 3 2"));
        Assert.assertEquals("stack: 20", opController.ProcessInput("undo undo *"));
        Assert.assertEquals("stack: 100", opController.ProcessInput("5 *"));
        Assert.assertEquals("stack: 20 5", opController.ProcessInput("undo"));
    }

    @Test
    public void TestCase5() {
        preservableStack.clear();
        Assert.assertEquals("stack: 7 6", opController.ProcessInput("7 12 2 /"));
        Assert.assertEquals("stack: 42", opController.ProcessInput("*"));
        Assert.assertEquals("stack: 10.5", opController.ProcessInput("4 /"));
    }

    @Test
    public void TestCase6() {
        preservableStack.clear();
        Assert.assertEquals("stack: 1 2 3 4 5", opController.ProcessInput("1 2 3 4 5 "));
        Assert.assertEquals("stack: 1 2 3 20", opController.ProcessInput("*"));
        Assert.assertEquals("stack: -1", opController.ProcessInput("clear 3 4 -"));
    }

    @Test
    public void TestCase7() {
        preservableStack.clear();
        Assert.assertEquals("stack: 1 2 3 4 5", opController.ProcessInput("1 2 3 4 5"));
        Assert.assertEquals("stack: 120", opController.ProcessInput("* * * *"));
    }

    @Test
    public void TestCase8() {
        preservableStack.clear();
        String ret = opController.ProcessInput("1 2 3 * 5 + * * 6 5");
        Assert.assertEquals("operator * (position: 15): insucient parameters\nstack: 11", ret);
    }

    @Test
    public void TestCase9() {
        preservableStack.clear();
        String ret = opController.ProcessInput("1 0 /");
        Assert.assertEquals("operator / (position: 5): zero cannot be divided!\nstack: 1 0", ret);
    }

    @Test
    public void TestCase10() {
        preservableStack.clear();
        String ret = opController.ProcessInput("-1 -1 sqrt");
        Assert.assertEquals("operator sqrt (position: 7): Negative numbers cannot sqrt!\nstack: -1 -1", ret);
    }

    @Test
    public void TestCase11() {
        preservableStack.clear();
        String ret = opController.ProcessInput("qwert");
        Assert.assertEquals("operator qwert (position: 1): This kind of operation is not supported!\nstack:", ret);
    }

}
