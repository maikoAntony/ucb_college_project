package repository;

import Entity.AbstractAluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {
    // ID do usuário estático
    private static int mAlunoID = 0;
    // Lista de Alunos - Banco de Dados
    private static final List<AbstractAluno> mAlunoList = new ArrayList<>();

    // Faz a criação do ID do Usuario
    public static int createID() {
        return ++mAlunoID;
    }
    /*
    Retorna lista de alunos
     */
    public List<AbstractAluno> getList() {
        return mAlunoList;
    }
    /*
    Retorna aluno de acordo com o ID informado
     */
    public AbstractAluno getAlunoById(int id) {
        AbstractAluno abstractAluno = null;
        for (AbstractAluno aluno : mAlunoList) {
            if (aluno.getId() == id) {
                abstractAluno = aluno;
                break;
            }
        }
        return abstractAluno;
    }
    /*
    Cria um novo aluno
     */
    public void create(AbstractAluno abstractAluno) {
        mAlunoList.add(abstractAluno);
    }
    /*
    Atualiza um aluno existente
     */

    public void update(AbstractAluno abstractAluno) {
        for (AbstractAluno aluno : mAlunoList) {
            if (aluno.getId() == abstractAluno.getId()) {

                // Atualiza os dados do aluno
                aluno.setNome(abstractAluno.getNome());
                aluno.setSobrenome(abstractAluno.getSobrenome());
                aluno.setCursoTipo(abstractAluno.getCursoTipo());
                aluno.setPromo(abstractAluno.isPromo());
            }
        }
    }
    /*
    Remove um aluno
     */
    public void delete(int id) {
        int indexRemove = 0;
        for (int i = 0; i < mAlunoList.size(); i++) {
            if (mAlunoList.get(0).getId() == id) {
                indexRemove = i;
                break;
            }
        }
        mAlunoList.remove(indexRemove);
    }
}