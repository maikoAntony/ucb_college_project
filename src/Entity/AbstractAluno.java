package Entity;

public abstract class AbstractAluno {
    private int id;
    private String nome;
    private String sobrenome;
    private CursoTipo cursoTipo;
    private boolean promo;


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPromo() {
        return promo;
    }

    public void setPromo(boolean promo) {
        this.promo = promo;
    }
    public abstract float gerarMensalidade();
}