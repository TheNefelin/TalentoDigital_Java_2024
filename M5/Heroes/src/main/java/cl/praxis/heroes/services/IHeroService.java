package cl.praxis.heroes.services;

import cl.praxis.heroes.models.HeroDTO;

import java.util.List;

public interface IHeroService {
    public List<HeroDTO> getAllHero();
    public boolean addHero(HeroDTO heroDTO);
}
