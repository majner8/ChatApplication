package antoninBicak.chatApplication.dto.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class MessageDTO {
	private final String chatID;
	private final long messageOrder;
	
	/**Metod generate copy if this object, with set messageOrder */
	public abstract MessageDTO setMessageOrder(long messageOrder);
}
