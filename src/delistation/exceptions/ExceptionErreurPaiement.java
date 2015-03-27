package delistation.exceptions;

/**
 * Exception definition : ExceptionErreurPaiement
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionErreurPaiement extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public ExceptionErreurPaiement()
    {
        super(ExceptionErreurPaiementHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionErreurPaiement(String raison)
    {
        super(ExceptionErreurPaiementHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionErreurPaiement(String orb_reason, String raison)
    {
        super(ExceptionErreurPaiementHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
