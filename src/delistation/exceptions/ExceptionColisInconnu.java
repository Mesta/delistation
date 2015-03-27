package delistation.exceptions;

/**
 * Exception definition : ExceptionColisInconnu
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionColisInconnu extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public ExceptionColisInconnu()
    {
        super(ExceptionColisInconnuHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public ExceptionColisInconnu(String orb_reason)
    {
        super(ExceptionColisInconnuHelper.id() +" " +  orb_reason);
    }

}
