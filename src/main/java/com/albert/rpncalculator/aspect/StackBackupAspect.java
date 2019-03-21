package com.albert.rpncalculator.aspect;

import com.albert.rpncalculator.op.impl.Undo;
import com.albert.rpncalculator.storage.ResultStack;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Component
public class StackBackupAspect {

    @Autowired
    private ResultStack resultStack;

    @Pointcut("execution(* com.albert.rpncalculator.op.*.operate(..))")
    public void OperatorPointCut() {}

    @AfterReturning("OperatorPointCut()")
    public void backupStack(JoinPoint point) {
        if(point.getTarget() instanceof Undo) {
            resultStack.load();
        }
        resultStack.save();
    }

    @AfterThrowing("OperatorPointCut()")
    public void recoveryStack() {
        resultStack.recovery();
    }
}
