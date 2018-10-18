package com.coffee.jiahui.config.web.my;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MySelf {

	String name() default "";
	
	String homeTown() default "";
	
	int age() default 18;
}
