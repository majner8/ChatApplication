package antoninBicak.chatApplication.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.With;
import lombok.experimental.SuperBuilder;

@Getter
@AllArgsConstructor()
@SuperBuilder(setterPrefix="set")
public abstract class MessageDTO {
	private final String chatID;
	private final long messageOrder;

	/**Metod generate copy if this object, with set messageOrder */
	public abstract MessageDTO setMessageOrder(long messageOrder);
}
