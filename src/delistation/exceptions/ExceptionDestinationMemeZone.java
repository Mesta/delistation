package delistation.exceptions;

/**
 * Exception definition : ExceptionDestinationMemeZone
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionDestinationMemeZone extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public ExceptionDestinationMemeZone()
    {
        super(ExceptionDestinationMemeZoneHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public ExceptionDestinationMemeZone(String orb_reason)
    {
        super(ExceptionDestinationMemeZoneHelper.id() +" " +  orb_reason);
    }

}
