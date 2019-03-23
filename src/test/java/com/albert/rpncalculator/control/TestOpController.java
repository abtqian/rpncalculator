package com.albert.rpncalculator.control;

import com.albert.rpncalculator.TestConfig;
import com.albert.rpncalculator.op.NumericOperator;
import com.albert.rpncalculator.op.SymbolOperator;
import com.albert.rpncalculator.storage.PreservableStack;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Stack;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = TestConfig.class)
public class TestOpController {

    @InjectMocks
    private OpController opController;

    @Mock
    private CommandParser commandParser;

    @Mock
    private PreservableStack preservableStack;

    @Mock
    private NumericOperator numericOperator;

    @Mock
    private SymbolOperator symbolOperator;

    @Mock
    private OutputStringUtils outputStringUtils;

    @After
    public void validate() {
        validateMockitoUsage();
    }

    @Test
    public void ControllerTest() {
        when(commandParser.getNext()).thenReturn("1", "sqrt", null);
        when(commandParser.getPosition()).thenReturn(0);
        opController.ProcessInput("1 sqrt");
        verify(numericOperator).operate("1");
    }

    @Test
    public void ExceptionTest() throws Exception{
        when(commandParser.getNext()).thenReturn("1", "sqrt", null);
        when(commandParser.getPosition()).thenReturn(0);
        doThrow(new Exception("test")).when(symbolOperator).operate();
        opController.ProcessInput("1 sqrt");
    }
}
