package com.albert.rpncalculator.control;

import com.albert.rpncalculator.annotation.SymbolOperatorClass;
import com.albert.rpncalculator.op.NumericOperator;
import com.albert.rpncalculator.op.SymbolOperator;
import com.albert.rpncalculator.storage.PreservableStack;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
public class OpController {

    private static HashMap<String, SymbolOperator> opMap = new HashMap<>();

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CommandParser commandParser;

    @Autowired
    private PreservableStack preservableStack;

    @Autowired
    private NumericOperator numericOperator;

    @PostConstruct
    public void init() {
         applicationContext.getBeansWithAnnotation(SymbolOperatorClass.class)
                 .forEach((key, op) -> opMap.put(((SymbolOperator)op).getSymbol(), (SymbolOperator) op));
    }

    public String ProcessInput(String input) {
        StringBuilder sb = new StringBuilder();
        commandParser.readCmd(input);
        String opStr = null;
        try {
            while((opStr = commandParser.getNext()) != null) {
                if(NumberUtils.isCreatable(opStr)) {
                    numericOperator.operate(opStr);
                } else {
                    if(opMap.containsKey(opStr)) {
                        SymbolOperator symbolOperator = opMap.get(opStr);
                        symbolOperator.operate();
                    } else {
                        throw new Exception("This kind of operation is not supported!");
                    }
                }
            }
        } catch (Exception ex) {
            sb.append(OutputStringUtils.GetExceptionString(opStr, commandParser.getPosition(),ex.getMessage()));
            sb.append("\n");
        }

        sb.append(OutputStringUtils.GetStackContent(preservableStack));
        return sb.toString();
    }

}
