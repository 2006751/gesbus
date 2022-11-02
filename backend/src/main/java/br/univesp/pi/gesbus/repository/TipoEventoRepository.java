package br.univesp.pi.gesbus.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.univesp.pi.gesbus.model.TipoEvento;

@RepositoryRestResource(collectionResourceRel = "tipos_evento", path = "tipo_evento")
public interface TipoEventoRepository extends CrudRepository<TipoEvento, Long> {
	
	Optional<TipoEvento> findByDescricao(final String descricao);
	
}
