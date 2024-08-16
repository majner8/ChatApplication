package antoninBicak.chatApplication.relationalDatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface ChatApplicationJpaRepository<ENT,ID> extends JpaRepository<ENT,ID>, ChatApplicationCrudeRepository<ENT,ID> {

	
	
}


