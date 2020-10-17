package AtividadeAula20201016;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Anime{
    private String id;
    private String titulo;
    private int anoLancamento;
    private TipoGenero genero;
    private TipoStudio studio;

    public Anime(String titulo, int anoLancamento, TipoGenero genero, TipoStudio TipoStudio) {
        this();
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.studio = TipoStudio;
    }

    public Anime(String id, String titulo, int anoLancamento,  TipoGenero genero, TipoStudio TipoStudio) {
        this(titulo, anoLancamento, genero, TipoStudio);
        this.id = id;
	}
    
    public String getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public TipoGenero getGenero() {
		return genero;
	}

	public TipoStudio getStudio() {
		return studio;
	}

	public Anime() {
        id = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Anime)) {
            return false;
        }
        Anime Anime = (Anime) o;
        return Objects.equals(id, Anime.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
}
