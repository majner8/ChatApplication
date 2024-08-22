package antoninBicak.chatApplication.relationalDatabase.entity.chat;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import antoninBicak.chatApplication.relationalDatabase.entity.user.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class UserChatNickNameEntity {




	@EmbeddedId
	private CompositeKey primaryKey;
	private String nickName;

	@ManyToOne()
	@MapsId("userID")
    @Getter(AccessLevel.NONE)
	private UserEntity userID;
	public String getChatID() {
		if(this.primaryKey==null) {
			throw new NullPointerException("Cannot retrive chatID, because field primaryKey is null");
		}
		return this.primaryKey.getChatID();
	}
	public long getUserID() {
		if(this.primaryKey==null) {
			throw new NullPointerException("Cannot retrive UserID, because field primaryKey is null");
		}
		return this.primaryKey.getUserID();
	}
	@Getter
	@Setter
	@Embeddable
	@ToString
	@EqualsAndHashCode
	@AllArgsConstructor(staticName = "of")
	public static  class CompositeKey implements Serializable{

		private static final long serialVersionUID = 1L;
		private long userID;
		private String chatID;

	}
}
