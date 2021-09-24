package example.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import example.data.entity.Simple;

@Repository
@RepositoryRestResource(collectionResourceRel = "simples", path = "simples")
public interface SimpleRepository  extends JpaRepository<Simple, Long>
{
}
