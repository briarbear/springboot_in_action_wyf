package com.xzp.ch1_2_3.ch3.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * linux判定条件
 */
public class LinuxCondition implements Condition {

    public boolean matches(ConditionContext context,
                           AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().getProperty("os.name").contains("Linux");
    }

}