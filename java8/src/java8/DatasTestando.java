package java8;

import java.time.LocalDate;
import java.time.Month;

public class DatasTestando {
	
	public static void main(String[] args) {
		/*
		 * Nessa classe imprima a data atual utilizando a classe LocalDate.
		 */
		LocalDate dataAtual = LocalDate.now();
		System.out.println(dataAtual);
		
		/*
		 * Crie um LocalDate para representar o dia 25 de Janeiro de 2099.
		 * Que método você utilizou pra fazer isso? Quais outras opções você tinha?
		 */
		
		LocalDate data = LocalDate.of(2099, 1, 25);
		System.out.println(data);
		
		LocalDate datas = LocalDate.of(2099, Month.JANUARY, 25);
		System.out.println(datas);
		
	}

}
