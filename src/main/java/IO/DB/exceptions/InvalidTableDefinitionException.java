package IO.DB.exceptions;

/**
 * Created by matias on 16/05/17.
 */
public class InvalidTableDefinitionException extends Exception{

    public InvalidTableDefinitionException(String message){
        super(message);
    }

    public InvalidTableDefinitionException(){}
}
