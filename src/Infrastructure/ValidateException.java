package Infrastructure;
/*
Excessão criada para validações
 */
public class ValidateException extends Exception{
    public ValidateException(String str){
        super(str);
    }
}