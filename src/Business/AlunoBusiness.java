package Business;

import Entity.AlunoEntity;
import Entity.CursoTipo;
import Entity.InscriçõesEntity;
import Infrastructure.ValidateException;
import repository.AlunoRepository;

import javax.print.attribute.standard.Finishings;
import java.util.List;

public class AlunoBusiness {
    //Acessa os dados
    private AlunoRepository mAlunoRepository;

    //Construtor
    public AlunoBusiness() {
        this.mAlunoRepository = new AlunoRepository();
    }
    /*
    Faz a validação dos dados obrigatorios
    Se tudo estiver correto, uma exceção de validação não será lançada
     */
    public void validate(AlunoEntity alunoEntity) throws ValidateException {
        if ("".equals(alunoEntity.getNome())) {
            throw new ValidateException("Nome Obrigatorio!");
        }
        if ("".equals(alunoEntity.getSobrenome())) {
            throw new ValidateException("Sobrenome Obrigatorio!");
        }
    }
    /*
    Retorna aluno de acordo com o ID informado
     */
    public AlunoEntity getAlunoById(int id) {
        return this.mAlunoRepository.getAlunoById(id);
    }

    public List<AlunoEntity> getList(){
        return this.mAlunoRepository.getList();
    }
    /*
    Cria um novo aluno
     */
    public void create(AlunoEntity alunoEntity) {
        alunoEntity.setId(AlunoRepository.createID());
        this.mAlunoRepository.create(alunoEntity);
    }
    /*
    Atualiza um aluno existente
     */
    public void update(AlunoEntity alunoEntity) {
        this.mAlunoRepository.update(alunoEntity);
    }
    /*
    Remove aluno
     */
    public void delete(int id) throws ValidateException{
        if (id == 0){
            throw new ValidateException("É necessário selecionar um aluno");
        }
        this.mAlunoRepositorydelete(id);
    }

    private void mAlunoRepositorydelete(int id) {

    }
    public InscriçõesEntity getInscrições(){
        InscriçõesEntity inscriçõesEntity = new InscriçõesEntity();

        List<AlunoEntity> list = this.getList();
        for (AlunoEntity alunoEntity: list){
            if(alunoEntity.getCursoTipo() == CursoTipo.BES)
                inscriçõesEntity.setBES(inscriçõesEntity.getBES()+ 1);
            else if (alunoEntity.getCursoTipo() == CursoTipo.BCC)
            inscriçõesEntity.setBCC(inscriçõesEntity.getBCC()+ 1);
            else
            inscriçõesEntity.setADS(inscriçõesEntity.getADS()+ 1);
        }
        return inscriçõesEntity;
    }


}
