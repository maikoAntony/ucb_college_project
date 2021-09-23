package Business;

import Entity.AlunoEntity;
import Infrastructure.ValidateException;

public class AlunoBusiness {
    public void validate(AlunoEntity alunoEntity) throws ValidateException {
       if ("".equals(alunoEntity.getNome())){
           throw new ValidateException("Nome Obrigatorio!");
       }
        if ("".equals(alunoEntity.getSobrenome())){
            throw new ValidateException("Sobrenome Obrigatorio!");
        }
    }
    public AlunoEntity getAlunoById(){
        return null;
    }
    public void create(AlunoEntity alunoEntity) {
    }
    public void update(AlunoEntity alunoEntity){
    }
    public void delete(){
    }
}
