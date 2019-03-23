package com.albert.rpncalculator.control;

import com.albert.rpncalculator.TestConfig;
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
public class TestCommandParser {

    @Autowired
    private CommandParser commandParser;

    @Test
    public void TestParser() {
        commandParser.readCmd("1 2 3");
        Assert.assertEquals("1", commandParser.getNext());
        commandParser.getNext();
        Assert.assertEquals(3, commandParser.getPosition());
    }
}
