package delistation.g_transporteur;

/**
 * Interface definition : G_Transporteur
 * 
 * @author OpenORB Compiler
 */
public abstract class G_TransporteurPOA extends org.omg.PortableServer.Servant
        implements G_TransporteurOperations, org.omg.CORBA.portable.InvokeHandler
{
    public G_Transporteur _this()
    {
        return G_TransporteurHelper.narrow(_this_object());
    }

    public G_Transporteur _this(org.omg.CORBA.ORB orb)
    {
        return G_TransporteurHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:delistation/g_transporteur/G_Transporteur:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("authentifier")) {
                return _invoke_authentifier(_is, handler);
        } else if (opName.equals("demandeSuppression")) {
                return _invoke_demandeSuppression(_is, handler);
        } else if (opName.equals("enregistrerNouveauTransport")) {
                return _invoke_enregistrerNouveauTransport(_is, handler);
        } else if (opName.equals("getCoursesEnAttente")) {
                return _invoke_getCoursesEnAttente(_is, handler);
        } else if (opName.equals("getRIB")) {
                return _invoke_getRIB(_is, handler);
        } else if (opName.equals("getTransporteur")) {
                return _invoke_getTransporteur(_is, handler);
        } else if (opName.equals("reenregistrerTransport")) {
                return _invoke_reenregistrerTransport(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_getCoursesEnAttente(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        delistation.datatypes.Course[] _arg_result = getCoursesEnAttente();

        _output = handler.createReply();
        delistation.datatypes.LCoursesHelper.write(_output,_arg_result);

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

    private org.omg.CORBA.portable.OutputStream _invoke_getTransporteur(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        delistation.datatypes.Transporteur _arg_result = getTransporteur(arg0_in);

        _output = handler.createReply();
        delistation.datatypes.TransporteurHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getRIB(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        try
        {
            String _arg_result = getRIB(arg0_in);

            _output = handler.createReply();
            _output.write_string(_arg_result);

        }
        catch (delistation.exceptions.ExceptionTransporteurInconnu _exception)
        {
            _output = handler.createExceptionReply();
            delistation.exceptions.ExceptionTransporteurInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerNouveauTransport(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();
        String arg1_in = _is.read_string();
        short arg2_in = _is.read_short();

        enregistrerNouveauTransport(arg0_in, arg1_in, arg2_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_reenregistrerTransport(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        delistation.datatypes.Course arg0_in = delistation.datatypes.CourseHelper.read(_is);

        reenregistrerTransport(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_demandeSuppression(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        demandeSuppression(arg0_in);

        _output = handler.createReply();

        return _output;
    }

}
