package praktikum;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация для исключения из отчёта Jacoco
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface JacocoGeneratedExclude {
}
