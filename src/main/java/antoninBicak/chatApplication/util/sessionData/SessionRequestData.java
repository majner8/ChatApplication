package antoninBicak.chatApplication.util.sessionData;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public  class SessionRequestData {
	private final long userID;
	private final long authorizationVersion;
	
	public String getUserIDAsString() {
		return String.valueOf(this.userID);
	}
}
