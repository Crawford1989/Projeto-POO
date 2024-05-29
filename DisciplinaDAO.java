import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DisciplinaDAO {

    protected static List<Disciplina> discipList = new ArrayList<>();
    protected static int id = 0;

    public static void cadastrarDisc() {
        int idDisc = ++id;
        System.out.println("Informe o nome da disciplina: ");
        String nomeDisc = Utils.inputString();
        System.out.println("Informe a carga horaria da disciplina: ");
        double cargaHora = Utils.inputDouble();
        System.out.println("Informe a nota: ");
        double nota = Utils.inputDouble();
        Disciplina disciplina = new Disciplina(idDisc, nomeDisc, cargaHora, nota);
        discipList.add(disciplina);
    }

    public static void Ler() {
        for (Disciplina disciplina : discipList) {
            System.out.println(disciplina.toString());
            System.out.println("--------------");
        }
    }

    public static void removerDisc() {
        System.out.println("Escolha uma disciplina para remover: ");
        for (Disciplina disciplina : discipList) {
            System.out.println(disciplina.discMenu());
        }
        System.out.println("Opção: ");
        int idDisc = Utils.inputInt();
        Optional<Disciplina> disciplina = discipList.stream().filter(a -> a.id == idDisc).findFirst();
        if (disciplina.isEmpty()) {
            System.out.println("Disciplina não foi encontrada ");
        } else {
            discipList.remove(disciplina.get());
            System.out.println("Disciplina foi removida");
        }
    }

    public static void Atualizar() {
        System.out.println("Escolha a Disciplina que deseja atualizar: ");
        for (Disciplina disciplina : discipList) {
            System.out.println(disciplina.discMenu());
        }
        System.out.println("Opção: ");
        int idDisc = Utils.inputInt();
        Optional<Disciplina> disciplinaOptional = discipList.stream().filter(a -> a.id == idDisc).findFirst();
        if (disciplinaOptional.isEmpty()) {
            System.out.println("Disciplina não foi encontrada ");
        } else {
            System.out.println("Informe o nome da Disciplina: ");
            String nomeDisc = Utils.inputString();

            System.out.println("Informe a carga horaria da Disciplina: ");
            double cargaHora = Utils.inputDouble();

            System.out.println("Informe a Nota: ");
            double nota = Utils.inputDouble();


            Disciplina disciplina = disciplinaOptional.get();
            disciplina.atualizaAll(nomeDisc, cargaHora, nota);
        }
    }


    public static void Sair() {
        Menu.GerenciaMenu();
    }

}
