package antoninBicak.chatApplication.relationalDatabase.entity.chat;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import antoninBicak.chatApplication.relationalDatabase.entity.user.UserEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ChatInformationEntity {
	@Id
	private String chatID;
	@Column()
	private String chatName;
	@Column()
	private LocalDateTime createdAt;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userID")
	private UserEntity createdBy;
	@Column()
	private boolean groupChat;


}
