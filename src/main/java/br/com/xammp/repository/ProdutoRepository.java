package br.com.xammp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.xammp.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	List<Produto> findByNomeContainingIgnoreCase(String nome);
}


//Por que tem que ser uma interface e não uma classe aqui??