package com.albert.rpncalculator.op;

import com.albert.rpncalculator.TestConfig;
import com.albert.rpncalculator.op.symbolImpl.Add;
import com.albert.rpncalculator.storage.PreservableStack;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = TestConfig.class)
public class TestInsucient {
    @InjectMocks
    private Add add;
    @Mock
    private PreservableStack preservableStack;

    @Test
    public void TestInsucient() {
        when(preservableStack.pop()).thenReturn(0.0);
        when(preservableStack.size()).thenReturn(1);
        try {
            add.operate();
        }
        catch (Exception ex) {
            String str = ex.getMessage();
            Assert.assertEquals("insucient parameters", ex.getMessage());
            return;
        }
        Assert.fail();
    }
}
