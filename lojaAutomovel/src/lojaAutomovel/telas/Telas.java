package lojaAutomovel.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Telas {
	public static void apresentarMenu() {
		//configura janela principal
		JFrame janelaPrincipal = new JFrame("Cadastro de conta");
		janelaPrincipal.setTitle("Auto Vendas");
		janelaPrincipal.setResizable(false);
		janelaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janelaPrincipal.setSize(400, 300);
		
		//botões
		JButton botaoNegocios = new JButton("Negocios");
		JButton botaoClientes = new JButton("Clientes");
		JButton botaoFuncionarios = new JButton("Funcionarios");
		
		janelaPrincipal.add(botaoNegocios);
		janelaPrincipal.add(botaoClientes);
		janelaPrincipal.add(botaoFuncionarios);
	}
}
