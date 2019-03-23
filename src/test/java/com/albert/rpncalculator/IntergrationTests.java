package com.albert.rpncalculator;

import com.albert.rpncalculator.control.OpController;
import com.albert.rpncalculator.storage.PreservableStack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RpncalculatorApplication.class)
public class IntergrationTests {

    @Autowired
    private PreservableStack preservableStack;

    @Autowired
    private OpController opController;

    @Test
    public void TestCase1() {

    }
}
