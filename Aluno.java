import java.util.ArrayList;
import java.util.List;


public class Aluno {
    protected int id;
    protected String nome;
    protected int idade;
    protected String cpf;
    protected List<Curso> cursos;
    protected List<Disciplina> disciplinas;

    public Aluno(int id, String nome, int idade, String cpf) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.disciplinas = new ArrayList<>();
        this.cursos = new ArrayList<>();

    }

    public void addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public void addCurso(Curso curso) {
        cursos.add(curso);
    }


    public String toString() {
        return "Aluno{" +
                "id=" + this.id +
                ", nome='" + this.nome + '\'' +
                ", idade=" + this.idade +
                ", cpf='" + this.cpf + '\'' +
                '}';
    }

    public String imprimirDisciplinas() {
        String disciplinaStr = "Disciplinas do Aluno:  " + this.nome + ":\n";
        for (Disciplina disciplina : this.disciplinas) {
            disciplinaStr += disciplina.toString() + "\n";
        }
        return disciplinaStr;
    }

    public String imprimirCursos() {
        String cursoStr = "Cursos do Aluno:  " + this.nome + ":\n";
        for (Curso curso : this.cursos) {
            cursoStr += curso.toString() + "\n";
        }
        return cursoStr;
    }


    public String imprimirDetalhesDoCurso() {
        String detalhes = this.toString() + "\n";
        System.out.println("Deseja ver os cursos que este aluno esta matriculado? (s/n)");
        String resposta = Utils.inputString();
        if (resposta.equalsIgnoreCase("s")) {
            detalhes += this.imprimirCursos();
        }else{
            AlunoDAO.Sair();
        }
        return detalhes;
    }
    public String imprimirDetalhesDaDisciplina() {
        String detalhes = this.toString() + "\n";
        System.out.println("Deseja ver as disciplinas do curso que este aluno esta matriculado? (s/n)");
        String resposta = Utils.inputString();
        if (resposta.equalsIgnoreCase("s")) {
            detalhes += this.imprimirDisciplinas();
        }else{
            AlunoDAO.Sair();
        }
        return detalhes;
    }

    public String alunoMenu() {
        return this.id + " " + this.nome;
    }

    public void atualizaAll(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;

    }
}
