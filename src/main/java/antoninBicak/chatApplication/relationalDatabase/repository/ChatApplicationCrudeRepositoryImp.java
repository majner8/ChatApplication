package antoninBicak.chatApplication.relationalDatabase.repository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public  class ChatApplicationCrudeRepositoryImp<ENT,ID> implements ChatApplicationCrudeRepository<ENT, ID> {

    @PersistenceContext
	private EntityManager manager;
	@Override
	public boolean saveOrIgnore(ENT entity) {
		try {
			this.manager.persist(entity);
		} catch (EntityExistsException e) {
			//log
			return false;
		}
		return true;
	}

	@Override
	public ENT persist(ENT entity) throws EntityExistsException {
		 this.manager.persist(entity);
		 return entity;
	}

}
