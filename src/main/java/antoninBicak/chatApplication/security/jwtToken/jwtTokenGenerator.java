package antoninBicak.chatApplication.security.jwtToken;

import antoninBicak.chatApplication.dto.TokenDTO;

public interface jwtTokenGenerator {

	public TokenDTO generateToken(long userID,long version);
}
