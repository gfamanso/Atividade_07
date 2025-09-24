import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryRepository<T extends Identificavel<ID>, ID> implements IRepository<T, ID> {

    private final Map<ID, T> bancoDeDados = new HashMap<>();

    @Override
    public void salvar(T entidade) {
        bancoDeDados.put(entidade.getId(), entidade);
        System.out.println("Entidade com ID " + entidade.getId() + " salva com sucesso.");
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        return Optional.ofNullable(bancoDeDados.get(id));
    }

    @Override
    public List<T> listarTodos() {
        // Devolve uma cópia imutável da lista para evitar modificações externas
        return Collections.unmodifiableList(new ArrayList<>(bancoDeDados.values()));
    }

    @Override
    public void remover(ID id) {
        if (bancoDeDados.remove(id) == null) {
            throw new EntidadeNaoEncontradaException("ID " + id + " não encontrado.");
        }
        System.out.println("Entidade com ID " + id + " removida com sucesso.");
    }
}