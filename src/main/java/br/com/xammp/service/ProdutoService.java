package br.com.xammp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.xammp.model.Produto;
import br.com.xammp.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public List<Produto> listarTodos(){
		return produtoRepository.findAll();
	}
	
	public List<Produto> buscarPorNome(String nome){
		return produtoRepository.findByNomeContainingIgnoreCase(nome);
	}
	
	public Produto atualizar(Long id, Produto produtoAtualizado) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto Não encontrado :("));
		produto.setNome(produtoAtualizado.getNome());
		produto.setPreco(produtoAtualizado.getPreco());
		produto.setDescricao(produtoAtualizado.getDescricao());
		return produtoRepository.save(produto);
	}
	
	public void deletar(Long id) {
		produtoRepository.deleteById(id);
	}
}
