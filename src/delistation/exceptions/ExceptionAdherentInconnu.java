package delistation.exceptions;

/**
 * Exception definition : ExceptionAdherentInconnu
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionAdherentInconnu extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public ExceptionAdherentInconnu()
    {
        super(ExceptionAdherentInconnuHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public ExceptionAdherentInconnu(String orb_reason)
    {
        super(ExceptionAdherentInconnuHelper.id() +" " +  orb_reason);
    }

}
