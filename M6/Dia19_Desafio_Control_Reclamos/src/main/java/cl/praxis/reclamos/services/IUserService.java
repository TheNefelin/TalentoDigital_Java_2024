package cl.praxis.reclamos.services;

import cl.praxis.reclamos.entities.UserEntitiy;

public interface IUserService {
    UserEntitiy register(UserEntitiy user);
}
