package antoninBicak.chatApplication.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public abstract class AuthorizationDTO {
	private final  AuthorizationDTOType type;

	@NotNull(message="password field cannot be null")
	@Pattern(regexp = authorizationRegex.passwordRegexPattern,message="Invalid password field")
	private final  PasswordDTO password;







}
