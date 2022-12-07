package lojaAutomovel.telas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.ClosedByInterruptException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import lojaAutomovel.conexao.Cliente;
import lojaAutomovel.conexao.Funcionario;
import lojaAutomovel.conexao.Automovel;
import lojaAutomovel.conexao.Negocio;


public class Telas {
	
	//Janela principal
	public static void apresentarMenu() {
		//configura janela principal
		JFrame janelaPrincipal = new JFrame("Cadastro de conta");
		janelaPrincipal.setTitle("Auto Vendas");
		janelaPrincipal.setResizable(false);
		janelaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janelaPrincipal.setSize(800, 600);
		
		// Cria uma barra de menu para a janela principal
		JMenuBar menuBar = new JMenuBar();
		// Adiciona a barra de menu ao frame
		janelaPrincipal.setJMenuBar(menuBar);
		// Define e adiciona menu na barra de menu
		
		JMenu menuAutomoveis = new JMenu("Automoveis");
		JMenu menuClientes = new JMenu("Clientes");
		JMenu menuFuncionarios = new JMenu("Funcionarios");
		
			menuBar.add(menuAutomoveis);
			menuBar.add(menuClientes);
			menuBar.add(menuFuncionarios);
			
		JMenuItem mAuto = new JMenuItem("Automoveis ");
		JMenuItem mClientes = new JMenuItem("Clientes ");
		JMenuItem mFuncionarios = new JMenuItem("Funcionarios ");
		
		menuAutomoveis.add(mAuto);
		menuClientes.add(mClientes);
		menuFuncionarios.add(mFuncionarios);

		JFrame janelaAutomovel = CriarJanelaAutomoveis();
		JFrame janelaClientes = criarJanelaClientes();
		JFrame janelaFuncionarios = criarJanelaFuncionarios();
		
		mAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				janelaAutomovel.setVisible(true);
			}
		});
		mClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				janelaClientes.setVisible(true);
			}
		});
		mFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				janelaFuncionarios.setVisible(true);
			}
		});
		
		
		janelaPrincipal.setVisible(true);
		
	}
	
	//Janela automoveis
	public static JFrame CriarJanelaAutomoveis () {
		// Define a janela
				JFrame janelaAutomoveis = new JFrame("Automoveis"); // Janela Normal
				janelaAutomoveis.setResizable(false); // A janela não poderá ter o tamanho ajustado
				janelaAutomoveis.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				janelaAutomoveis.setSize(500, 360); // Define tamanho da janela
				
				// Define o layout da janela
				Container caixa = janelaAutomoveis.getContentPane();
				caixa.setLayout(null);
				
				// Define os labels dos campos
					JLabel labelCodigo      = new JLabel("Codigo: ");
					JLabel labelFabricante  = new JLabel("Fabricante: ");
					JLabel labelModelo      = new JLabel("Modelo: ");
					JLabel labelPreco       = new JLabel("Preco: ");
				
				// Posiciona os labels na janela
					labelCodigo.setBounds		(50, 40,  100, 20); // coluna, linha, largura, tamanho
					labelFabricante.setBounds	(50, 70,  100, 20); // coluna, linha, largura, tamanho
					labelModelo.setBounds		(50, 100, 100, 20);
					labelPreco.setBounds		(50, 130, 100, 20);
				
				// Define os input box
					JTextField jTextcodigo     = new JTextField();
					JTextField jTextfabricante = new JTextField();
					JTextField jTextmodelo     = new JTextField();
					JTextField jTextpreco      = new JTextField();
				
				// Define se os campos estão habilitados ou não no início
					jTextcodigo.setEnabled(true);
					jTextfabricante.setEnabled(true);
					jTextmodelo.setEnabled(true);
					jTextpreco.setEnabled(true);
				
				// Posiciona os input box
					jTextcodigo.setBounds     (120, 40  , 160, 20);
					jTextfabricante.setBounds (120, 70  , 160, 20);
					jTextmodelo.setBounds     (120, 100 , 160, 20);
					jTextpreco.setBounds      (120, 130 , 160, 20);
				
				// Adiciona os rótulos e os input box na janela
					janelaAutomoveis.add(labelCodigo);
					janelaAutomoveis.add(labelFabricante);
					janelaAutomoveis.add(labelModelo);
					janelaAutomoveis.add(labelPreco);
					janelaAutomoveis.add(jTextcodigo);
					janelaAutomoveis.add(jTextfabricante);
					janelaAutomoveis.add(jTextmodelo);
					janelaAutomoveis.add(jTextpreco);
					
				// Define botões e a localização deles na janela	
					JButton botaoConsultar = new JButton("Consultar");
					botaoConsultar.setBounds(300, 40, 100, 20);
					janelaAutomoveis.add(botaoConsultar);	
					
					JButton botaoAtualizar = new JButton("Atualizar");
					botaoAtualizar.setBounds(300, 70, 100, 20);
					janelaAutomoveis.add(botaoAtualizar);	
					
					JButton botaoCadastrar = new JButton("Cadastrar");
					botaoCadastrar.setBounds(300, 100, 100, 20);
					janelaAutomoveis.add(botaoCadastrar);
					
					JButton botaoVender = new JButton("Vender");
					botaoVender.setBounds(300, 130, 100, 20);
					janelaAutomoveis.add(botaoVender);
					
					Automovel automovel = new Automovel();
					
					botaoConsultar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								if(!automovel.consultarAuto(Integer.parseInt(jTextcodigo.getText()))) {
									JOptionPane.showMessageDialog(janelaAutomoveis,
											"Automovel não encontrado, tente novamente.");
								}else {
									
									jTextcodigo.setText(Integer.toString(automovel.getCodigo()));
									jTextfabricante.setText(automovel.getFabricante());
									jTextmodelo.setText(automovel.getModelo());
									jTextpreco.setText(Double.toString(automovel.getPreco()));
									JOptionPane.showMessageDialog(janelaAutomoveis,
											"Automovel encontrado!");
								}
								
							} catch (Exception e2) {
								// TODO: handle exception
							}
						}
					});
					
					botaoAtualizar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								if(!automovel.atualizarAuto(Integer.parseInt(jTextcodigo.getText()) ,jTextfabricante.getText(), jTextmodelo.getText(), Double.parseDouble(jTextpreco.getText()))) {
									JOptionPane.showMessageDialog(janelaAutomoveis, "Não foi possivel atualizar o cliente");
								}else {
									JOptionPane.showMessageDialog(janelaAutomoveis, "Atualização realizada");
								}
								
							} catch (Exception e2) {
								// TODO: handle exception
							}
						}
					});
					
					botaoCadastrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								if(!automovel.consultarAuto(Integer.parseInt(jTextcodigo.getText()))) {
									automovel.cadastrarAuto(Integer.parseInt(jTextcodigo.getText()), jTextfabricante.getText(), jTextmodelo.getText(), Double.parseDouble(jTextpreco.getText()));
								}else {
									JOptionPane.showMessageDialog(janelaAutomoveis, "Veiculo já cadastrado");
								}
							} catch (Exception e2) {
								// TODO: handle exception
							}
						}
					});
					Negocio negocio = new Negocio();
					botaoVender.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (automovel.consultarAuto(Integer.parseInt(jTextcodigo.getText()))){
									if(!negocio.consultarNegocio(jTextcodigo.getText())) {
										JFrame janelaVenda = CriarJanelaVenda(automovel);
										janelaVenda.setVisible(true);
									}else {
										JOptionPane.showMessageDialog(janelaAutomoveis, "Veiculo indisponível");
									}
							}else {
								JOptionPane.showMessageDialog(janelaAutomoveis, "Veiculo Não encontrado");
							}
						}

					});
		
				return janelaAutomoveis;
	}
	//Janela venda
	public static JFrame CriarJanelaVenda(Automovel automovel){
		JFrame janelaVenda = new JFrame("Venda"); // Janela Normal
		janelaVenda.setResizable(false); // A janela não poderá ter o tamanho ajustado
		janelaVenda.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		janelaVenda.setSize(500, 360); // Define tamanho da janela
		
		// Define o layout da janela
		Container caixa = janelaVenda.getContentPane();
		caixa.setLayout(null);
		
		// Define os labels dos campos
			JLabel labelCpf      = new JLabel("CPF Cliente: ");
			JLabel labelMatricula  = new JLabel("Mat.Vendedor: ");
			JLabel labelCodigo     = new JLabel("Cod. Veiculo: ");
			JLabel labelPreco       = new JLabel("Preco: ");
			JLabel labelData = new JLabel("Data: ");
		
		// Posiciona os labels na janela
			labelCpf.setBounds		(50, 40,  120, 20); // coluna, linha, largura, tamanho
			labelMatricula.setBounds	(50, 70,  120, 20); // coluna, linha, largura, tamanho
			labelCodigo.setBounds		(50, 100, 120, 20);
			labelPreco.setBounds		(50, 130, 120, 20);
			labelData.setBounds		(50, 160, 120, 20);
			
		// Define os input box
			JTextField jTextCpf     = new JTextField();
			JTextField jTextMatricula = new JTextField();
			JTextField jTextCodigo     = new JTextField();
			JTextField jTextPreco      = new JTextField();
			JTextField jTextData = new JTextField();
		
		// Define se os campos estão habilitados ou não no início
			jTextCpf.setEnabled(true);
			jTextMatricula.setEnabled(true);
			jTextCodigo.setEnabled(true);
			jTextPreco.setEnabled(true);
		
		// Posiciona os input box
			jTextCpf.setBounds     (160, 40  , 160, 20);
			jTextMatricula.setBounds (160, 70  , 160, 20);
			jTextCodigo.setBounds     (160, 100 , 160, 20);
			jTextPreco.setBounds      (160, 130 , 160, 20);
			jTextData.setBounds			(160, 160 , 160, 20);
		
		// Adiciona os rótulos e os input box na janela
			janelaVenda.add(labelCpf);
			janelaVenda.add(labelMatricula);
			janelaVenda.add(labelCodigo);
			janelaVenda.add(labelPreco);
			janelaVenda.add(jTextCpf);
			janelaVenda.add(jTextMatricula);
			janelaVenda.add(jTextCodigo);
			janelaVenda.add(jTextPreco);
			janelaVenda.add(labelData);
			janelaVenda.add(jTextData);
			
			jTextCodigo.setText(Integer.toString(automovel.getCodigo()));
			
			JButton botaoConfirmacaoButton = new JButton();
			
			Cliente cliente = new Cliente();
			Funcionario funcionario = new Funcionario();
			Negocio negocio = new Negocio();

			botaoConfirmacaoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(cliente.consultarCliente(jTextCpf.getText())) {
							if(funcionario.consultarFuncionario(jTextMatricula.getText())) {
								negocio.cadastrarNegocio(jTextCpf.getText(), jTextMatricula.getText(), automovel.getCodigo(), jTextData.getText(), Double.parseDouble(jTextPreco.getText()));
							}else {
								JOptionPane.showMessageDialog(janelaVenda, "Funcionario não encontrado");
							}
						}else {
							JOptionPane.showMessageDialog(janelaVenda, "Cliente não encontrado");
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
			});
			
			
		
		return janelaVenda;
	}
	//Janela Clientes
		public static JFrame criarJanelaClientes () {
			// Define a janelaClientes
					JFrame janelaClientes = new JFrame("Clientes"); // Janela Normal
					janelaClientes.setResizable(false); // A janela não poderá ter o tamanho ajustado
					janelaClientes.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					janelaClientes.setSize(500, 360); // Define tamanho da janela
					
					// Define o layout da janela
					Container caixa = janelaClientes.getContentPane();
					caixa.setLayout(null);
					
					// Define os labels dos campos
						JLabel labelNome      = new JLabel("Nome: ");
						JLabel labelCPF  = new JLabel("CPF: ");
						JLabel labelCidade      = new JLabel("Cidade: ");
						JLabel labelEstado       = new JLabel("Estado: ");
					
					// Posiciona os labels na janela
						labelNome.setBounds		(50, 40,  100, 20); // coluna, linha, largura, tamanho
						labelCPF.setBounds	(50, 70,  100, 20); // coluna, linha, largura, tamanho
						labelCidade.setBounds		(50, 100, 100, 20);
						labelEstado.setBounds		(50, 130, 100, 20);
					
					// Define os input box
						JTextField jTextNome     = new JTextField();
						JTextField jTextCPF = new JTextField();
						JTextField jTextCidade     = new JTextField();
						JTextField jTextEstado      = new JTextField();
					
					// Define se os campos estão habilitados ou não no início
						jTextNome.setEnabled(true);
						jTextCPF.setEnabled(true);
						jTextCidade.setEnabled(true);
						jTextEstado.setEnabled(true);
					
					// Posiciona os input box
						jTextNome.setBounds     (120, 40  , 160, 20);
						jTextCPF.setBounds (120, 70  , 160, 20);
						jTextCidade.setBounds     (120, 100 , 160, 20);
						jTextEstado.setBounds      (120, 130 , 160, 20);
					
					// Adiciona os rótulos e os input box na janela
						janelaClientes.add(labelNome);
						janelaClientes.add(labelCPF);
						janelaClientes.add(labelCidade);
						janelaClientes.add(labelEstado);
						janelaClientes.add(jTextNome);
						janelaClientes.add(jTextCPF);
						janelaClientes.add(jTextCidade);
						janelaClientes.add(jTextEstado);
						
					// Define botões e a localização deles na janela	
						JButton botaoConsultar = new JButton("Consultar");
						botaoConsultar.setBounds(300, 40, 100, 20);
						janelaClientes.add(botaoConsultar);	
						
						JButton botaoAtualizar = new JButton("Atualizar");
						botaoAtualizar.setBounds(300, 70, 100, 20);
						janelaClientes.add(botaoAtualizar);	
						
						JButton botaoCadastrar = new JButton("Cadastrar");
						botaoCadastrar.setBounds(300, 100, 100, 20);
						janelaClientes.add(botaoCadastrar);	
						
						Cliente cliente = new Cliente();
						
						botaoConsultar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									if(!cliente.consultarCliente(jTextCPF.getText())) {
										JOptionPane.showMessageDialog(janelaClientes,
												"Cliente não encontrado, tente novamente.");
									}else {
										
										jTextCidade.setText(cliente.getCidade());
										jTextEstado.setText(cliente.getEstado());
										jTextNome.setText(cliente.getNome());
										JOptionPane.showMessageDialog(janelaClientes,
												"Cliente encontrado!");
									}
									
								} catch (Exception e2) {
									// TODO: handle exception
								}
							}
						});
						
						botaoAtualizar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									if(!cliente.atualizarCliente(jTextNome.getText() ,jTextCPF.getText(), jTextCidade.getText(), jTextEstado.getText())) {
										JOptionPane.showMessageDialog(janelaClientes, "Não foi possivel atualizar o cliente");
									}else {
										JOptionPane.showMessageDialog(janelaClientes, "Atualização realizada");
									}
									
								} catch (Exception e2) {
									// TODO: handle exception
								}
							}
						});
						
						botaoCadastrar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									if(!cliente.consultarCliente(jTextCPF.getText())) {
										cliente.cadastrarCliente(jTextCPF.getText(), jTextNome.getText(), jTextCidade.getText(), jTextEstado.getText());
									}else {
										JOptionPane.showMessageDialog(janelaClientes, "Usuario ja cadastrado");
									}
								} catch (Exception e2) {
									// TODO: handle exception
								}
							}
						});
					return janelaClientes;
		}
		
		//Janela Clientes
				public static JFrame criarJanelaFuncionarios () {
					// Define a janelaClientes
					JFrame janelaFuncionarios = new JFrame("Funcionarios"); // Janela Normal
					janelaFuncionarios.setResizable(false); // A janela não poderá ter o tamanho ajustado
					janelaFuncionarios.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					janelaFuncionarios.setSize(500, 360); // Define tamanho da janela
					
					// Define o layout da janela
					Container caixa = janelaFuncionarios.getContentPane();
					caixa.setLayout(null);
					
					// Define os labels dos campos
						JLabel labelNome = new JLabel("Nome: ");
						JLabel labelCPF = new JLabel("CPF: ");
						JLabel labelMatricula = new JLabel("Matricula: ");
						JLabel labelCargo = new JLabel("Cargo: ");
					
					// Posiciona os labels na janela
						labelNome.setBounds(50, 40,  100, 20); // coluna, linha, largura, tamanho
						labelCPF.setBounds(50, 70,  100, 20); // coluna, linha, largura, tamanho
						labelMatricula.setBounds(50, 100, 100, 20);
						labelCargo.setBounds(50, 130, 100, 20);
					
					// Define os input box
						JTextField jTextNome = new JTextField();
						JTextField jTextCPF = new JTextField();
						JTextField jTextMatricula = new JTextField();
						JTextField jTextCargo = new JTextField();
					
					// Define se os campos estão habilitados ou não no início
						jTextNome.setEnabled(true);
						jTextCPF.setEnabled(true);
						jTextMatricula.setEnabled(true);
						jTextCargo.setEnabled(true);
					
					// Posiciona os input box
						jTextNome.setBounds     (120, 40  , 160, 20);
						jTextCPF.setBounds (120, 70  , 160, 20);
						jTextMatricula.setBounds     (120, 100 , 160, 20);
						jTextCargo.setBounds      (120, 130 , 160, 20);
					
					// Adiciona os rótulos e os input box na janela
						janelaFuncionarios.add(labelNome);
						janelaFuncionarios.add(labelCPF);
						janelaFuncionarios.add(labelMatricula);
						janelaFuncionarios.add(labelCargo);
						janelaFuncionarios.add(jTextNome);
						janelaFuncionarios.add(jTextCPF);
						janelaFuncionarios.add(jTextMatricula);
						janelaFuncionarios.add(jTextCargo);
						
					// Define botões e a localização deles na janela	
						JButton botaoConsultar = new JButton("Consultar");
						botaoConsultar.setBounds(300, 40, 100, 20);
						janelaFuncionarios.add(botaoConsultar);	
						
						JButton botaoAtualizar = new JButton("Atualizar");
						botaoAtualizar.setBounds(300, 70, 100, 20);
						janelaFuncionarios.add(botaoAtualizar);	
						
						JButton botaoCadastrar = new JButton("Cadastrar");
						botaoCadastrar.setBounds(300, 100, 100, 20);
						janelaFuncionarios.add(botaoCadastrar);	
						
						Funcionario funcionario = new Funcionario();
						
						botaoConsultar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									if(!funcionario.consultarFuncionario(jTextMatricula.getText())) {
										JOptionPane.showMessageDialog(janelaFuncionarios,
												"Funcionario não encontrado, tente novamente.");
									}else {
										
										jTextMatricula.setText(funcionario.getMatricula());
										jTextCargo.setText(funcionario.getCargo());
										jTextNome.setText(funcionario.getNome());
										jTextCPF.setText(funcionario.getCpf());
										JOptionPane.showMessageDialog(janelaFuncionarios,
												"Funcionario encontrado!");
									}
									
								} catch (Exception e2) {
									// TODO: handle exception
								}
							}
						});
						
						botaoAtualizar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									if(!funcionario.atualizarFuncionario(jTextNome.getText() ,jTextCPF.getText(), jTextMatricula.getText(), jTextCargo.getText())) {
										JOptionPane.showMessageDialog(janelaFuncionarios, "Não foi possivel atualizar o fincionario");
									}else {
										JOptionPane.showMessageDialog(janelaFuncionarios, "Atualização realizada");
									}
								} catch (Exception e2) {
									// TODO: handle exception
								}
							}
						});
						
						botaoCadastrar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									if(!funcionario.consultarFuncionario(jTextMatricula.getText())) {
										funcionario.cadastrarFuncionario(jTextNome.getText(), jTextCPF.getText(), jTextMatricula.getText(), jTextCargo.getText());
										JOptionPane.showMessageDialog(janelaFuncionarios, "Cadastrado realizado!");
									}else {
										JOptionPane.showMessageDialog(janelaFuncionarios, "Funcionario ja cadastrado");
									}
								} catch (Exception e2) {
									// TODO: handle exception
								}
							}
						});
			
					return janelaFuncionarios;
				}
	
	public static void main(String[] args) {
		apresentarMenu();
		}
	

	}


/*
//botões
JButton botaoNegocios = new JButton("Negocios");
JButton botaoClientes = new JButton("Clientes");
JButton botaoFuncionarios = new JButton("Funcionarios");



botaoNegocios.setBounds(50, 50, 50, 50);
botaoClientes.setBounds(100, 100, 50, 50);
botaoFuncionarios.setBounds(200, 200, 50, 50);

janelaPrincipal.add(botaoNegocios);
janelaPrincipal.add(botaoClientes);
janelaPrincipal.add(botaoFuncionarios);
*/

