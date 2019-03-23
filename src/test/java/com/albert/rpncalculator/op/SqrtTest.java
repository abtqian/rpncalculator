package com.albert.rpncalculator.op;

import com.albert.rpncalculator.TestConfig;
import com.albert.rpncalculator.op.symbolImpl.Sqrt;
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
public class SqrtTest {
    @InjectMocks
    private Sqrt sqrt;
    @Mock
    private PreservableStack preservableStack;

    @Test
    public void TestSqrt() {
        when(preservableStack.pop()).thenReturn(9.0);
        when(preservableStack.size()).thenReturn(1);
        try {
            sqrt.operate();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
        verify(preservableStack).push(3.0);
    }

    @Test
    public void TestSqrtNegative() {
        when(preservableStack.pop()).thenReturn(-1.0);
        when(preservableStack.size()).thenReturn(1);
        try {
            sqrt.operate();
        }
        catch (Exception ex) {
            String str = ex.getMessage();
            Assert.assertEquals("Negative numbers cannot sqrt!", ex.getMessage());
            return;
        }
        Assert.fail();
    }

    @Test
    public void TestSymbol() {
        Assert.assertEquals("sqrt", sqrt.getSymbol());
    }
}
