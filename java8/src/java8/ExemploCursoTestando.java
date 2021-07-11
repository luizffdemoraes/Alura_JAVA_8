package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Cursos {
	private String nome;
	private int alunos;

	public Cursos(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
}

public class ExemploCursoTestando {
	public static void main(String[] args) {
		List<Cursos> cursos = new ArrayList<Cursos>();
		cursos.add(new Cursos("Python", 45));
		cursos.add(new Cursos("JavaScript", 150));
		cursos.add(new Cursos("Java 8", 113));
		cursos.add(new Cursos("C", 55));
		
		/*
		 * Como você faria pra ordenar essa lista pela quantidade de alunos?
		 * Você pode escolher entre usar um expressão lambda ou method reference.
		 */

//		cursos.sort(Comparator.comparing(c -> c.getNome()));
		cursos.sort(Comparator.comparing(Cursos::getNome));
//		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
		cursos.sort(Comparator.comparingInt(Cursos::getAlunos));

		/*
		 * Utilizando a API de Stream, crie um filtro para todos os cursos que tenham mais de 50 alunos.
		 * Depois disso faça um forEach no resultado. Qual foi a saída do seu código?
		 */
		
		cursos.stream()
		.filter(c -> c.getAlunos() > 50)
		.forEach(c -> System.out.println(c.getNome()));
		
		/*
		 * Como transformar o nosso Stream<Curso> em um Stream<String> 
		 * contendo apenas os nomes dos cursos?
		 */
		cursos.stream()
		.filter(c -> c.getAlunos() > 50)
		.map(c -> c.getNome())
		.forEach(c -> System.out.println(c));
		
		/*
		 * Em que parte desse código podemos tirar proveito da sintaxe de method reference?
		 */
		
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .map(c -> c.getAlunos())
		   .forEach(x -> System.out.println(x));
		
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .map(Cursos::getAlunos)
		   .forEach(System.out::println);
		
		
		   
		/*
		 * Como podemos fazer pra pegar o primeiro elemento desse Stream filtrado?
		 */
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .findFirst();
		
		
	}
}