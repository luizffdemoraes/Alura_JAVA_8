package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
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

public class ExemploCurso {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
//		cursos.sort(Comparator.comparing(c -> c.getAlunos()));
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		/*
		 *  Metodo references é utilizado quando é um lambda simples
		 *  seria necessário a criação do toString para que ele exibisse o nome 
		 */
//		cursos.forEach(System.out::println);
		
//		cursos.forEach(c -> System.out.println(c.getNome()));
		
		/*
		 * Realizar outras operações funcionalidade de filtro
		 * Stream é uma interface
		 * Tudo que é feito ao utilizar strem não impacta a lista original
		 */
		
		cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
//		.map(c -> c.getAlunos()) lambda
		.map(Curso::getAlunos) //metodo references
//		.forEach(total ->  System.out.println(total)); lambda
		.forEach(System.out::println); //metodo references

		IntStream strem = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.mapToInt(Curso::getAlunos);
		
		// filtramos os que tem mais de 100 e somamos todos os alunos
		int soma = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.mapToInt(Curso::getAlunos)
				.sum();
		
		// retornando media
		OptionalDouble media = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.mapToInt(Curso::getAlunos)
				.average();
		
		System.out.println(soma);
		
		// Optional ajuda a trabalhar com null surgiu no Java 8
		Optional<Curso> optionalCurso = cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.findAny();
		
		Stream<Curso> filter = cursos.stream()
				.filter(c -> c.getAlunos() >= 100);
		
		List<Curso> collect = cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.collect(Collectors.toList());
		
		// Alteração da referencia da collect
		cursos = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.collect(Collectors.toList());
		
		Curso curso = optionalCurso.orElse(null);
		System.out.println(curso.getNome());
		
		optionalCurso.ifPresent(c -> System.out.println(c.getNome()));
		
		cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.findAny()
		.ifPresent(c -> System.out.println(c.getNome()));
		
		Map<String, Integer> map = cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.collect(Collectors.toMap(
				c -> c.getNome(), 
				c -> c.getAlunos())); // toMap chave e valor
		
		System.out.println(map);
		
		
		cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.collect(Collectors.toMap(
				c -> c.getNome(), 
				c -> c.getAlunos()))
		.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos")) ;
		
		cursos.parallelStream()
		.filter(c -> c.getAlunos() >= 100)
		.collect(Collectors.toMap(
				c -> c.getNome(), 
				c -> c.getAlunos()))
		.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos")) ;
	}
}