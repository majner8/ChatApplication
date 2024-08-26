package antoninBicak.chatApplication.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class FinishRegistrationDTO {
	@NotNull(message = "serName field cannot be null")
    @Pattern(regexp = "^[\\p{L} ]+$", message = "serName value can only contain alphabetic characters and spaces")
    private final String serName;

    @NotNull(message = "lastName field cannot be null")
    @Pattern(regexp = "^[\\p{L} ]+$", message = "lastName field can only contain alphabetic characters and spaces")
    private final String lastName;

	@NotNull(message="born field cannot be null")
	private final LocalDate born;



}
