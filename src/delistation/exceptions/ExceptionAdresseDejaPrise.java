package delistation.exceptions;

/**
 * Exception definition : ExceptionAdresseDejaPrise
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionAdresseDejaPrise extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public ExceptionAdresseDejaPrise()
    {
        super(ExceptionAdresseDejaPriseHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public ExceptionAdresseDejaPrise(String orb_reason)
    {
        super(ExceptionAdresseDejaPriseHelper.id() +" " +  orb_reason);
    }

}
