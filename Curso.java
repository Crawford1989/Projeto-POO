import java.util.ArrayList;
import java.util.List;

public class Curso {
    protected int id;
    protected String nomeCurso;
    protected String turno;
    protected List<Disciplina> disciplinas;

    public Curso(int id, String nomeCurso, String turno) {
        this.id = id;
        this.nomeCurso = nomeCurso;
        this.turno = turno;
        this.disciplinas = new ArrayList<>();

    }
    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "Nome do Curso='" + nomeCurso + '\'' +
                ", turno='" + turno + '\'' +
                ", id=" + id +
                '}';
    }


    public String imprimirDisciplinas() {
        String disciplinasStr = "Disciplinas do curso " + this.nomeCurso + ":\n";
        for (Disciplina disciplina : this.disciplinas) {
            disciplinasStr += disciplina.toString() + "\n";
        }
        return disciplinasStr;
    }


    public String imprimirDetalhesDoCurso() {
        String detalhes = this.toString() + "\n";
        System.out.println("Deseja ver as disciplinas deste curso? (s/n)");
        String resposta = Utils.inputString();
        if (resposta.equalsIgnoreCase("s")) {
            detalhes += this.imprimirDisciplinas();
        }
        return detalhes;
    }


    public String cursoMenu() {
        return this.id + " " + this.nomeCurso;
    }

    public void atualizaAll(String nomeCurso, String turno) {
        this.nomeCurso = nomeCurso;
        this.turno = turno;
    }

}
