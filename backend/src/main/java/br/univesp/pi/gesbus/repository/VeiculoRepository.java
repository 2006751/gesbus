package br.univesp.pi.gesbus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.univesp.pi.gesbus.model.Veiculo;

@RepositoryRestResource(collectionResourceRel = "veiculos", path = "veiculo")
public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {
}
