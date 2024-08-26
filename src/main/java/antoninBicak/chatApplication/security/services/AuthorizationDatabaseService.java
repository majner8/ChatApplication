package antoninBicak.chatApplication.security.services;

import java.util.Optional;

import antoninBicak.chatApplication.dto.AuthorizationDTO;
import antoninBicak.chatApplication.dto.FinishRegistrationDTO;
import antoninBicak.chatApplication.dto.PasswordDTO;
import antoninBicak.chatApplication.util.SessionRequestData;
import lombok.AllArgsConstructor;
import lombok.Getter;

public interface AuthorizationDatabaseService {
	public Optional<AuthorizationResultDTO> login(AuthorizationDTO dto);
	public Optional<AuthorizationResultDTO> register(AuthorizationDTO dto);
	public void changePassword(PasswordDTO password,SessionRequestData sessionData);
	public void finishRegistration(FinishRegistrationDTO dto,SessionRequestData sessionData);

	@Getter
	@AllArgsConstructor()
	public static class AuthorizationResultDTO{
		private final long userID;
		private final long version;

		public static AuthorizationResultDTO of(long userID,long version) {
			return new AuthorizationResultDTO(userID,version);
		}
	}
}
