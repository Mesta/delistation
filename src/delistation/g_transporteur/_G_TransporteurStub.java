package delistation.g_transporteur;

/**
 * Interface definition : G_Transporteur
 * 
 * @author OpenORB Compiler
 */
public class _G_TransporteurStub extends org.omg.CORBA.portable.ObjectImpl
        implements G_Transporteur
{
    static final String[] _ids_list =
    {
        "IDL:delistation/g_transporteur/G_Transporteur:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = delistation.g_transporteur.G_TransporteurOperations.class;

    /**
     * Operation getCoursesEnAttente
     */
    public delistation.datatypes.Course[] getCoursesEnAttente()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getCoursesEnAttente",true);
                    _input = this._invoke(_output);
                    delistation.datatypes.Course[] _arg_ret = delistation.datatypes.LCoursesHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCoursesEnAttente",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_transporteur.G_TransporteurOperations _self = (delistation.g_transporteur.G_TransporteurOperations) _so.servant;
                try
                {
                    return _self.getCoursesEnAttente();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation authentifier
     */
    public boolean authentifier(short noTransp, String MdP)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("authentifier",true);
                    _output.write_short(noTransp);
                    _output.write_string(MdP);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("authentifier",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_transporteur.G_TransporteurOperations _self = (delistation.g_transporteur.G_TransporteurOperations) _so.servant;
                try
                {
                    return _self.authentifier( noTransp,  MdP);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getTransporteur
     */
    public delistation.datatypes.Transporteur getTransporteur(short noTransp)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getTransporteur",true);
                    _output.write_short(noTransp);
                    _input = this._invoke(_output);
                    delistation.datatypes.Transporteur _arg_ret = delistation.datatypes.TransporteurHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getTransporteur",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_transporteur.G_TransporteurOperations _self = (delistation.g_transporteur.G_TransporteurOperations) _so.servant;
                try
                {
                    return _self.getTransporteur( noTransp);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getRIB
     */
    public String getRIB(short noTransp)
        throws delistation.exceptions.ExceptionTransporteurInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getRIB",true);
                    _output.write_short(noTransp);
                    _input = this._invoke(_output);
                    String _arg_ret = _input.read_string();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(delistation.exceptions.ExceptionTransporteurInconnuHelper.id()))
                    {
                        throw delistation.exceptions.ExceptionTransporteurInconnuHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getRIB",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_transporteur.G_TransporteurOperations _self = (delistation.g_transporteur.G_TransporteurOperations) _so.servant;
                try
                {
                    return _self.getRIB( noTransp);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation enregistrerNouveauTransport
     */
    public void enregistrerNouveauTransport(short noColis, String IORG_Colis, short montant)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregistrerNouveauTransport",false);
                    _output.write_short(noColis);
                    _output.write_string(IORG_Colis);
                    _output.write_short(montant);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregistrerNouveauTransport",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_transporteur.G_TransporteurOperations _self = (delistation.g_transporteur.G_TransporteurOperations) _so.servant;
                try
                {
                    _self.enregistrerNouveauTransport( noColis,  IORG_Colis,  montant);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation reenregistrerTransport
     */
    public void reenregistrerTransport(delistation.datatypes.Course p_course)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("reenregistrerTransport",false);
                    delistation.datatypes.CourseHelper.write(_output,p_course);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("reenregistrerTransport",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_transporteur.G_TransporteurOperations _self = (delistation.g_transporteur.G_TransporteurOperations) _so.servant;
                try
                {
                    _self.reenregistrerTransport( p_course);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation demandeSuppression
     */
    public void demandeSuppression(short noCourse)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("demandeSuppression",false);
                    _output.write_short(noCourse);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("demandeSuppression",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_transporteur.G_TransporteurOperations _self = (delistation.g_transporteur.G_TransporteurOperations) _so.servant;
                try
                {
                    _self.demandeSuppression( noCourse);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
