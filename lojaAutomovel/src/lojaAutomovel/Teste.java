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
		fabricante = sc.nextLine();
		modelo = sc.nextLine();
		
		
		if (automovel.consultarAuto(codigo, fabricante, modelo)) {
			System.out.println("veiculo encontrado");
		}
		
		sc.close();
	}
}
