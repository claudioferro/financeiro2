package Financeiro.bo;

import Financeiro.to.TipoClienteTo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Hugo Fabrício
 */
public class TipoClienteConverter implements Converter {

    public Object getAsObject(FacesContext context, UIComponent component, String codTipoCliente) {
        TipoClienteTo tipoclienteto = new TipoClienteTo();
        tipoclienteto.setCodTipoCliente(Integer.parseInt(codTipoCliente));
        return tipoclienteto;
    }

    public String getAsString(FacesContext context, UIComponent component, Object classTipoClienteTo) {
        if (classTipoClienteTo == null) {
            return "sem valor";
        }
        TipoClienteTo tipoClienteTo = (TipoClienteTo) classTipoClienteTo;
        return tipoClienteTo.getCodTipoCliente().toString();
    }
}
