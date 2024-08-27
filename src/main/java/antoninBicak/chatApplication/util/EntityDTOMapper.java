package antoninBicak.chatApplication.util;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import antoninBicak.chatApplication.dto.userProfileDTO;
import antoninBicak.chatApplication.relationalDatabase.entity.UserEntity;

@Mapper
public interface EntityDTOMapper {
	    
	    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	    void updateUserFromDto(userProfileDTO dto, @MappingTarget UserEntity entity);
	
}
