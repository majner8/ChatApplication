package antoninBicak.chatApplication.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(staticName="of")
@Getter
public  class SessionRequestData {
	private final long userID;
	private final long authorizationVersion;
	
	public String getUserIDAsString() {
		return String.valueOf(this.userID);
	}
	public SessionRequestData setNewAuthoriyzationVersion(long newAuthorizationVersion) {
		return SessionRequestData.of(this.userID, newAuthorizationVersion);
	}
}
