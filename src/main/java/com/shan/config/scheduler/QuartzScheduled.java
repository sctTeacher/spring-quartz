//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.shan.config.scheduler;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface QuartzScheduled {
    int count() default -1;

    String cron() default "";

    int fixedRate() default -1;

    String group() default "";

    long initialDelay() default -1L;

    String name();

    String param() default "";

    boolean status() default true;
}
