package antoninBicak.chatApplication.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Builder;
import lombok.Getter;
@Getter
public class PhoneAuthorizationDTO extends AuthorizationDTO {
	@Pattern(regexp = "^\\d{1,3}$", message = "Country prefix must be 1-3 long and contain only digits")
	private final String countryPreflix;
    @Pattern(regexp = "^\\d{1,15}$", message = "number  must be 1-15 long and contain only digits")
	private final String number;

    @Builder
    public PhoneAuthorizationDTO(AuthorizationDTOType type, @NotNull(message = "password field cannot be null") PasswordDTO password,
			@Pattern(regexp = "^\\d{1,3}$", message = "Country prefix must be 1-3 long and contain only digits") String countryPreflix,
			@Pattern(regexp = "^\\d{1,15}$", message = "number  must be 1-15 long and contain only digits") String number) {
		super(type, password);
		this.countryPreflix = countryPreflix;
		this.number = number;
	}


}
