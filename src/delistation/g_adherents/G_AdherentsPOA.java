package delistation.g_adherents;

/**
 * Interface definition : G_Adherents
 * 
 * @author OpenORB Compiler
 */
public abstract class G_AdherentsPOA extends org.omg.PortableServer.Servant
        implements G_AdherentsOperations, org.omg.CORBA.portable.InvokeHandler
{
    public G_Adherents _this()
    {
        return G_AdherentsHelper.narrow(_this_object());
    }

    public G_Adherents _this(org.omg.CORBA.ORB orb)
    {
        return G_AdherentsHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:delistation/g_adherents/G_Adherents:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("adherer")) {
                return _invoke_adherer(_is, handler);
        } else if (opName.equals("authentifier")) {
                return _invoke_authentifier(_is, handler);
        } else if (opName.equals("demandeNotificationDepot")) {
                return _invoke_demandeNotificationDepot(_is, handler);
        } else if (opName.equals("facturer")) {
                return _invoke_facturer(_is, handler);
        } else if (opName.equals("getAdherent")) {
                return _invoke_getAdherent(_is, handler);
        } else if (opName.equals("majIOR")) {
                return _invoke_majIOR(_is, handler);
        } else if (opName.equals("rechercheDestinataire")) {
                return _invoke_rechercheDestinataire(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_adherer(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();
        String arg3_in = _is.read_string();
        org.omg.CORBA.StringHolder arg4_inout = new org.omg.CORBA.StringHolder();
        arg4_inout.value = _is.read_string();
        org.omg.CORBA.StringHolder arg5_inout = new org.omg.CORBA.StringHolder();
        arg5_inout.value = _is.read_string();

        try
        {
            short _arg_result = adherer(arg0_in, arg1_in, arg2_in, arg3_in, arg4_inout, arg5_inout);

            _output = handler.createReply();
            _output.write_short(_arg_result);

            _output.write_string(arg4_inout.value);
            _output.write_string(arg5_inout.value);
        }
        catch (delistation.exceptions.ExceptionErreurPaiement _exception)
        {
            _output = handler.createExceptionReply();
            delistation.exceptions.ExceptionErreurPaiementHelper.write(_output,_exception);
        }
        catch (delistation.exceptions.ExceptionAdresseDejaPrise _exception)
        {
            _output = handler.createExceptionReply();
            delistation.exceptions.ExceptionAdresseDejaPriseHelper.write(_output,_exception);
        }
        catch (delistation.exceptions.ExceptionErreurInscription _exception)
        {
            _output = handler.createExceptionReply();
            delistation.exceptions.ExceptionErreurInscriptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_authentifier(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();
        String arg1_in = _is.read_string();

        boolean _arg_result = authentifier(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getAdherent(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        try
        {
            delistation.datatypes.Adherent _arg_result = getAdherent(arg0_in);

            _output = handler.createReply();
            delistation.datatypes.AdherentHelper.write(_output,_arg_result);

        }
        catch (delistation.exceptions.ExceptionAdherentInconnu _exception)
        {
            _output = handler.createExceptionReply();
            delistation.exceptions.ExceptionAdherentInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_majIOR(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();
        short arg1_in = _is.read_short();

        majIOR(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_rechercheDestinataire(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        delistation.datatypes.Adresse arg0_in = delistation.datatypes.AdresseHelper.read(_is);

        try
        {
            delistation.datatypes.Adherent _arg_result = rechercheDestinataire(arg0_in);

            _output = handler.createReply();
            delistation.datatypes.AdherentHelper.write(_output,_arg_result);

        }
        catch (delistation.exceptions.ExceptionDestinataireInconnue _exception)
        {
            _output = handler.createExceptionReply();
            delistation.exceptions.ExceptionDestinataireInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_facturer(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();
        short arg1_in = _is.read_short();

        try
        {
            boolean _arg_result = facturer(arg0_in, arg1_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_demandeNotificationDepot(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        demandeNotificationDepot(arg0_in);

        _output = handler.createReply();

        return _output;
    }

}
