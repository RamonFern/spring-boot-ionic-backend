package com.ramon.cursomc;

import java.util.ArrayList;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ramon.cursomc.domain.Categoria;
import com.ramon.cursomc.domain.Cidade;
import com.ramon.cursomc.domain.Cliente;
import com.ramon.cursomc.domain.Endereco;
import com.ramon.cursomc.domain.Estado;
import com.ramon.cursomc.domain.Produto;
import com.ramon.cursomc.domain.enums.TipoCliente;
import com.ramon.cursomc.repositories.CategoriaRepository;
import com.ramon.cursomc.repositories.CidadeRepository;
import com.ramon.cursomc.repositories.ClienteRepository;
import com.ramon.cursomc.repositories.EnderecoRepository;
import com.ramon.cursomc.repositories.EstadoRepository;
import com.ramon.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().add(p1);
		cat1.getProdutos().add(p2);
		cat1.getProdutos().add(p3);
		//cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().add(p2);
		
		p1.getCategorias().add(cat1);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat2);
		p3.getCategorias().add(cat1);
		
		categoriaRepository.save(cat1);
		categoriaRepository.save(cat2);
	     //categoriaRepository.save(Arrays.asList(cat1, cat2));
		
		produtoRepository.save(p1);
		produtoRepository.save(p2);
		produtoRepository.save(p3);
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().add(c1);
		est2.getCidades().add(c2);
		est2.getCidades().add(c3);
		
		estadoRepository.save(est1);
		estadoRepository.save(est2);
		
		cidadeRepository.save(c1);
		cidadeRepository.save(c2);
		cidadeRepository.save(c3);
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "45346333564", TipoCliente.PESSOAFISICA);
		
		//cli1.getTelefones().addAll(Arrays.asList("234231144","32523423"));
		cli1.getTelefones().add("222222222");
		cli1.getTelefones().add("333333333");
		
		Endereco e1 = new Endereco(null, "Rua Flores", "342", "Apto 32", "Jardim", "65150-000", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Pr. Cícero", "100", "casa 05", "Vila Formosa", "2390-400", cli1, c2);
		
		//cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli1.getEnderecos().add(e1);
		cli1.getEnderecos().add(e2);
		
		clienteRepository.save(cli1);
		enderecoRepository.save(e1);
		enderecoRepository.save(e2);
		
	}
}
