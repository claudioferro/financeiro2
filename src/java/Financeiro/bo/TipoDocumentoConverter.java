package Financeiro.bo;

import Financeiro.to.TipoDocumentoTo;
import javax.faces.component.UIComponent;

import javax.faces.context.FacesContext;

import javax.faces.convert.Converter;

/***********************************************************************
 Carlos Wagner
 ***********************************************************************/

public class TipoDocumentoConverter implements Converter {

    /** Creates a new instance of TipoDocumentoConverter */
    public TipoDocumentoConverter() {
    }


    public String getAsString(FacesContext context, UIComponent component, Object classTipoDocumentoTo) {
        if (classTipoDocumentoTo == null) return "sem valor";
        TipoDocumentoTo tipodocto = (TipoDocumentoTo) classTipoDocumentoTo;
        if(tipodocto.getCodTipoDocumento() == null){
            tipodocto.setCodTipoDocumento(0);
        }
        return tipodocto.getCodTipoDocumento().toString();

    }

    public Object getAsObject(FacesContext context, UIComponent component, String codtipodoc) {
        TipoDocumentoTo tipodocto = new TipoDocumentoTo();
        tipodocto.setCodTipoDocumento(Integer.parseInt(codtipodoc));
        return tipodocto;
    }
}
