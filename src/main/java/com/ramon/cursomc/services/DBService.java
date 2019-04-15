package com.ramon.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
import com.ramon.cursomc.domain.enums.Perfil;
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

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
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
	
	
	public void instatiateTestDataBase() throws ParseException {
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
		
		Produto p12 = new Produto(null, "Produto 12", 10.00);
		Produto p13 = new Produto(null, "Produto 13", 10.00);
		Produto p14 = new Produto(null, "Produto 14", 10.00);
		Produto p15 = new Produto(null, "Produto 15", 10.00);
		Produto p16 = new Produto(null, "Produto 16", 10.00);
		Produto p17 = new Produto(null, "Produto 17", 10.00); 
		Produto p18 = new Produto(null, "Produto 18", 10.00);
		Produto p19 = new Produto(null, "Produto 19", 10.00);
		Produto p20 = new Produto(null, "Produto 20", 10.00);
		Produto p21 = new Produto(null, "Produto 21", 10.00);
		Produto p22 = new Produto(null, "Produto 22", 10.00);
		Produto p23 = new Produto(null, "Produto 23", 10.00);
		Produto p24 = new Produto(null, "Produto 24", 10.00);
		Produto p25 = new Produto(null, "Produto 25", 10.00);
		Produto p26 = new Produto(null, "Produto 26", 10.00);
		Produto p27 = new Produto(null, "Produto 27", 10.00);
		Produto p28 = new Produto(null, "Produto 28", 10.00);
		Produto p29 = new Produto(null, "Produto 29", 10.00);
		Produto p30 = new Produto(null, "Produto 30", 10.00);
		Produto p31 = new Produto(null, "Produto 31", 10.00);
		Produto p32 = new Produto(null, "Produto 32", 10.00);
		Produto p33 = new Produto(null, "Produto 33", 10.00);
		Produto p34 = new Produto(null, "Produto 34", 10.00);
		Produto p35 = new Produto(null, "Produto 35", 10.00); 
		Produto p36 = new Produto(null, "Produto 36", 10.00);
		Produto p37 = new Produto(null, "Produto 37", 10.00); 
		Produto p38 = new Produto(null, "Produto 38", 10.00); 
		Produto p39 = new Produto(null, "Produto 39", 10.00); 
		Produto p40 = new Produto(null, "Produto 40", 10.00);
		Produto p41 = new Produto(null, "Produto 41", 10.00);
		Produto p42 = new Produto(null, "Produto 42", 10.00);
		Produto p43 = new Produto(null, "Produto 43", 10.00);
		Produto p44 = new Produto(null, "Produto 44", 10.00);
		Produto p45 = new Produto(null, "Produto 45", 10.00);
		Produto p46 = new Produto(null, "Produto 46", 10.00); 
		Produto p47 = new Produto(null, "Produto 47", 10.00);
		Produto p48 = new Produto(null, "Produto 48", 10.00); 
		Produto p49 = new Produto(null, "Produto 49", 10.00); 
		Produto p50 = new Produto(null, "Produto 50", 10.00); 
		 
		cat1.getProdutos().add(p12);
		cat1.getProdutos().add(p13);
		cat1.getProdutos().add(p14);
		cat1.getProdutos().add(p15);
		cat1.getProdutos().add(p16);
		cat1.getProdutos().add(p17);
		cat1.getProdutos().add(p18);
		cat1.getProdutos().add(p19);
		cat1.getProdutos().add(p20);
		cat1.getProdutos().add(p21);
		cat1.getProdutos().add(p22);
		cat1.getProdutos().add(p23);
		cat1.getProdutos().add(p24);
		cat1.getProdutos().add(p25);
		cat1.getProdutos().add(p26);
		cat1.getProdutos().add(p27);
		cat1.getProdutos().add(p28);
		cat1.getProdutos().add(p29);
		cat1.getProdutos().add(p30);
		cat1.getProdutos().add(p31);
		cat1.getProdutos().add(p32);
		cat1.getProdutos().add(p33);
		cat1.getProdutos().add(p34);
		cat1.getProdutos().add(p35);
		cat1.getProdutos().add(p36);
		cat1.getProdutos().add(p37);
		cat1.getProdutos().add(p38);
		cat1.getProdutos().add(p39);
		cat1.getProdutos().add(p40);
		cat1.getProdutos().add(p41);
		cat1.getProdutos().add(p42);
		cat1.getProdutos().add(p43);
		cat1.getProdutos().add(p44);
		cat1.getProdutos().add(p45);
		cat1.getProdutos().add(p46);
		cat1.getProdutos().add(p47);
		cat1.getProdutos().add(p48);
		cat1.getProdutos().add(p49);
		cat1.getProdutos().add(p50);
		 
		 
		p12.getCategorias().add(cat1);
		p13.getCategorias().add(cat1);
		p14.getCategorias().add(cat1);
		p15.getCategorias().add(cat1);
		p16.getCategorias().add(cat1);
		p17.getCategorias().add(cat1);
		p18.getCategorias().add(cat1);
		p19.getCategorias().add(cat1);
		p20.getCategorias().add(cat1);
		p21.getCategorias().add(cat1);
		p22.getCategorias().add(cat1);
		p23.getCategorias().add(cat1);
		p24.getCategorias().add(cat1); 
		p25.getCategorias().add(cat1);
		p26.getCategorias().add(cat1);
		p27.getCategorias().add(cat1);
		p28.getCategorias().add(cat1);
		p29.getCategorias().add(cat1);
		p30.getCategorias().add(cat1); 
		p31.getCategorias().add(cat1);
		p32.getCategorias().add(cat1);
		p33.getCategorias().add(cat1);
		p34.getCategorias().add(cat1);
		p35.getCategorias().add(cat1);
		p36.getCategorias().add(cat1);
		p37.getCategorias().add(cat1);
		p38.getCategorias().add(cat1);
		p39.getCategorias().add(cat1);
		p40.getCategorias().add(cat1);
		p41.getCategorias().add(cat1);
		p42.getCategorias().add(cat1);
		p43.getCategorias().add(cat1); 
		p44.getCategorias().add(cat1);
		p45.getCategorias().add(cat1);
		p46.getCategorias().add(cat1); 
		p47.getCategorias().add(cat1);
		p48.getCategorias().add(cat1);
		p49.getCategorias().add(cat1);
		p50.getCategorias().add(cat1); 
		
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
		
		//produtoRepository.save(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		produtoRepository.save(p12);
		produtoRepository.save(p13);
		produtoRepository.save(p14);
		produtoRepository.save(p15);
		produtoRepository.save(p16);
		produtoRepository.save(p17);
		produtoRepository.save(p18);
		produtoRepository.save(p19);
		produtoRepository.save(p20);
		produtoRepository.save(p21);
		produtoRepository.save(p22);
		produtoRepository.save(p23);
		produtoRepository.save(p24);
		produtoRepository.save(p25);
		produtoRepository.save(p26);
		produtoRepository.save(p27);
		produtoRepository.save(p28);
		produtoRepository.save(p29);
		produtoRepository.save(p30);
		produtoRepository.save(p31);
		produtoRepository.save(p32);
		produtoRepository.save(p33);
		produtoRepository.save(p34);
		produtoRepository.save(p35);
		produtoRepository.save(p36);
		produtoRepository.save(p37);
		produtoRepository.save(p38);
		produtoRepository.save(p39);
		produtoRepository.save(p40);
		produtoRepository.save(p41);
		produtoRepository.save(p42);
		produtoRepository.save(p43);
		produtoRepository.save(p44);
		produtoRepository.save(p45);
		produtoRepository.save(p46);
		produtoRepository.save(p47);
		produtoRepository.save(p48);
		produtoRepository.save(p49);
		produtoRepository.save(p50);
		
		
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
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "devramontest@gmail.com", "45346333564", TipoCliente.PESSOAFISICA, pe.encode("123"));
		//cli1.getTelefones().addAll(Arrays.asList("234231144","32523423"));
		cli1.getTelefones().add("222222222");
		cli1.getTelefones().add("333333333");
		
		Cliente cli2 = new Cliente(null, "Ana Aninha", "ramonfernandes9@gmail.com", "53866524005", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli2.getTelefones().add("555555555");
		cli2.getTelefones().add("777777777");
		cli2.addPerfil(Perfil.ADMIN);
		
		
		Endereco e1 = new Endereco(null, "Rua Flores", "342", "Apto 32", "Jardim", "65150-000", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Pr. Cícero", "100", "casa 05", "Vila Formosa", "2390-400", cli1, c2);
		Endereco e3 = new Endereco(null, "Av. Lisboa", "232", "casa 24", "São Mathaus", "1212-4343", cli2, c2);
		
		//cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli1.getEnderecos().add(e1);
		cli1.getEnderecos().add(e2);
		cli2.getEnderecos().add(e3);
		
		clienteRepository.save(cli1);
		clienteRepository.save(cli2);
		enderecoRepository.save(e1);
		enderecoRepository.save(e2);
		enderecoRepository.save(e3);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2018 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2018 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/03/2018 00:00"), null);
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
