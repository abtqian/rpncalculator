package com.albert.rpncalculator.control;

import com.albert.rpncalculator.annotation.OperatorClass;
import com.albert.rpncalculator.op.NumericOperator;
import com.albert.rpncalculator.op.Operator;
import com.albert.rpncalculator.op.SymbolOperator;
import com.albert.rpncalculator.storage.ResultStack;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
public class OpController {

    private static HashMap<String, Operator> opMap = new HashMap<>();

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CommandParser commandParser;

    @Autowired
    private ResultStack resultStack;

    @Autowired
    private NumericOperator newNumericOperator;

    @PostConstruct
    public void init() {
         applicationContext.getBeansWithAnnotation(OperatorClass.class)
                 .forEach((key, op) -> opMap.put(((SymbolOperator)op).getSymbol(), (Operator) op));
    }

    public String ProcessInput(String input) {
        StringBuilder sb = new StringBuilder();
        commandParser.readCmd(input);
        String opStr = null;
        try {
            while((opStr = commandParser.getNext()) != null) {
                if(NumberUtils.isCreatable(opStr)) {
                    newNumericOperator.setNumber(opStr);
                    newNumericOperator.operate();
                } else {
                    if(opMap.containsKey(opStr)) {
                        Operator operator = opMap.get(opStr);
                        operator.operate();
                    } else {
                        throw new Exception("This kind of operation is not supported!");
                    }
                }
            }
        } catch (Exception ex) {
            sb.append(getExceptionString(opStr, ex.getMessage()));
            sb.append("\n");
        }

        sb.append(resultStack.printStack());
        return sb.toString();
    }

    private String getExceptionString(String operatorName, String message) {
        return "operator " + operatorName + " (position: " + commandParser.getPosition() + "): " + message;
    }
}
