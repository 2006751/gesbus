package br.univesp.pi.gesbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import br.univesp.pi.gesbus.model.Evento;
import br.univesp.pi.gesbus.model.Roteiro;
import br.univesp.pi.gesbus.model.TipoEvento;
import br.univesp.pi.gesbus.model.Usuario;
import br.univesp.pi.gesbus.model.Veiculo;
import br.univesp.pi.gesbus.model.Viagem;

@SpringBootApplication(scanBasePackages={"br.univesp.pi.gesbus.*"})
public class GesBusApplication  implements RepositoryRestConfigurer{
	
	public static void main(String[] args) {
		SpringApplication.run(GesBusApplication.class, args);
	}

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
    	
		cors.addMapping("/*").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE")
				.allowCredentials(false).maxAge(3600);

    	config.exposeIdsFor(Usuario.class);
        config.exposeIdsFor(Roteiro.class);
		config.exposeIdsFor(Evento.class);
		config.exposeIdsFor(Veiculo.class);
		config.exposeIdsFor(Viagem.class);
		config.exposeIdsFor(TipoEvento.class);
    }
    
    
}
