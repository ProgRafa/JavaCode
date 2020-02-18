package com.team3.csvreader;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CsvAttributeSetter {
    String attributeName() default "";
}
