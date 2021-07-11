package java8;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class OrdenaStringsTestando {
	
	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<String>();
		palavras.add("Para");
		palavras.add("Sempre");
		palavras.add("Exaltado");
		
//		palavras.sort((s1, s2) -> {
//		    return Integer.compare(s1.length(), s2.length()); 
//		});
		
//		palavras.sort(Comparator.comparing(s -> s.length()));
//		palavras.sort(Comparator.comparing(String::length));
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		System.out.println(palavras);

		palavras.forEach((String s ) -> {
			System.out.println(s);
		});
		
		palavras.forEach(s -> System.out.println(s));
		palavras.forEach(System.out::println);
		
		
//		
//		Function<String, Integer> funcao = s -> s.length();
//		
//		Comparator<String> comparador = Comparator.comparing(funcao);
//		palavras.sort(comparador);
	}
	
	
	
	
	
}
