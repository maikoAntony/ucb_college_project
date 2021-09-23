package Entity;

public class AlunoEntity {
    private String nome;
    private String sobrenome;
    private CursoTipo cursoTipo;
    private boolean promo;

    public AlunoEntity(String nome, String sobrenome, CursoTipo cursoTipo, boolean promo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cursoTipo = cursoTipo;
        this.promo = promo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public CursoTipo getCursoTipo() {
        return cursoTipo;
    }

    public void setCursoTipo(CursoTipo cursoTipo) {
        this.cursoTipo = cursoTipo;
    }

    public boolean isPromo() {
        return promo;
    }

    public void setPromo(boolean promo) {
        this.promo = promo;
    }
}
