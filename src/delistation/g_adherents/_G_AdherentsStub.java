package delistation.g_adherents;

/**
 * Interface definition : G_Adherents
 * 
 * @author OpenORB Compiler
 */
public class _G_AdherentsStub extends org.omg.CORBA.portable.ObjectImpl
        implements G_Adherents
{
    static final String[] _ids_list =
    {
        "IDL:delistation/g_adherents/G_Adherents:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = delistation.g_adherents.G_AdherentsOperations.class;

    /**
     * Operation adherer
     */
    public short adherer(String nom, String prenom, String adresse, String RIB, org.omg.CORBA.StringHolder noAdh, org.omg.CORBA.StringHolder MdP)
        throws delistation.exceptions.ExceptionErreurPaiement, delistation.exceptions.ExceptionAdresseDejaPrise, delistation.exceptions.ExceptionErreurInscription
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("adherer",true);
                    _output.write_string(nom);
                    _output.write_string(prenom);
                    _output.write_string(adresse);
                    _output.write_string(RIB);
                    _output.write_string(noAdh.value);
                    _output.write_string(MdP.value);
                    _input = this._invoke(_output);
                    short _arg_ret = _input.read_short();
                    noAdh.value = _input.read_string();
                    MdP.value = _input.read_string();
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

                    if (_exception_id.equals(delistation.exceptions.ExceptionAdresseDejaPriseHelper.id()))
                    {
                        throw delistation.exceptions.ExceptionAdresseDejaPriseHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(delistation.exceptions.ExceptionErreurInscriptionHelper.id()))
                    {
                        throw delistation.exceptions.ExceptionErreurInscriptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("adherer",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_adherents.G_AdherentsOperations _self = (delistation.g_adherents.G_AdherentsOperations) _so.servant;
                try
                {
                    return _self.adherer( nom,  prenom,  adresse,  RIB,  noAdh,  MdP);
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
    public boolean authentifier(short noAdh, String MdP)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("authentifier",true);
                    _output.write_short(noAdh);
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
                delistation.g_adherents.G_AdherentsOperations _self = (delistation.g_adherents.G_AdherentsOperations) _so.servant;
                try
                {
                    return _self.authentifier( noAdh,  MdP);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getAdherent
     */
    public delistation.datatypes.Adherent getAdherent(short noAdh)
        throws delistation.exceptions.ExceptionAdherentInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getAdherent",true);
                    _output.write_short(noAdh);
                    _input = this._invoke(_output);
                    delistation.datatypes.Adherent _arg_ret = delistation.datatypes.AdherentHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(delistation.exceptions.ExceptionAdherentInconnuHelper.id()))
                    {
                        throw delistation.exceptions.ExceptionAdherentInconnuHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getAdherent",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_adherents.G_AdherentsOperations _self = (delistation.g_adherents.G_AdherentsOperations) _so.servant;
                try
                {
                    return _self.getAdherent( noAdh);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation majIOR
     */
    public void majIOR(short noAdh, short IOR)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("majIOR",false);
                    _output.write_short(noAdh);
                    _output.write_short(IOR);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("majIOR",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_adherents.G_AdherentsOperations _self = (delistation.g_adherents.G_AdherentsOperations) _so.servant;
                try
                {
                    _self.majIOR( noAdh,  IOR);
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
     * Operation rechercheDestinataire
     */
    public delistation.datatypes.Adherent rechercheDestinataire(delistation.datatypes.Adresse adrDest)
        throws delistation.exceptions.ExceptionDestinataireInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("rechercheDestinataire",true);
                    delistation.datatypes.AdresseHelper.write(_output,adrDest);
                    _input = this._invoke(_output);
                    delistation.datatypes.Adherent _arg_ret = delistation.datatypes.AdherentHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(delistation.exceptions.ExceptionDestinataireInconnueHelper.id()))
                    {
                        throw delistation.exceptions.ExceptionDestinataireInconnueHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("rechercheDestinataire",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_adherents.G_AdherentsOperations _self = (delistation.g_adherents.G_AdherentsOperations) _so.servant;
                try
                {
                    return _self.rechercheDestinataire( adrDest);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation facturer
     */
    public boolean facturer(short noAdh, short montant)
        throws delistation.exceptions.ExceptionErreurPaiement
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("facturer",true);
                    _output.write_short(noAdh);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("facturer",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_adherents.G_AdherentsOperations _self = (delistation.g_adherents.G_AdherentsOperations) _so.servant;
                try
                {
                    return _self.facturer( noAdh,  montant);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation demandeNotificationDepot
     */
    public void demandeNotificationDepot(short noAdh)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("demandeNotificationDepot",false);
                    _output.write_short(noAdh);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("demandeNotificationDepot",_opsClass);
                if (_so == null)
                   continue;
                delistation.g_adherents.G_AdherentsOperations _self = (delistation.g_adherents.G_AdherentsOperations) _so.servant;
                try
                {
                    _self.demandeNotificationDepot( noAdh);
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
