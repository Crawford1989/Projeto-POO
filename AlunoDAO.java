import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlunoDAO {

    private static int id = 0;
    public static List<Aluno> alunoList = new ArrayList<>();

    public static void Cadastrar() {
        int idAluno = ++id;
        System.out.println("Informe um nome: ");
        String nome = Utils.inputString();
        System.out.println("Informe a idade: ");
        int idade = Utils.inputInt();
        System.out.println("Informe o CPF: ");
        String cpf = Utils.inputString();
        System.out.println("Informe os cursos : ");
        Aluno aluno = new Aluno(idAluno, nome, idade, cpf);

        while (true) {
            System.out.println("Deseja matricular o aluno em um curso? (s/n)");
            String resposta = Utils.inputString();
            if (resposta.equalsIgnoreCase("s")) {
                System.out.println("Informe o ID do aluno que deseja matricular: ");
                int idCurso = Utils.inputInt();
                Optional<Curso> cursoOptional = CursoDAO.cursoList.stream().filter(a -> a.id == idCurso).findFirst();
                if (cursoOptional.isPresent()) {
                    Curso curso = cursoOptional.get();
                    aluno.addCurso(curso);
                    for(Disciplina disciplina : curso.disciplinas){
                        aluno.addDisciplina(disciplina);
                    }
                    System.out.println("Aluno matriculado ao Curso!");
                } else {
                    System.out.println("Curso não encontrado!");
                }
            } else if (resposta.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("Resposta inválida, digite s para sim ou n para não!");
            }
        }

        alunoList.add(aluno);
        System.out.println("Aluno matriculado com sucesso!");

    }

    public static void Ler() {
        for (Aluno aluno : alunoList) {
            System.out.println(aluno.imprimirDetalhesDoCurso());
            System.out.println(aluno.imprimirDetalhesDaDisciplina());
            System.out.println("--------------");
        }
    }

    public static void Remover() {
        System.out.println("Escolha um aluno para remover: ");
        for (Aluno aluno : alunoList) {
            System.out.println(aluno.alunoMenu());
        }
        System.out.println("Opção: ");
        int idAluno = Utils.inputInt();
        Optional<Aluno> aluno = alunoList.stream().filter(a -> a.id == idAluno).findFirst();
        if (aluno.isEmpty()) {
            System.out.println("Aluno não foi encontrado ");
        } else {
            alunoList.remove(aluno.get());
            System.out.println("Aluno foi removido");
        }
    }

    public static void Atualizar() {
        System.out.println("Escolha o aluno que deseja atualizar: ");
        for (Aluno aluno : alunoList) {
            System.out.println(aluno.alunoMenu());
        }
        System.out.println("Opção: ");
        int idAluno = Utils.inputInt();
        Optional<Aluno> aluno = alunoList.stream().filter(a -> a.id == idAluno).findFirst();
        if (aluno.isEmpty()) {
            System.out.println("Aluno não foi encontrado ");
        } else {
            System.out.println("Informe o nome: ");
            String nome = Utils.inputString();

            System.out.println("Informe a idade: ");
            int idade = Utils.inputInt();

            System.out.println("Informe o cpf: ");
            String cpf = Utils.inputString();

            while (true) {
                System.out.println("Deseja trocar ou adicionar um novo curso: (s/n) ");
                String resposta = Utils.inputString();
                if (resposta.equalsIgnoreCase("s")) {
                    System.out.println("Informe o ID que deseja trocar ou adicionar um novo curso: ");
                    int idCurso = Utils.inputInt();
                    Optional<Curso> cursoOptinal = CursoDAO.cursoList.stream().filter(a -> a.id == idCurso).findFirst();
                    if (cursoOptinal.isPresent()) {
                        Curso curso = cursoOptinal.get();
                        aluno.get().addCurso(curso);
                        for(Disciplina disciplina : curso.disciplinas){
                            aluno.get().addDisciplina(disciplina);
                        }
                        System.out.println("Aluno matriculado no Curso! ");
                    } else {
                        System.out.println("Curso não encontrado!");
                    }
                }
                if (resposta.equalsIgnoreCase("n")) {
                    break;
                }
            }

        }
    }
    public static void Sair(){
        Menu.GerenciaMenu();
    }
}
