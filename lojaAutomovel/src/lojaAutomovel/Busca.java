package lojaAutomovel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.Scanner;

import lojaAutomovel.conexao.*;

public class Busca {
	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost/AutoVendas"; // URL do banco de dados
			String user = "root"; //nome do usu�rio do banco
			String password = ""; //senha do usu�rio no banco
			Connection conn = DriverManager.getConnection(url, user, password);
			// Define a consulta
			String sql = "select * from cliente where cpf=?";
			// Prepara a consulta
			PreparedStatement ps = conn.prepareStatement(sql);
			// Obt�m n�mero da ag�ncia a ser pesquisada
			Scanner sc = new Scanner(System.in);
			System.out.print("Entre com o n�mero do CPF do cliente: ");
			String codigoPesquisa = sc.nextLine();
			ps.setString(1, codigoPesquisa);	// Substitui o primeiro par�metro da consulta pela ag�ncia informada	
			// Executa a consulta, resultando em um objeto da classe ResultSet
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) { // Verifica se n�o est� antes do primeiro registro
				System.out.println("N�o foram encontrados registros!");
			}
			else
			{
				// Efetua a leitura dos registros da tabela
				int totalRegistros = 0;
				while (rs.next()) {
					String cpf = rs.getString("cpf");
					String nome  = rs.getString("nome");
				    String cidade = rs.getString("cidade");
				    String estado = rs.getString("estado");
				    // Apresenta os valores dos campos da tabela
				    System.out.println("N�mero do registro = " + rs.getRow());
				    System.out.println("cpf:    " + cpf);
				    System.out.println("nome:   " + nome);
				    System.out.println("cidade: " + cidade);
				    System.out.println("estado: " + nome);
				    System.out.println();
				    totalRegistros++;
				}
				System.out.println("Total de registros = " + totalRegistros);
			}
			sc.close();
		} catch (Exception erro) {
			System.out.println("Erro: " + erro.toString());
		}
	}
}
