package AtividadeAula20201016;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import net.bytebuddy.asm.Advice.This;

@Component
public class AnimeRepositoryInMemory {
    private Map<String, Anime> dados = new HashMap<>();
    
    public AnimeRepositoryInMemory() {
        Anime MahoukaKoukoNoRettousei = new Anime("84c4454f-e7bc-48b8-b72c-3c22351edd54","Mahouka Kouko No Rettousei",2014, TipoGenero.MAGIC, TipoStudio.MADHOUSE);
        Anime MyHeroAcademy = new Anime("0c8f00ce-e3c5-4d00-8620-32a342a8f435","Boku no Hero Academia",2016,TipoGenero.SHOUNEN,TipoStudio.BONES);
        dados.put(MahoukaKoukoNoRettousei.getId(), MahoukaKoukoNoRettousei);
        dados.put(MyHeroAcademy.getId(), MyHeroAcademy);
    }

	public List<Anime> findAll() {
		return new ArrayList<>(dados.values());
	}

	public void save(Anime newInstance) {
        if (dados.containsKey(newInstance.getId())) {
            throw new RuntimeException("ID duplicado! Já existe um anime com o id [" + newInstance.getId() + "]");
        }
        dados.put(newInstance.getId(), newInstance);
	}

	public void deleteById(String id) {
        if (!dados.containsKey(id)) {
            throw new RuntimeException("Não existe um anime com o id ( " + id + " )");
        }
        dados.remove(id);
	}

	public Anime findById(String id) {
        if (!dados.containsKey(id)) {
            throw new RuntimeException("Não existe um anime com o id ( " + id + " )");
        }
		return dados.get(id);
	}

	public void update(Anime updatedInstance) {
        if (!dados.containsKey(updatedInstance.getId())) {
            throw new RuntimeException("Não existe um anime com o id [" + updatedInstance.getId() + "]");
        }
        dados.remove(updatedInstance.getId());
        dados.put(updatedInstance.getId(), updatedInstance);
	}

}