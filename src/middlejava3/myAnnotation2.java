package middlejava3;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 		自定义的注解 
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年10月15日下午9:33:45
 */


@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface myAnnotation2 {
	String value() default "linjing";
}
