package antoninBicak.chatApplication.dto.authorization;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter
@AllArgsConstructor
public abstract class AuthorizationDTO {
	private final  AuthorizationDTOType type;

	@NotNull(message="password field cannot be null")
	@Pattern(regexp = authorizationRegex.passwordRegexPattern,message="Invalid password field")
	private final  PasswordDTO password;







}
