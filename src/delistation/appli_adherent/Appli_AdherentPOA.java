package delistation.appli_adherent;

/**
 * Interface definition : Appli_Adherent
 * 
 * @author OpenORB Compiler
 */
public abstract class Appli_AdherentPOA extends org.omg.PortableServer.Servant
        implements Appli_AdherentOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Appli_Adherent _this()
    {
        return Appli_AdherentHelper.narrow(_this_object());
    }

    public Appli_Adherent _this(org.omg.CORBA.ORB orb)
    {
        return Appli_AdherentHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:delistation/appli_adherent/Appli_Adherent:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("notifierColis")) {
                return _invoke_notifierColis(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_notifierColis(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        notifierColis();

        _output = handler.createReply();

        return _output;
    }

}
