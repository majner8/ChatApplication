package antoninBicak.chatApplication.relationalDatabase.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import antoninBicak.chatApplication.dto.userProfileDTO;
import antoninBicak.chatApplication.dto.userSearchProfileDTO;
import antoninBicak.chatApplication.relationalDatabase.entity.UserEntity;
import antoninBicak.chatApplication.relationalDatabase.repository.UserEntityJpaRepository;
import antoninBicak.chatApplication.util.SessionRequestData;
import antoninBicak.chatApplication.util.mapper.UserEntityMapper;

public class UserDatabaseServiceImplementation implements UserDatabaseService {

	@Autowired
	private UserEntityJpaRepository userEntity;
	@Autowired
	private UserEntityMapper mapper;
	@Override
	public userProfileDTO updateUserProfile(SessionRequestData sessionData,userProfileDTO dto) {
		
		UserEntity entity=this.userEntity.findById(dto.getUserID())
				
			    .orElseThrow(()->new EntityNotFoundException("User not found with ID: " + dto.getUserID()));
		entity.setVersion(sessionData.getAuthorizationVersion());
		this.mapper.updateUserFromDto(dto, entity);
		this.userEntity.save(entity);
		return null;
	}

	@Override
	public List<userSearchProfileDTO> findUser(String firstName, String lastName, boolean similar) {
		
		if(!similar) {
			if(firstName==null) return this.userEntity.findByLastName(lastName);
			if(lastName==null) return this.userEntity.findByFirstName(firstName);
			return this.userEntity.findByFirstNameAndLastName(firstName, lastName);
		}
			if(firstName==null) return this.userEntity.findSimilarByLastName(lastName);
			if(lastName==null) return this.userEntity.findSimilarByFirstName(firstName);
			return this.userEntity.findSimilarByFirstNameAndLastName(firstName, lastName);
		
		}

	@Override
	public userSearchProfileDTO getUserProfile(long userID) {
		return this.userEntity.getById(userID);
	}

}
