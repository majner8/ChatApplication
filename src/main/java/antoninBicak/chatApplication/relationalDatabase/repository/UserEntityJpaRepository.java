package antoninBicak.chatApplication.relationalDatabase.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import antoninBicak.chatApplication.relationalDatabase.entity.user.UserEntity;
import antoninBicak.chatApplication.relationalDatabase.repository.customRepository.UserEntityCustomRepository;
import lombok.Getter;
import lombok.Setter;

@Repository
public interface UserEntityJpaRepository extends JpaRepository<UserEntity,Long>,ChatApplicationCrudeRepository<UserEntity,Long>,UserEntityCustomRepository {

	
	public Optional<AuthorizationProjection>findByEmail(String email);
	public Optional<AuthorizationProjection>findAByPhonePreflixAndPhoneNumber(String phonePreflix,String phoneNumber);

	public boolean existsByEmail(String email);
	public boolean existsByPhonePreflixAndPhoneNumber(String phonePreflix,String phoneNumber);

	
	
	@Getter
	@Setter
	public static class AuthorizationProjection{
		private long userID;
		private String password;
		private long version;
		
	}
}
