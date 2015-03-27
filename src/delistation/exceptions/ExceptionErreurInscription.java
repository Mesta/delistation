package delistation.exceptions;

/**
 * Exception definition : ExceptionErreurInscription
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionErreurInscription extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public ExceptionErreurInscription()
    {
        super(ExceptionErreurInscriptionHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public ExceptionErreurInscription(String orb_reason)
    {
        super(ExceptionErreurInscriptionHelper.id() +" " +  orb_reason);
    }

}
