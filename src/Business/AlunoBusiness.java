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
}
