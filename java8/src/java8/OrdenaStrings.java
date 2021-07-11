package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora cada do codigo");
		palavras.add("caelum");

		// - Agora vamos fazer o comparator como classe anonima
//		Comparator<String> comparador = new ComparadorPorTamanho();

//		Collections.sort(palavras, comparador);
		/*
		 * A partir do Java 8 interfaces começaram a ter metodos concretos, metodos com
		 * corpo chamados "default metodos" no List foi adicionado o metodo sort
		 */
		// - palavras.sort(comparador);

		// utilizando classe anonima para usar a interface Comparator
		palavras.sort(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if (s1.length() < s2.length())
					return -1;
				if (s1.length() > s2.length())
					return 1;
				return 0;
			}

		});

		// Lambda equivalente a classe anonima Comparator
		palavras.sort((s1, s2) -> {

			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;
			return 0;
		});

		/*
		 *  Outra forma de utilizar o sort
		 *  - Principio basico do Lambdas
		 *  Lambdas pode ser convertido para uma interface funcional
		 */
		palavras.sort((s1, s2) -> 
			Integer.compare(s1.length(), s2.length()));

		/*
		 * Palavras ordene comparando o tamanho da string
		 */
		
//		palavras.sort(Comparator.comparing(s -> s.length()));
//		// metodo reference é um lambda mais enxuto
//		palavras.sort(Comparator.comparing(String::length));
		
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		
		// Lambda
//		Function<String, Integer> funcao = s -> s.length();
		
		
		
		//3 linhas passo a passo sem lambda
		Function<String, Integer> funcao = new Function<String, Integer>(){

			@Override
			public Integer apply(String s) {
				return s.length();
			}
			
		};
		
		Function<String, Integer> funcao2 = s -> s.length();
		
		Comparator<String> comparador = Comparator.comparing(funcao);
		palavras.sort(comparador);
		
		/*
		 * Lambda funciona quando temos um metodo abistrato chamado Interface Funcional
		 */

		System.out.println(palavras);
		
//		Consumer<String> impressor = s -> System.out.println(s);
		Consumer<String> impressor = System.out::println;
//		palavras.forEach(impressor);
		palavras.forEach(System.out::println);
		
		/*
		 * Para uma expressão Lambda se encaixar no codigo e necessário um interface funcional compativel
		 * essa interface precisa ter uma metodo que recebe argumentos e retorna parametros compativel a expressão lambda
		 * que recebe argumentos e retorna parametros
		 */
		
//		for (String p : palavras) {
//			System.out.println(p);
//		}

//		Consumer<String> consumidor = new ImprimeNaLinha();

		/*
		 * Na pratica no dia a dia usamos a sintaxe classe anonima, damos new direto na
		 * interface,
		 */
//		Consumer<String> consumidor = new Consumer<String>() {
//
//			@Override
//			public void accept(String s) {
//				System.out.println(s);
//				
//			}
//		};

		// Não podemos usar muito classe anonima pois fica ilegivel o código
//		palavras.forEach(new Consumer<String>() {
//
//			@Override
//			public void accept(String s) {
//				System.out.println(s);
//				
//			}
//		});

		// Usando lambda e similar ao codigo de cima
		palavras.forEach((String s) -> {
			System.out.println(s);
		});

		// Simplificando mais

	}

}

/*
 * Quando temos uma classe pequena, que implementa duas linhas de codigo e não
 * reaproveitamos em outro lugar usamos classes anonimas
 * 
 * - Consumer e Comparator são interfaces
 */

//class ImprimeNaLinha implements Consumer<String> {
//
//	@Override
//	public void accept(String s) {
//		System.out.println(s);
//
//	}
//
//}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}

}