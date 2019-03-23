package com.albert.rpncalculator.op;

import com.albert.rpncalculator.TestConfig;
import com.albert.rpncalculator.op.numericImpl.NewNumber;
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
public class NewNumberTest {
    @InjectMocks
    private NewNumber newNumber;
    @Mock
    private PreservableStack preservableStack;

    @Test
    public void TestNewNumber() {
        try {
            newNumber.operate("6.0");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
        verify(preservableStack).push(6.0);
    }
}
