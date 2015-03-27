package delistation.exceptions;

/**
 * Exception definition : ExceptionCourseInconnue
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionCourseInconnue extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public ExceptionCourseInconnue()
    {
        super(ExceptionCourseInconnueHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public ExceptionCourseInconnue(String orb_reason)
    {
        super(ExceptionCourseInconnueHelper.id() +" " +  orb_reason);
    }

}
