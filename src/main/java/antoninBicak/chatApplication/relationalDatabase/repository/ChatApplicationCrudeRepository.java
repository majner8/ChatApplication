package antoninBicak.chatApplication.relationalDatabase.repository;

import javax.persistence.EntityExistsException;

public  interface ChatApplicationCrudeRepository<ENT,ID>{


	/**Method check if entity exist and then call persist method.
	 *  @return true if save method was successful
	 *  		false if entity exist
	 *   */
	public boolean saveOrIgnore(ENT entity);
	public ENT persist(ENT entity)throws EntityExistsException;
}