package antoninBicak.chatApplication.dto.authorization;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class PasswordDTO {

	@NotNull(message="password field cannot be null")
	@Pattern(regexp = authorizationRegex.passwordRegexPattern,message="Invalid password field")
	private final String password;




}
