package antoninBicak.chatApplication.relationalDatabase.entity;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private LocalDateTime createdAt=LocalDateTime.now(Clock.systemUTC());
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userID")
	private UserEntity createdBy;
	@Column()
	private boolean isGroupChat;

	@OneToMany(mappedBy = "primaryKey.chatID",  fetch = FetchType.EAGER)
	private List<UserChatNickNameEntity> chatMemberID;

}
