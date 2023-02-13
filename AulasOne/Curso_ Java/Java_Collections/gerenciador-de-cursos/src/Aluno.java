
public class Aluno {
    //Atributos
    private String nome;
    private int numeroMatricula;

    //construtor
    public Aluno(String nome, int numeroMatricula) {
        if (nome == null) {
            throw new NullPointerException("Nome não pode ser nulo");
        }
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
    }



    //getter e setter dos atributos
    public String getNome() {
        return nome;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }


    //Metodo toString
    @Override
    public String toString() {
        return "[Aluno: " + this.nome + ", matricula: " + this.numeroMatricula + "]";
    }
    // @Override
    //public boolean equals(Object obj) {
     //   Aluno outroAluno = (Aluno) obj;
      //  return this.nome.equals(outroAluno.nome);
    //}
    //public int hashCode(){
    //   return this.nome.hashCode();
    //}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + numeroMatricula;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (numeroMatricula != other.numeroMatricula)
            return false;
        return true;
    }

}
