package middlejava3;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 		�Զ����ע�� 
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��10��15������9:33:45
 */


@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface myAnnotation2 {
	String value() default "linjing";
}
