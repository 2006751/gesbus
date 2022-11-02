package br.univesp.pi.gesbus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.univesp.pi.gesbus.model.Usuario;
import br.univesp.pi.gesbus.repository.UsuarioRepository;
 
public class UsuarioDetailsServiceImpl  implements UserDetailsService {
 
    @Autowired
    private UsuarioRepository userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

    	Usuario user = userRepository.findByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new UsuarioDetail(user);
    }

}
