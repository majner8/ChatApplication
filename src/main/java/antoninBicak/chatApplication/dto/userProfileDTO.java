package antoninBicak.chatApplication.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName="of")
@Builder(setterPrefix="set")
public class userProfileDTO {
private final long userID;
private final String firstName;
private final String lastName;
private final LocalDate birthDay;
private final String nickName;
private final String email;
private final String countryPreflix;
private final String phoneNumber;
	
}
