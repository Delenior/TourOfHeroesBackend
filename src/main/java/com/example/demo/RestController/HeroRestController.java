package com.example.demo.RestController;

import com.example.demo.Model.Hero;
import com.example.demo.Repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/hero")
@CrossOrigin(origins = "http://localhost:4200")
public class HeroRestController {

    @Autowired
    private HeroRepository heroRepository;

    @GetMapping(path="/all")
    public List<Hero> getAllHeroes()
    {
        return heroRepository.findAll();
    }

    @GetMapping(path = "/get/{id}")
    public Optional getOneById(@PathVariable String id)
    {
        return Optional.of(heroRepository.findById(id));
    }

    @PostMapping(path = "/new")
    public Hero saveHero(@RequestBody Hero hero)
    {
        heroRepository.insert(hero);
        return hero;
    }

    @PutMapping(path = "/update")
    public Optional updateHero(@RequestBody Hero hero)
    {
        heroRepository.save(hero);
        return heroRepository.findById(hero.getId());
    }

    @DeleteMapping(path = "/delete/{id}")
    public List<Hero> delete(@PathVariable String id)
    {
        heroRepository.deleteById(id);
        return heroRepository.findAll();
    }
}
