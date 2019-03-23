package com.albert.rpncalculator.op;

import com.albert.rpncalculator.TestConfig;
import com.albert.rpncalculator.op.symbolImpl.Divide;
import com.albert.rpncalculator.storage.PreservableStack;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = TestConfig.class)
public class DivideTest {
    @InjectMocks
    private Divide divide;
    @Mock
    private PreservableStack preservableStack;

    @Test
    public void TestDivide() {
        when(preservableStack.pop()).thenReturn(3.0);
        when(preservableStack.size()).thenReturn(2);
        try {
            divide.operate();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
        verify(preservableStack).push(1.0);
    }

    @Test
    public void TestDivideZero() {
        when(preservableStack.pop()).thenReturn(0.0);
        when(preservableStack.size()).thenReturn(2);
        try {
            divide.operate();
        }
        catch (Exception ex) {
            String str = ex.getMessage();
            Assert.assertEquals("zero cannot be divided!", ex.getMessage());
            return;
        }
        Assert.fail();
    }

    @Test
    public void TestSymbol() {
        Assert.assertEquals("/", divide.getSymbol());
    }
}
