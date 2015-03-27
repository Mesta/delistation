package delistation.exceptions;

/**
 * Exception definition : ExceptionCourseDejaPrise
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionCourseDejaPrise extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public ExceptionCourseDejaPrise()
    {
        super(ExceptionCourseDejaPriseHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public ExceptionCourseDejaPrise(String orb_reason)
    {
        super(ExceptionCourseDejaPriseHelper.id() +" " +  orb_reason);
    }

}
