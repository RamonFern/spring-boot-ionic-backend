package com.ramon.cursomc;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ramon.cursomc.domain.Categoria;
import com.ramon.cursomc.domain.Cidade;
import com.ramon.cursomc.domain.Cliente;
import com.ramon.cursomc.domain.Endereco;
import com.ramon.cursomc.domain.Estado;
import com.ramon.cursomc.domain.ItemPedido;
import com.ramon.cursomc.domain.Pagamento;
import com.ramon.cursomc.domain.PagamentoComBoleto;
import com.ramon.cursomc.domain.PagamentoComCartao;
import com.ramon.cursomc.domain.Pedido;
import com.ramon.cursomc.domain.Produto;
import com.ramon.cursomc.domain.enums.EstadoPagamento;
import com.ramon.cursomc.domain.enums.TipoCliente;
import com.ramon.cursomc.repositories.CategoriaRepository;
import com.ramon.cursomc.repositories.CidadeRepository;
import com.ramon.cursomc.repositories.ClienteRepository;
import com.ramon.cursomc.repositories.EnderecoRepository;
import com.ramon.cursomc.repositories.EstadoRepository;
import com.ramon.cursomc.repositories.ItemPedidoRepository;
import com.ramon.cursomc.repositories.PagamentoRepository;
import com.ramon.cursomc.repositories.PedidoRepository;
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
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "escritório");
		Categoria cat3 = new Categoria(null, "cama mesa banho");
		Categoria cat4 = new Categoria(null, "eletrônicos");
		Categoria cat5 = new Categoria(null, "jardinagem");
		Categoria cat6 = new Categoria(null, "decoração");
		Categoria cat7 = new Categoria(null, "perfumaria");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de Escritorio", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "TV true Color", 12000.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);
		
		cat1.getProdutos().add(p1);
		cat1.getProdutos().add(p2);
		cat1.getProdutos().add(p3);
		//cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().add(p2);
		cat2.getProdutos().add(p4);
		
		cat3.getProdutos().add(p5);
		cat3.getProdutos().add(p6);
		
		cat4.getProdutos().add(p1);
		cat4.getProdutos().add(p2);
		cat4.getProdutos().add(p3);
		cat4.getProdutos().add(p7);
		
		cat5.getProdutos().add(p8);
		
		cat6.getProdutos().add(p9);
		cat6.getProdutos().add(p10);
		
		cat7.getProdutos().add(p11);
		
		
		
		
		p1.getCategorias().add(cat1);
		p1.getCategorias().add(cat4);
		
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat2);
		p2.getCategorias().add(cat4);
		
		p3.getCategorias().add(cat1);
		p3.getCategorias().add(cat4);
		
		p4.getCategorias().add(cat2);
		p5.getCategorias().add(cat3);
		p6.getCategorias().add(cat3);
		p7.getCategorias().add(cat4);
		p8.getCategorias().add(cat5);
		p9.getCategorias().add(cat6);
		p10.getCategorias().add(cat6);
		p11.getCategorias().add(cat7);
		
		categoriaRepository.save(cat1);
		categoriaRepository.save(cat2);
		categoriaRepository.save(cat3);
		categoriaRepository.save(cat4);
		categoriaRepository.save(cat5);
		categoriaRepository.save(cat6);
		categoriaRepository.save(cat7);
	     //categoriaRepository.save(Arrays.asList(cat1, cat2)); 
		
		produtoRepository.save(p1);
		produtoRepository.save(p2);
		produtoRepository.save(p3);
		produtoRepository.save(p4);
		produtoRepository.save(p5);
		produtoRepository.save(p6);
		produtoRepository.save(p7);
		produtoRepository.save(p8);
		produtoRepository.save(p9);
		produtoRepository.save(p10);
		produtoRepository.save(p11);
		
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/03/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		//cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		cli1.getPedidos().add(ped1);
		cli1.getPedidos().add(ped2);
		
		/*
		pedidoRepository.save(Arrays.asList(ped1, ped2));
		pagamentoRepository.save(Arrays.asList(pagto1,pagto2));
		*/
		pedidoRepository.save(ped1);
		pedidoRepository.save(ped2);
		
		pagamentoRepository.save(pagto1);
		pagamentoRepository.save(pagto2);
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		//ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped1.getItens().add(ip1);
		ped1.getItens().add(ip2);
		
		//ped2.getItens().addAll(Arrays.asList(ip3));
		ped2.getItens().add(ip3);
		
		//p1.getItens().addAll(Arrays.asList(ip1));
		p1.getItens().add(ip1);
		//p2.getItens().addAll(Arrays.asList(ip3));
		p2.getItens().add(ip3);
		//p3.getItens().addAll(Arrays.asList(ip2)); 
		p3.getItens().add(ip2);
		
		//itemPedidoRepository.save(Arrays.asList(ip1,ip2,ip3));
		itemPedidoRepository.save(ip1);
		itemPedidoRepository.save(ip2);
		itemPedidoRepository.save(ip3);
		
	}
}
