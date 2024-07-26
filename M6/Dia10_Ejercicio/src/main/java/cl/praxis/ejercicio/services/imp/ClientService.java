package cl.praxis.ejercicio.services.imp;

import cl.praxis.ejercicio.entities.Client;
import cl.praxis.ejercicio.repositories.IClientRepository;
import cl.praxis.ejercicio.services.IBaseServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IBaseServiceCRUD<Client> {
    @Autowired
    private IClientRepository repo;

    @Override
    public List<Client> findAll() {
        return repo.findAll();
    }

    @Override
    public Client findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Client create(Client client) {
        return repo.save(client);
    }

    @Override
    public Client update(Client client) {
        if (repo.existsById(client.getId())) {
            return repo.save(client);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
