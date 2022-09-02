package spring_crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import spring_crud.entities.Persistable;

@NoRepositoryBean
public interface Repository<T extends Persistable> extends JpaRepository<T,Integer> {
}
