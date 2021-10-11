package Business;

import Entity.AbstractAluno;
import Entity.CursoTipo;
import Entity.InscriçõesEntity;
import Infrastructure.ValidateException;
import repository.AlunoRepository;

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
    public void validate(AbstractAluno abstractAluno) throws ValidateException {
        if ("".equals(abstractAluno.getNome())) {
            throw new ValidateException("Nome Obrigatorio!");
        }
        if ("".equals(abstractAluno.getSobrenome())) {
            throw new ValidateException("Sobrenome Obrigatorio!");
        }
    }
    /*
    Retorna aluno de acordo com o ID informado
     */
    public AbstractAluno getAlunoById(int id) {
        return this.mAlunoRepository.getAlunoById(id);
    }

    public List<AbstractAluno> getList(){
        return this.mAlunoRepository.getList();
    }
    /*
    Cria um novo aluno
     */
    public void create(AbstractAluno abstractAluno) {
        abstractAluno.setId(AlunoRepository.createID());
        this.mAlunoRepository.create(abstractAluno);
    }
    /*
    Atualiza um aluno existente
     */
    public void update(AbstractAluno abstractAluno) {
        this.mAlunoRepository.update(abstractAluno);
    }
    /*
    Remove aluno
     */
    public void delete(int id) throws ValidateException{
        if (id == 0){
            throw new ValidateException("É necessário selecionar um aluno");
        }
        this.mAlunoRepository.delete(id);
    }

    public InscriçõesEntity getInscrições(){
        InscriçõesEntity inscriçõesEntity = new InscriçõesEntity();

        List<AbstractAluno> list = this.getList();
        for (AbstractAluno abstractAluno : list){
            if(abstractAluno.getCursoTipo() == CursoTipo.BES)
                inscriçõesEntity.setBES(inscriçõesEntity.getBES()+ 1);
            else if (abstractAluno.getCursoTipo() == CursoTipo.BCC)
            inscriçõesEntity.setBCC(inscriçõesEntity.getBCC()+ 1);
            else
            inscriçõesEntity.setADS(inscriçõesEntity.getADS()+ 1);
        }
        return inscriçõesEntity;
    }

    public float gerarMensalidade(AbstractAluno aluno){
        return aluno.gerarMensalidade();
    }
}