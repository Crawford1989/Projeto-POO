public class Disciplina {
    protected int id;
    protected String nomeDisc;
    protected double cargaHora;
    protected double nota;

    public Disciplina(int id, String nomeDisc, double cargaHora, double nota){
        this.id = id;
        this.nomeDisc = nomeDisc;
        this.cargaHora = cargaHora;
        this.nota = nota;

    }
    public String discMenu(){
        return this.id + " " + this.nomeDisc;
    }
    public String toString(){
        return "Disciplina{" +
                "id da Dsciplina =" + this.id +
                ", Nome da Dsciplina ='" + this.nomeDisc + '\'' +
                ", Carga Horaria =" + this.cargaHora +
                ", Nota ='" + this.nota +
                '}';
    }
    public void atualizaAll(String nomeDisc, double cargaHora, double nota) {
        this.nomeDisc = nomeDisc;
        this.cargaHora = cargaHora;
        this.nota = nota;
    }
}
