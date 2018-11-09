package c332030.utils.aop.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface Factory {

    /**
     * The name of the factory
     */
    Class<?> type();

    /**
     * The identifier for determining which item should be instantiated
     */
    String id();
}
