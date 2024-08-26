package antoninBicak.chatApplication.relationalDatabase.repository.customRepository;

import javax.persistence.OptimisticLockException;

import antoninBicak.chatApplication.dto.FinishRegistrationDTO;

public interface UserEntityCustomRepository {

	public void updatePassword(String hashPassword,long userID,long version) throws OptimisticLockException;
	public void updateUserRegistrationData(FinishRegistrationDTO dto)throws OptimisticLockException;
}
