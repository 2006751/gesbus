package br.univesp.pi.gesbus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.univesp.pi.gesbus.model.Viagem;

@RepositoryRestResource(collectionResourceRel = "viagens", path = "viagem")
public interface ViagemRepository extends CrudRepository<Viagem, Long> {
}
