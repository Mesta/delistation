package delistation.g_facturation;

/**
 * Interface definition : G_Facturation
 * 
 * @author OpenORB Compiler
 */
public abstract class G_FacturationPOA extends org.omg.PortableServer.Servant
        implements G_FacturationOperations, org.omg.CORBA.portable.InvokeHandler
{
    public G_Facturation _this()
    {
        return G_FacturationHelper.narrow(_this_object());
    }

    public G_Facturation _this(org.omg.CORBA.ORB orb)
    {
        return G_FacturationHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:delistation/g_facturation/G_Facturation:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("crediterTransport")) {
                return _invoke_crediterTransport(_is, handler);
        } else if (opName.equals("creerCompte")) {
                return _invoke_creerCompte(_is, handler);
        } else if (opName.equals("debiterAdherent")) {
                return _invoke_debiterAdherent(_is, handler);
        } else if (opName.equals("devisTransport")) {
                return _invoke_devisTransport(_is, handler);
        } else if (opName.equals("factureAdhesion")) {
                return _invoke_factureAdhesion(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_creerCompte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();
        delistation.datatypes.CompteMode arg1_in = delistation.datatypes.CompteModeHelper.read(_is);

        boolean _arg_result = creerCompte(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_factureAdhesion(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            short _arg_result = factureAdhesion(arg0_in);

            _output = handler.createReply();
            _output.write_short(_arg_result);

        }
        catch (delistation.exceptions.ExceptionErreurPaiement _exception)
        {
            _output = handler.createExceptionReply();
            delistation.exceptions.ExceptionErreurPaiementHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_devisTransport(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        delistation.datatypes.Zone arg0_in = delistation.datatypes.ZoneHelper.read(_is);
        delistation.datatypes.Zone arg1_in = delistation.datatypes.ZoneHelper.read(_is);

        short _arg_result = devisTransport(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_short(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_debiterAdherent(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        short arg1_in = _is.read_short();

        try
        {
            boolean _arg_result = debiterAdherent(arg0_in, arg1_in);

            _output = handler.createReply();
            _output.write_boolean(_arg_result);

        }
        catch (delistation.exceptions.ExceptionErreurPaiement _exception)
        {
            _output = handler.createExceptionReply();
            delistation.exceptions.ExceptionErreurPaiementHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_crediterTransport(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        short arg1_in = _is.read_short();

        crediterTransport(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

}
