package delistation.g_colis;

/**
 * Interface definition : G_Colis
 * 
 * @author OpenORB Compiler
 */
public abstract class G_ColisPOA extends org.omg.PortableServer.Servant
        implements G_ColisOperations, org.omg.CORBA.portable.InvokeHandler
{
    public G_Colis _this()
    {
        return G_ColisHelper.narrow(_this_object());
    }

    public G_Colis _this(org.omg.CORBA.ORB orb)
    {
        return G_ColisHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:delistation/g_colis/G_Colis:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("_get_getAdresseG_Colis")) {
                return _invoke__get_getAdresseG_Colis(_is, handler);
        } else if (opName.equals("demandeEtat")) {
                return _invoke_demandeEtat(_is, handler);
        } else if (opName.equals("deposer")) {
                return _invoke_deposer(_is, handler);
        } else if (opName.equals("getColis")) {
                return _invoke_getColis(_is, handler);
        } else if (opName.equals("isDestinataire")) {
                return _invoke_isDestinataire(_is, handler);
        } else if (opName.equals("majEtatColis")) {
                return _invoke_majEtatColis(_is, handler);
        } else if (opName.equals("supprimerColis")) {
                return _invoke_supprimerColis(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_getAdresseG_Colis(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        delistation.datatypes.Adresse arg = getAdresseG_Colis();
        _output = handler.createReply();
        delistation.datatypes.AdresseHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getColis(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        try
        {
            delistation.datatypes.Colis _arg_result = getColis(arg0_in);

            _output = handler.createReply();
            delistation.datatypes.ColisHelper.write(_output,_arg_result);

        }
        catch (delistation.exceptions.ExceptionColisInconnu _exception)
        {
            _output = handler.createExceptionReply();
            delistation.exceptions.ExceptionColisInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_isDestinataire(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();
        short arg1_in = _is.read_short();

        boolean _arg_result = isDestinataire(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_deposer(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        delistation.datatypes.Adresse arg0_in = delistation.datatypes.AdresseHelper.read(_is);
        delistation.datatypes.ColisHolder arg1_inout = new delistation.datatypes.ColisHolder();
        arg1_inout.value = delistation.datatypes.ColisHelper.read(_is);

        try
        {
            short _arg_result = deposer(arg0_in, arg1_inout);

            _output = handler.createReply();
            _output.write_short(_arg_result);

            delistation.datatypes.ColisHelper.write(_output,arg1_inout.value);
        }
        catch (delistation.exceptions.ExceptionDestinationMemeZone _exception)
        {
            _output = handler.createExceptionReply();
            delistation.exceptions.ExceptionDestinationMemeZoneHelper.write(_output,_exception);
        }
        catch (delistation.exceptions.ExceptionDestinataireInconnue _exception)
        {
            _output = handler.createExceptionReply();
            delistation.exceptions.ExceptionDestinataireInconnueHelper.write(_output,_exception);
        }
        catch (delistation.exceptions.ExceptionErreurPaiement _exception)
        {
            _output = handler.createExceptionReply();
            delistation.exceptions.ExceptionErreurPaiementHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_majEtatColis(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();
        delistation.datatypes.etatColis arg1_in = delistation.datatypes.etatColisHelper.read(_is);

        majEtatColis(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_demandeEtat(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        try
        {
            delistation.datatypes.etatColis _arg_result = demandeEtat(arg0_in);

            _output = handler.createReply();
            delistation.datatypes.etatColisHelper.write(_output,_arg_result);

        }
        catch (delistation.exceptions.ExceptionColisInconnu _exception)
        {
            _output = handler.createExceptionReply();
            delistation.exceptions.ExceptionColisInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_supprimerColis(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        supprimerColis(arg0_in);

        _output = handler.createReply();

        return _output;
    }

}
