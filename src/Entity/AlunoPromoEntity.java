package Entity;

public class AlunoPromoEntity extends AbstractAluno{
    public AlunoPromoEntity(String nome, String sobrenome, CursoTipo cursoTipo) {
        super.setNome(nome);
        super.setSobrenome(sobrenome);
        super.setCursoTipo(cursoTipo);
        super.setPromo(true);
    }

    @Override
    public float gerarMensalidade() {
        return 500 * 0.7f;
    }
}