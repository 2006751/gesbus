package br.univesp.pi.gesbus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.univesp.pi.gesbus.model.Roteiro;

@RepositoryRestResource(collectionResourceRel = "roteiros", path = "roteiro")
public interface RoteiroRepository extends CrudRepository<Roteiro, Long> {
}
