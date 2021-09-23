package Infrastructure;
/*
Excessão criaa para validações
 */
public class ValidateException extends Exception{
    public ValidateException(String str){
        super(str);
    }
}
