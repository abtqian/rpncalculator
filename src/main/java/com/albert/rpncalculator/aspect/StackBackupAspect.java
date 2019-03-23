package com.albert.rpncalculator.aspect;

import com.albert.rpncalculator.storage.PreservableStack;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * This aspect class is used to save result stack each time an operation is done.
 * If there is an exception during the operation, the stack will be recovered.
 */
@Aspect
@Component
public class StackBackupAspect {

    @Autowired
    private PreservableStack preservableStack;

    @Pointcut("execution(* com.albert.rpncalculator.op.*.operate(..))")
    public void OperatorPointCut() {}

    @AfterReturning("OperatorPointCut()")
    public void backupStack(JoinPoint point) {
        preservableStack.save();
    }

    @AfterThrowing("OperatorPointCut()")
    public void recoveryStack() {
        preservableStack.recovery();
    }
}
