package com.albert.rpncalculator.op;

import com.albert.rpncalculator.TestConfig;
import com.albert.rpncalculator.op.symbolImpl.Undo;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = TestConfig.class)
public class UndoTest {
    @InjectMocks
    private Undo undo;
    @Mock
    private PreservableStack preservableStack;

    @Test
    public void TestUndo() {
        try {
            undo.operate();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
        verify(preservableStack).load();
    }

    @Test
    public void TestSymbol() {
        Assert.assertEquals("undo", undo.getSymbol());
    }
}
