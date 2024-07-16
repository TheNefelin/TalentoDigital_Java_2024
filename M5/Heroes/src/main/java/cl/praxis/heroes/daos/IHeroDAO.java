package cl.praxis.heroes.daos;

import cl.praxis.heroes.models.HeroDTO;

import java.util.List;

public interface IHeroDAO {
    public List<HeroDTO> getAllHero();
    public boolean addHero(HeroDTO heroDTO);
}
