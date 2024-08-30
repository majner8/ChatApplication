package antoninBicak.chatApplication.relationalDatabase.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.OptimisticLockException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import antoninBicak.chatApplication.dto.FinishRegistrationDTO;
import antoninBicak.chatApplication.dto.userSearchProfileDTO;
import antoninBicak.chatApplication.relationalDatabase.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Repository
public interface UserEntityJpaRepository extends JpaRepository<UserEntity,Long>,
ChatApplicationCrudeRepository<UserEntity,Long>
/*,UserEntityCustomRepository*/ {


	public Optional<AuthorizationProjection>findByEmail(String email);
	public Optional<AuthorizationProjection>findAByPhonePreflixAndPhoneNumber(String phonePreflix,String phoneNumber);
	public boolean existsByEmail(String email);
	public boolean existsByPhonePreflixAndPhoneNumber(String phonePreflix,String phoneNumber);

	public List<UserEntity> findByFirstName(String firstName);
	public List<UserEntity> findByLastName(String firstName);
	public List<UserEntity> findByFirstNameAndLastName(String firstName,String lastName);
	
	public List<UserEntity> findByFirstNameContaining(String firstName);
	public List<UserEntity> findByLastNameContaining(String firstName);
	public List<UserEntity> findByFirstNameContainingAndLastNameContaining(String firstName,String lastName);

	/*
	public List<UserEntity> findSimilarByFirstName(String firstName);
	public List<UserEntity> findSimilarByLastName(String firstName);
	public List<UserEntity> findSimilarByFirstNameAndLastName(String firstName,String lastName);
	*/
	public userSearchProfileDTO getById(long ID);
	/*
	public void updatePassword(String hashPassword,long userID,long version) throws OptimisticLockException;
	public void updateUserRegistrationData(FinishRegistrationDTO dto)throws OptimisticLockException;
	*/
	
	@Getter
	@Setter
	public static class AuthorizationProjection{
		private long userID;
		private String password;
		private long version;

	}
}
