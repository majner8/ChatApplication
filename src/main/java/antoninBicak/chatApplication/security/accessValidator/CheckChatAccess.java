package antoninBicak.chatApplication.security.accessValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import antoninBicak.chatApplication.security.ChatPermission;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckChatAccess {

	ChatPermission role() default ChatPermission.Member;
	boolean allowItself() default false;
}
