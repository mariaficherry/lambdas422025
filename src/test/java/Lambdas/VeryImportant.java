package Lambdas;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD}) // Only valid for classes and fields
@Retention(RetentionPolicy.RUNTIME) // Use it while program is running
public @interface VeryImportant {
}
