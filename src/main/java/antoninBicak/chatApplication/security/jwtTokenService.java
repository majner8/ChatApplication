package antoninBicak.chatApplication.security;

import antoninBicak.chatApplication.dto.TokenDTO;
import antoninBicak.chatApplication.util.SessionRequestData;

public interface jwtTokenService {
	public TokenDTO generateToken(long userID,long version);
	public void logout(SessionRequestData sessionData,boolean all);
}
