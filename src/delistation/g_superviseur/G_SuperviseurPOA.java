package delistation.g_superviseur;

/**
 * Interface definition : G_Superviseur
 * 
 * @author OpenORB Compiler
 */
public abstract class G_SuperviseurPOA extends org.omg.PortableServer.Servant
        implements G_SuperviseurOperations, org.omg.CORBA.portable.InvokeHandler
{
    public G_Superviseur _this()
    {
        return G_SuperviseurHelper.narrow(_this_object());
    }

    public G_Superviseur _this(org.omg.CORBA.ORB orb)
    {
        return G_SuperviseurHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:delistation/g_superviseur/G_Superviseur:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("_get_CourseEnCours")) {
                return _invoke__get_CourseEnCours(_is, handler);
        } else if (opName.equals("cloreTransport")) {
                return _invoke_cloreTransport(_is, handler);
        } else if (opName.equals("enregistrerPriseEnCharge")) {
                return _invoke_enregistrerPriseEnCharge(_is, handler);
        } else if (opName.equals("estEnRetard")) {
                return _invoke_estEnRetard(_is, handler);
        } else if (opName.equals("rechercheCourseEnCours")) {
                return _invoke_rechercheCourseEnCours(_is, handler);
        } else if (opName.equals("verifierTransporteur")) {
                return _invoke_verifierTransporteur(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_CourseEnCours(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        delistation.datatypes.Course[] arg = CourseEnCours();
        _output = handler.createReply();
        delistation.datatypes.LCoursesHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_rechercheCourseEnCours(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        delistation.datatypes.Course[] _arg_result = rechercheCourseEnCours(arg0_in);

        _output = handler.createReply();
        delistation.datatypes.LCoursesHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_cloreTransport(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        cloreTransport(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerPriseEnCharge(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        delistation.datatypes.Course arg0_in = delistation.datatypes.CourseHelper.read(_is);

        try
        {
            boolean _arg_result = enregistrerPriseEnCharge(arg0_in);

            _output = handler.createReply();
            _output.write_boolean(_arg_result);

        }
        catch (delistation.exceptions.ExceptionCourseDejaPrise _exception)
        {
            _output = handler.createExceptionReply();
            delistation.exceptions.ExceptionCourseDejaPriseHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierTransporteur(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();
        short arg1_in = _is.read_short();

        try
        {
            delistation.datatypes.Course _arg_result = verifierTransporteur(arg0_in, arg1_in);

            _output = handler.createReply();
            delistation.datatypes.CourseHelper.write(_output,_arg_result);

        }
        catch (delistation.exceptions.ExceptionMauvaisTransporteur _exception)
        {
            _output = handler.createExceptionReply();
            delistation.exceptions.ExceptionMauvaisTransporteurHelper.write(_output,_exception);
        }
        catch (delistation.exceptions.ExceptionCourseInconnue _exception)
        {
            _output = handler.createExceptionReply();
            delistation.exceptions.ExceptionCourseInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_estEnRetard(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        boolean _arg_result = estEnRetard(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

}
