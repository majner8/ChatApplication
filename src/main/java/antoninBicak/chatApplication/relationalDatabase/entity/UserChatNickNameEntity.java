package antoninBicak.chatApplication.relationalDatabase.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Version;

import antoninBicak.chatApplication.security.ChatPermission;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
@Getter
@Setter
@ToString
@Entity
@Accessors(chain = true)
public class UserChatNickNameEntity {




	@EmbeddedId
	private CompositeKey primaryKey;
	private String nickName;
    @Enumerated(EnumType.STRING) 
	private ChatPermission permission;
	
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
