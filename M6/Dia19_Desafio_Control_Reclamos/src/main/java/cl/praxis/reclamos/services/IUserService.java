package cl.praxis.reclamos.services;

import cl.praxis.reclamos.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService {
    User register(User user);
}
