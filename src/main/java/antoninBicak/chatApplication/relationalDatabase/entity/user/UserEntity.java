package antoninBicak.chatApplication.relationalDatabase.entity.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class UserEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private long userID;
	@Version
	private long version;
	
	@Column()
	private String email;
	@Column()
	private String phonePreflix;
	@Column()
	private String phoneNumber;
	@Column()
	private String password;
	
	@Column()
	private String serName;
	@Column()
	private String lastName;
	@Column()
	private String nickName;
	@Column()
	private LocalDate birthDay;	

	@Column()
	private LocalDateTime lastChange;
	
	

}
