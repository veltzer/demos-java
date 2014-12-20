package effective_java_exercises;

import java.lang.annotation.*;

/**
 * Indicates the default implementation for a service.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultTo {
	Class<?> value();
}