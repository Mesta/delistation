package delistation.g_facturation;

/**
 * Interface definition : G_Facturation
 * 
 * @author OpenORB Compiler
 */
public class _G_FacturationStub extends org.omg.CORBA.portable.ObjectImpl
        implements G_Facturation
{
    static final String[] _ids_list =
    {
        "IDL:delistation/g_facturation/G_Facturation:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = delistation.g_facturation.G_FacturationOperations.class;

    /**
     * Operation creerCompte
     */
    public boolean creerCompte(short noAdh, delistation.datatypes.CompteMode createMode)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("creerCompte",true);
                    _output.write_short(noAdh);
                    delistation.datatypes.CompteModeHelper.write(_output,createMode);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("creerCompte",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_facturation.G_FacturationOperations _self = (delistation.g_facturation.G_FacturationOperations) _so.servant;
                try
                {
                    return _self.creerCompte( noAdh,  createMode);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation factureAdhesion
     */
    public short factureAdhesion(String RIB)
        throws delistation.exceptions.ExceptionErreurPaiement
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("factureAdhesion",true);
                    _output.write_string(RIB);
                    _input = this._invoke(_output);
                    short _arg_ret = _input.read_short();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(delistation.exceptions.ExceptionErreurPaiementHelper.id()))
                    {
                        throw delistation.exceptions.ExceptionErreurPaiementHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("factureAdhesion",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_facturation.G_FacturationOperations _self = (delistation.g_facturation.G_FacturationOperations) _so.servant;
                try
                {
                    return _self.factureAdhesion( RIB);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation devisTransport
     */
    public short devisTransport(delistation.datatypes.Zone zoneDep, delistation.datatypes.Zone zoneDest)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("devisTransport",true);
                    delistation.datatypes.ZoneHelper.write(_output,zoneDep);
                    delistation.datatypes.ZoneHelper.write(_output,zoneDest);
                    _input = this._invoke(_output);
                    short _arg_ret = _input.read_short();
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("devisTransport",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_facturation.G_FacturationOperations _self = (delistation.g_facturation.G_FacturationOperations) _so.servant;
                try
                {
                    return _self.devisTransport( zoneDep,  zoneDest);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation debiterAdherent
     */
    public boolean debiterAdherent(String RIB, short montant)
        throws delistation.exceptions.ExceptionErreurPaiement
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("debiterAdherent",true);
                    _output.write_string(RIB);
                    _output.write_short(montant);
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
                    if (_exception_id.equals(delistation.exceptions.ExceptionErreurPaiementHelper.id()))
                    {
                        throw delistation.exceptions.ExceptionErreurPaiementHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("debiterAdherent",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_facturation.G_FacturationOperations _self = (delistation.g_facturation.G_FacturationOperations) _so.servant;
                try
                {
                    return _self.debiterAdherent( RIB,  montant);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation crediterTransport
     */
    public void crediterTransport(String RIB, short montant)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("crediterTransport",false);
                    _output.write_string(RIB);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("crediterTransport",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_facturation.G_FacturationOperations _self = (delistation.g_facturation.G_FacturationOperations) _so.servant;
                try
                {
                    _self.crediterTransport( RIB,  montant);
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
