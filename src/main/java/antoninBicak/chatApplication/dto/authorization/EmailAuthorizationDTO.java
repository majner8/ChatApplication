package antoninBicak.chatApplication.dto.authorization;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;

@Getter
public class EmailAuthorizationDTO extends AuthorizationDTO {
	@Email(message = "Email is not valid")
    @NotNull(message = "Email cannot be null")
    private final String email;

	@Builder
	public EmailAuthorizationDTO(AuthorizationDTOType type, @NotNull(message = "password field cannot be null") PasswordDTO password,
			@Email(message = "Email is not valid") @NotNull(message = "Email cannot be null") String email) {
		super(type, password);
		this.email = email;
	}






}
