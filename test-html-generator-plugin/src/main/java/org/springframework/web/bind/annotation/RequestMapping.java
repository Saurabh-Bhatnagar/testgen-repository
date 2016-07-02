package org.springframework.web.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface RequestMapping
{
  public abstract String[] value();

  public abstract RequestMethod[] method();

  public abstract String[] params();

  public abstract String[] headers();

  public abstract String[] consumes();

  public abstract String[] produces();
}