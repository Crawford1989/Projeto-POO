import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoDAO {

    protected static int id = 0;

    protected static List<Curso> cursoList = new ArrayList<>();

    public static void cadastrarCurso() {
        int idCurso = ++id;
        System.out.println("Informe o nome do Curso: ");
        String nomeCurso = Utils.inputString();
        System.out.println("Informe o turno: ");
        String turnoCurso = Utils.inputString();
        System.out.println("Informe as Disciplinas do curso: ");

        Curso curso = new Curso(idCurso, nomeCurso, turnoCurso);
        while (true) {
            System.out.println("Deseja adicionar uma disciplina ao curso? (s/n)");
            String resposta = Utils.inputString();
            if (resposta.equalsIgnoreCase("s")) {
                System.out.println("Informe o ID da disciplina que deseja adicionar: ");
                int idDisc = Utils.inputInt();
                Optional<Disciplina> disciplinaOptional = DisciplinaDAO.discipList.stream().filter(a -> a.id == idDisc).findFirst();
                if (disciplinaOptional.isPresent()) {
                    Disciplina disciplina = disciplinaOptional.get();
                    curso.addDisciplina(disciplina);
                    System.out.println("Disciplina adicionada ao curso!");
                } else {
                    System.out.println("Disciplina não encontrada!");
                }
            } else if (resposta.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("Resposta inválida, digite s para sim ou n para não!");
            }
        }


        cursoList.add(curso);
        System.out.println("Curso cadastrado com sucesso!");
    }

    public static void verCurso() {
        for (Curso curso : cursoList) {
            System.out.println(curso.imprimirDetalhesDoCurso());
            System.out.println("--------------");
        }
    }


    public static void RemoverCurso() {
        System.out.println("Escolha um Curso para remover: ");
        for (Curso curso : cursoList) {
            System.out.println(curso.cursoMenu());
        }
        System.out.println("Opção: ");
        int idCurso = Utils.inputInt();
        Optional<Curso> curso = cursoList.stream().filter(a -> a.id == idCurso).findFirst();
        if (curso.isEmpty()) {
            System.out.println("Curso não foi encontrado ");
        } else {
            cursoList.remove(curso.get());
            System.out.println("Curso foi removido");
        }
    }

    public static void AtualizarCurso() {
        System.out.println("Escolha o curso que deseja atualizar: ");
        for (Curso curso : cursoList) {
            System.out.println(curso.cursoMenu());
        }
        System.out.println("Opção: ");
        int idCurso = Utils.inputInt();
        Optional<Curso> curso = cursoList.stream().filter(a -> a.id == idCurso).findFirst();
        if (curso.isEmpty()) {
            System.out.println("Curso não foi encontrado ");
        } else {
            System.out.println("Informe o nome do Curso: ");
            String nome = Utils.inputString();

            System.out.println("Informe o turno do curso: ");
            String turno = Utils.inputString();

            while (true) {
                System.out.println("Deseja vincular uma disciplina ao curso: (s/n) ");
                String resposta = Utils.inputString();
                if (resposta.equalsIgnoreCase("s")) {
                    System.out.println("Informe o ID da disciplina que deseja vincular: ");
                    int idDisc = Utils.inputInt();
                    Optional<Disciplina> disciplinaOptinal = DisciplinaDAO.discipList.stream().filter(a -> a.id == idDisc).findFirst();
                    if (disciplinaOptinal.isPresent()) {
                        Disciplina disciplina = disciplinaOptinal.get();
                        curso.get().addDisciplina(disciplina);
                        System.out.println("Disciplina adicionada ao curso! ");
                    } else {
                        System.out.println("Disciplina não encontrada!");
                    }
                }
                if (resposta.equalsIgnoreCase("n")) {
                    break;
                }
            }
        }
    }

    public static void Sair() {
        Menu.GerenciaMenu();
    }
}
