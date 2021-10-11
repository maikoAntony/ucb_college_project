package Entity;

public class AlunoRegularEntity  extends AbstractAluno{

    public AlunoRegularEntity(String nome, String sobrenome, CursoTipo cursoTipo) {
        super.setNome(nome);
        super.setSobrenome(sobrenome);
        super.setCursoTipo(cursoTipo);
        super.setPromo(false);
    }

    @Override
    public float gerarMensalidade() {
        return 0;
    }
}