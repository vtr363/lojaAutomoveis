package lojaAutomovel;

import java.util.Scanner;

import lojaAutomovel.conexao.*;

public class Teste {
	public static void main(String[] args) {
		Automovel  automovel = new Automovel();
		Scanner sc = new Scanner(System.in);
		
		int codigo;
		String fabricante;
		String modelo;
		
		System.out.println("Digite o codigo");
		codigo = Integer.parseInt(sc.nextLine());
		
		
		
		if (automovel.consultar(codigo)) {
			
			System.out.println("veiculo encontrado");
			System.out.println(automovel.getFabricante());
			System.out.println(automovel.getModelo());
			System.out.println(automovel.getPreco());
			
		}
		
		sc.close();
	}
}

