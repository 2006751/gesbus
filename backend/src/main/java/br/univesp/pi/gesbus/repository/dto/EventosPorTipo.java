package br.univesp.pi.gesbus.repository.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventosPorTipo implements Serializable {
	String descricao;
	long total;
}
