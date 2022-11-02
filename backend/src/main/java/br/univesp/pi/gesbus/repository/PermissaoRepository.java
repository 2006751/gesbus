package br.univesp.pi.gesbus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.univesp.pi.gesbus.model.Permissao;

@RepositoryRestResource(collectionResourceRel = "permissoes", path = "permissao")
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

	Permissao findByDescription(final String description);
	
}
