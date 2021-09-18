package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.IProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {

	@Autowired
	IProdutoRepository pr;
	
	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista de produtos")
	public List<Produto> listarProduto()
	{
		return pr.findAll();
	}
	
	@GetMapping("/produtos/{id}")
	@ApiOperation(value = "Retorna um produto por ID")
	public Produto listarProdutoPorId(@PathVariable(value = "id") long id)
	{
		return pr.findById(id);
	}
	
	@PostMapping("/produtos")
	@ApiOperation(value = "Salva um produto")
	public Produto salvarProduto(@RequestBody Produto produto)
	{
		return pr.save(produto);
	}
	@DeleteMapping("/produtos")
	@ApiOperation(value = "Deleta um produto")
	public void deletarProduto(@RequestBody Produto produto)
	{
		pr.delete(produto);
	}
	@PutMapping("/produtos")
	@ApiOperation(value = "Atualiza um produto")
	public Produto atualizarProduto(@RequestBody Produto produto)
	{
		return pr.save(produto);
	}
	
}
