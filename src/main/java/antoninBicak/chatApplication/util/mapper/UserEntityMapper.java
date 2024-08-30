package antoninBicak.chatApplication.util.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import antoninBicak.chatApplication.dto.userProfileDTO;
import antoninBicak.chatApplication.dto.userSearchProfileDTO;
import antoninBicak.chatApplication.relationalDatabase.entity.UserEntity;

@Mapper
public interface UserEntityMapper {
	    
	    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	   public void updateUserFromDto(userProfileDTO dto, @MappingTarget UserEntity entity);
	
	    public userSearchProfileDTO toUserSearchProfileDTO(UserEntity entity);
}
