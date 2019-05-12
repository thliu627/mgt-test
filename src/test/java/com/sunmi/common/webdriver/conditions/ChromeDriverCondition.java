package com.sunmi.common.webdriver.conditions;

import com.sunmi.common.constant.DriverConstants;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/26 23:34
 */
public class ChromeDriverCondition implements Condition {

    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return "chrome".equals(DriverConstants.driverCondition);
    }
}
