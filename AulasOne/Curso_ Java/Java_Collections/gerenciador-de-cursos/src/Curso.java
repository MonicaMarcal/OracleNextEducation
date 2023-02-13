import java.util.*;

public class Curso {

    private String nome;
    private String instrutor;
    private List<Aula> aulas = new LinkedList<Aula>();
    private Set<Aluno> alunos = new HashSet<>(); //atributo para representar os alunos
    //private Set<Aluno> alunos = new LinkedHashSet<>();//atributo para representar os alunos em ordem

    private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();

    public Curso(String nome, String instrutor) {
        this.nome = nome;
        this.instrutor = instrutor;
    }

    public String getNome() {
        return nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    //método que devolve o Set mas de maneira não modificável
    public List<Aula> getAulas() {
        return Collections.unmodifiableList(aulas);
    }

    public void adiciona(Aula aula) {
        this.aulas.add(aula);
    }

    public int getTempoTotal() {
        return this.aulas.stream().mapToInt(Aula::getTempo).sum();
    }
    @Override
    public String toString() {
        return "[Curso: " + this.getNome() + ", tempo total: " + this.getTempoTotal()
                + ", aulas: + " + this.aulas + "]";
    }
    //método para matricular um aluno no curso. O método deve adicionar o aluno ao Set
    public void matricula(Aluno aluno) {
        // adiciona no Set de alunos
        this.alunos.add(aluno);
        // cria a relação no Map
        this.matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
    }
    public Set<Aluno> getAlunos() {
        return Collections.unmodifiableSet(alunos);
    }

    public boolean estaMatriculado(Aluno aluno) {
        return this.alunos.contains(aluno);
    }

    public Aluno buscaMatriculado(int numero) {
        if (!matriculaParaAluno.containsKey(numero))
            throw new NoSuchElementException();
        return this.matriculaParaAluno.get(numero);
    }
    /*
    public Aluno buscaMatriculado(int numero) {
        for (Aluno aluno : alunos) {
            if (aluno.getNumeroMatricula() == numero) {
                return aluno;
            }
        }
        throw new NoSuchElementException("Matricula " + numero
                + " não encontrada");
    }
     */
}


