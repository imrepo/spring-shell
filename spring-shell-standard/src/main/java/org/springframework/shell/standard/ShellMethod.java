/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.shell.standard;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to mark a method as invokable via Spring Shell.
 *
 * @author Eric Bottard
 * @author Florent Biville
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ShellMethod {

	/**
	 * The name(s) by which this method can be invoked via Spring Shell. If not specified, the actual method name
	 * will be used (turning camelCase humps into "-").
	 * @return explicit command name(s) to use
	 */
	String[] key() default {};

	/**
	 * A description for the command. Should not contain any formatting (e.g. html) characters and would typically
	 * start with a capital letter and end with a dot.
	 * @return short description of what the command does
	 */
	String value() default "";

	/**
	 * The prefix to use for assigning parameters by name.
	 * @return prefix to use when not specified as part of the parameter annotation
	 */
	String prefix() default "--";

}
