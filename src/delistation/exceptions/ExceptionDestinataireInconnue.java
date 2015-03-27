package delistation.exceptions;

/**
 * Exception definition : ExceptionDestinataireInconnue
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionDestinataireInconnue extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public ExceptionDestinataireInconnue()
    {
        super(ExceptionDestinataireInconnueHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public ExceptionDestinataireInconnue(String orb_reason)
    {
        super(ExceptionDestinataireInconnueHelper.id() +" " +  orb_reason);
    }

}
