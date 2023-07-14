package com.custom.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import com.enums.ExecutionType;

@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotations {

	public String[] author();

	public ExecutionType[] executionType();
	

}
