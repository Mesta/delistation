package delistation.g_colis;

/**
 * Interface definition : G_Colis
 * 
 * @author OpenORB Compiler
 */
public class _G_ColisStub extends org.omg.CORBA.portable.ObjectImpl
        implements G_Colis
{
    static final String[] _ids_list =
    {
        "IDL:delistation/g_colis/G_Colis:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = delistation.g_colis.G_ColisOperations.class;

    /**
     * Read accessor for getAdresseG_Colis attribute
     * @return the attribute value
     */
    public delistation.datatypes.Adresse getAdresseG_Colis()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_getAdresseG_Colis",true);
                    _input = this._invoke(_output);
                    return delistation.datatypes.AdresseHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_getAdresseG_Colis",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_colis.G_ColisOperations _self = (delistation.g_colis.G_ColisOperations) _so.servant;
                try
                {
                    return _self.getAdresseG_Colis();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getColis
     */
    public delistation.datatypes.Colis getColis(short noColis)
        throws delistation.exceptions.ExceptionColisInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getColis",true);
                    _output.write_short(noColis);
                    _input = this._invoke(_output);
                    delistation.datatypes.Colis _arg_ret = delistation.datatypes.ColisHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(delistation.exceptions.ExceptionColisInconnuHelper.id()))
                    {
                        throw delistation.exceptions.ExceptionColisInconnuHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getColis",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_colis.G_ColisOperations _self = (delistation.g_colis.G_ColisOperations) _so.servant;
                try
                {
                    return _self.getColis( noColis);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation isDestinataire
     */
    public boolean isDestinataire(short noColis, short noAdh)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("isDestinataire",true);
                    _output.write_short(noColis);
                    _output.write_short(noAdh);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("isDestinataire",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_colis.G_ColisOperations _self = (delistation.g_colis.G_ColisOperations) _so.servant;
                try
                {
                    return _self.isDestinataire( noColis,  noAdh);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation deposer
     */
    public short deposer(delistation.datatypes.Adresse adrDest, delistation.datatypes.ColisHolder colis)
        throws delistation.exceptions.ExceptionDestinationMemeZone, delistation.exceptions.ExceptionDestinataireInconnue, delistation.exceptions.ExceptionErreurPaiement
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("deposer",true);
                    delistation.datatypes.AdresseHelper.write(_output,adrDest);
                    delistation.datatypes.ColisHelper.write(_output,colis.value);
                    _input = this._invoke(_output);
                    short _arg_ret = _input.read_short();
                    colis.value = delistation.datatypes.ColisHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(delistation.exceptions.ExceptionDestinationMemeZoneHelper.id()))
                    {
                        throw delistation.exceptions.ExceptionDestinationMemeZoneHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(delistation.exceptions.ExceptionDestinataireInconnueHelper.id()))
                    {
                        throw delistation.exceptions.ExceptionDestinataireInconnueHelper.read(_exception.getInputStream());
                    }

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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deposer",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_colis.G_ColisOperations _self = (delistation.g_colis.G_ColisOperations) _so.servant;
                try
                {
                    return _self.deposer( adrDest,  colis);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation majEtatColis
     */
    public void majEtatColis(short noColis, delistation.datatypes.etatColis etat)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("majEtatColis",false);
                    _output.write_short(noColis);
                    delistation.datatypes.etatColisHelper.write(_output,etat);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("majEtatColis",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_colis.G_ColisOperations _self = (delistation.g_colis.G_ColisOperations) _so.servant;
                try
                {
                    _self.majEtatColis( noColis,  etat);
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
     * Operation demandeEtat
     */
    public delistation.datatypes.etatColis demandeEtat(short noColis)
        throws delistation.exceptions.ExceptionColisInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("demandeEtat",true);
                    _output.write_short(noColis);
                    _input = this._invoke(_output);
                    delistation.datatypes.etatColis _arg_ret = delistation.datatypes.etatColisHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(delistation.exceptions.ExceptionColisInconnuHelper.id()))
                    {
                        throw delistation.exceptions.ExceptionColisInconnuHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("demandeEtat",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_colis.G_ColisOperations _self = (delistation.g_colis.G_ColisOperations) _so.servant;
                try
                {
                    return _self.demandeEtat( noColis);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation supprimerColis
     */
    public void supprimerColis(short noColis)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("supprimerColis",false);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("supprimerColis",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_colis.G_ColisOperations _self = (delistation.g_colis.G_ColisOperations) _so.servant;
                try
                {
                    _self.supprimerColis( noColis);
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
