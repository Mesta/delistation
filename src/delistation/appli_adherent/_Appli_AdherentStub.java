package delistation.appli_adherent;

/**
 * Interface definition : Appli_Adherent
 * 
 * @author OpenORB Compiler
 */
public class _Appli_AdherentStub extends org.omg.CORBA.portable.ObjectImpl
        implements Appli_Adherent
{
    static final String[] _ids_list =
    {
        "IDL:delistation/appli_adherent/Appli_Adherent:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = delistation.appli_adherent.Appli_AdherentOperations.class;

    /**
     * Operation notifierColis
     */
    public void notifierColis()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("notifierColis",false);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("notifierColis",_opsClass);
                if (_so == null)
                   continue;
                delistation.appli_adherent.Appli_AdherentOperations _self = (delistation.appli_adherent.Appli_AdherentOperations) _so.servant;
                try
                {
                    _self.notifierColis();
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
