package cl.praxis.heroes.services.imp;

import cl.praxis.heroes.daos.imp.HeroDAO;
import cl.praxis.heroes.models.HeroDTO;
import cl.praxis.heroes.services.IHeroService;

import java.util.List;

public class HeroService implements IHeroService {
    HeroDAO heroDAO = new HeroDAO();

    @Override
    public List<HeroDTO> getAllHero() {
        return heroDAO.getAllHero();
    }

    @Override
    public boolean addHero(HeroDTO heroDTO) {
        return heroDAO.addHero(heroDTO);
    }
}
