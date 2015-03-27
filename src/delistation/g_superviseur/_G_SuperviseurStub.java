package delistation.g_superviseur;

/**
 * Interface definition : G_Superviseur
 * 
 * @author OpenORB Compiler
 */
public class _G_SuperviseurStub extends org.omg.CORBA.portable.ObjectImpl
        implements G_Superviseur
{
    static final String[] _ids_list =
    {
        "IDL:delistation/g_superviseur/G_Superviseur:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = delistation.g_superviseur.G_SuperviseurOperations.class;

    /**
     * Read accessor for CourseEnCours attribute
     * @return the attribute value
     */
    public delistation.datatypes.Course[] CourseEnCours()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_CourseEnCours",true);
                    _input = this._invoke(_output);
                    return delistation.datatypes.LCoursesHelper.read(_input);
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    final String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_CourseEnCours",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_superviseur.G_SuperviseurOperations _self = (delistation.g_superviseur.G_SuperviseurOperations) _so.servant;
                try
                {
                    return _self.CourseEnCours();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation rechercheCourseEnCours
     */
    public delistation.datatypes.Course[] rechercheCourseEnCours(short noAdh)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("rechercheCourseEnCours",true);
                    _output.write_short(noAdh);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("rechercheCourseEnCours",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_superviseur.G_SuperviseurOperations _self = (delistation.g_superviseur.G_SuperviseurOperations) _so.servant;
                try
                {
                    return _self.rechercheCourseEnCours( noAdh);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation cloreTransport
     */
    public void cloreTransport(short noColis)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("cloreTransport",false);
                    _output.write_short(noColis);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("cloreTransport",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_superviseur.G_SuperviseurOperations _self = (delistation.g_superviseur.G_SuperviseurOperations) _so.servant;
                try
                {
                    _self.cloreTransport( noColis);
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
     * Operation enregistrerPriseEnCharge
     */
    public boolean enregistrerPriseEnCharge(delistation.datatypes.Course course)
        throws delistation.exceptions.ExceptionCourseDejaPrise
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregistrerPriseEnCharge",true);
                    delistation.datatypes.CourseHelper.write(_output,course);
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
                    if (_exception_id.equals(delistation.exceptions.ExceptionCourseDejaPriseHelper.id()))
                    {
                        throw delistation.exceptions.ExceptionCourseDejaPriseHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregistrerPriseEnCharge",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_superviseur.G_SuperviseurOperations _self = (delistation.g_superviseur.G_SuperviseurOperations) _so.servant;
                try
                {
                    return _self.enregistrerPriseEnCharge( course);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation verifierTransporteur
     */
    public delistation.datatypes.Course verifierTransporteur(short noTransporteur, short noCourse)
        throws delistation.exceptions.ExceptionMauvaisTransporteur, delistation.exceptions.ExceptionCourseInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierTransporteur",true);
                    _output.write_short(noTransporteur);
                    _output.write_short(noCourse);
                    _input = this._invoke(_output);
                    delistation.datatypes.Course _arg_ret = delistation.datatypes.CourseHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(delistation.exceptions.ExceptionMauvaisTransporteurHelper.id()))
                    {
                        throw delistation.exceptions.ExceptionMauvaisTransporteurHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(delistation.exceptions.ExceptionCourseInconnueHelper.id()))
                    {
                        throw delistation.exceptions.ExceptionCourseInconnueHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierTransporteur",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_superviseur.G_SuperviseurOperations _self = (delistation.g_superviseur.G_SuperviseurOperations) _so.servant;
                try
                {
                    return _self.verifierTransporteur( noTransporteur,  noCourse);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation estEnRetard
     */
    public boolean estEnRetard(short noCourse)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("estEnRetard",true);
                    _output.write_short(noCourse);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("estEnRetard",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_superviseur.G_SuperviseurOperations _self = (delistation.g_superviseur.G_SuperviseurOperations) _so.servant;
                try
                {
                    return _self.estEnRetard( noCourse);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
