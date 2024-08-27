package antoninBicak.chatApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class userSearchProfileDTO {
	private   String nickName;
	private  String firstName;
	private   String lastName;
	private  long userID;
	
}
