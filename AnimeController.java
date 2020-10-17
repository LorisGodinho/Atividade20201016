package AtividadeAula20201016;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Animes")
public class AnimeController {
    @Autowired
    private AnimeRepositoryInMemory repo;

    @GetMapping
    public List<Anime> getAll() {
        return repo.findAll();
    }

    @PostMapping 
    public String post(@RequestBody Anime nova) {
        repo.save(nova);
        return nova.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        repo.deleteById(id);
    }

    @GetMapping("/{id}")
    public Anime getById(@PathVariable("id") String id) {
        return repo.findById(id);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable("id") String id, @RequestBody Anime camera) {
        if (!id.equals(camera.getId())) {
            throw new RuntimeException("IDs da URL e do objeto não conferem!");
        }
        repo.update(camera);
    }


    
}
