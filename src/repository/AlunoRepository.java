package repository;

import Entity.AlunoEntity;

import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {
    // ID do usuário estático
    private static int mAlunoID = 0;
    // Lista de Alunos - Banco de Dados
    private static final List<AlunoEntity> mAlunoList = new ArrayList<>();

    // Faz a criação do ID do Usuario
    public static int createID() {
        return ++mAlunoID;
    }
    /*
    Retorna lista de alunos
     */
    public List<AlunoEntity> getList() {
        return mAlunoList;
    }
    /*
    Retorna aluno de acordo com o ID informado
     */
    public AlunoEntity getAlunoById(int id) {
        AlunoEntity alunoEntity = null;
        for (AlunoEntity aluno : mAlunoList) {
            if (aluno.getId() == id) {
                alunoEntity = aluno;
                break;
            }
        }
        return alunoEntity;
    }
    /*
    Cria um novo aluno
     */
    public void create(AlunoEntity alunoEntity) {
        mAlunoList.add(alunoEntity);
        String s = "";
    }
    /*
    Atualiza um aluno existente
     */

    public void update(AlunoEntity alunoEntity) {
        for (AlunoEntity aluno : mAlunoList) {
            if (aluno.getId() == alunoEntity.getId()) {

                // Atualiza os dados do aluno
                aluno.setNome(alunoEntity.getNome());
                aluno.setSobrenome(alunoEntity.getSobrenome());
                aluno.setCursoTipo(alunoEntity.getCursoTipo());
                aluno.setPromo(alunoEntity.isPromo());
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
