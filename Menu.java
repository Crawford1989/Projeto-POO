public class Menu {

    public static void GerenciaMenu() {

        int opcao;
        do {
            ImprimeMenu();
            System.out.println("Informe uma opção do Menu: ");
            opcao = Utils.inputInt();
            SelecionaMenu(opcao);
        } while (opcao != 4);
    }

    private static void SelecionaMenu(int opcao) {
        switch (opcao) {
            case 1:
                GerenciaSubMenuAluno();
                break;
            case 2:
                GerenciarSubMenuCurso();
                break;
            case 3:
                GerenciarSubMenuDisc();
                break;
            case 4:
                finalizar();
                break;
        }
    }

    private static void Sair(){
        Menu.GerenciaMenu();
    }
    private static void finalizar(){
        System.out.println("Até a proxima, Obrigado!");
        System.exit(0);
    }
    private static void ImprimeMenu() {
        System.out.println("Menu:");
        System.out.println("=======================");
        System.out.println("1-Gerenciar ALUNOS");
        System.out.println("2-Gerenciar CURSOS");
        System.out.println("3-Gerenciar DISCIPLINAS");
        System.out.println("4-SAIR");
        System.out.println("=======================");
    }

    private static void GerenciaSubMenuAluno() {

        int opcao;
        do {
            ImprimeSubMenuAluno();
            System.out.println("Informe uma opcao do Menu: ");
            opcao = Utils.inputInt();
            SelecionaSubMenuAluno(opcao);
        } while (opcao != 5);
    }
    private static void GerenciarSubMenuCurso() {

        int opcao;
        do {
            ImprimeSubMenuCurso();
            System.out.println("Informe uma opcao do Menu: ");
            opcao = Utils.inputInt();
            SelecionaSubMenuCurso(opcao);
        } while (opcao != 5);
    }
    private static void GerenciarSubMenuDisc() {

        int opcao;
        do {
            ImprimeSubMenuDisc();
            System.out.println("Informe uma opcao do Menu: ");
            opcao = Utils.inputInt();
            SelecionaSubMenuDisc(opcao);
        } while (opcao != 5);
    }

    private static void SelecionaSubMenuAluno(int opcao) {
        switch (opcao) {
            case 1:
                AlunoDAO.Cadastrar();
                break;
            case 2:
                AlunoDAO.Ler();
                break;
            case 3:
                AlunoDAO.Remover();
                break;
            case 4:
                AlunoDAO.Atualizar();
                break;
            case 5:
                AlunoDAO.Sair();
                break;
        }
    }
    private static void SelecionaSubMenuCurso(int opcao) {
        switch (opcao) {
            case 1:
                CursoDAO.cadastrarCurso();
                break;
            case 2:
                CursoDAO.verCurso();
                break;
            case 3:
                CursoDAO.RemoverCurso();
                break;
            case 4:
                CursoDAO.AtualizarCurso();
                break;
            case 5:
                CursoDAO.Sair();
                break;
        }
    }
    private static void SelecionaSubMenuDisc(int opcao) {
        switch (opcao) {
            case 1:
                DisciplinaDAO.cadastrarDisc();
                break;
            case 2:
                DisciplinaDAO.Ler();
                break;
            case 3:
                DisciplinaDAO.removerDisc();
                break;
            case 4:
                DisciplinaDAO.Atualizar();
                break;
            case 5:
                CursoDAO.Sair();
                break;
        }
    }

    private static void ImprimeSubMenuAluno() {
        System.out.println("Submenu Aluno:");
        System.out.println("=======================");
        System.out.println("1-Cadastrar ALUNO");
        System.out.println("2-Consultar ALUNO");
        System.out.println("3-Remover ALUNO");
        System.out.println("4-Atualizar ALUNO");
        System.out.println("5-Voltar ao MENU INICIAL");
        System.out.println("=======================");
    }
    private static void ImprimeSubMenuCurso() {
        System.out.println("Submenu Curso:");
        System.out.println("=======================");
        System.out.println("1-Cadastrar CURSO");
        System.out.println("2-Consultar CURSO");
        System.out.println("3-Remover CURSO");
        System.out.println("4-Atualizar CURSO");
        System.out.println("5-Voltar ao MENU INICIAL");
        System.out.println("=======================");
    }
    private static void ImprimeSubMenuDisc() {
        System.out.println("Submenu DISCIPLINA:");
        System.out.println("=======================");
        System.out.println("1-Cadastrar DICIPLINA");
        System.out.println("2-Consultar DICIPLINA");
        System.out.println("3-Remover DICIPLINA");
        System.out.println("4-Atualizar DICIPLINA");
        System.out.println("5-Voltar ao MENU INICIAL");
        System.out.println("=======================");
    }

}
