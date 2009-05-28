
package Financeiro.bo;

import Financeiro.to.BancosTo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Hugo Fabrício
 */
public class BancoConverter implements Converter {

    public Object getAsObject(FacesContext context, UIComponent component, String numBanco) {
        BancosTo bancoTo = new BancosTo();
        bancoTo.setNumBanco(numBanco);
        return bancoTo;
    }

    public String getAsString(FacesContext context, UIComponent component, Object classBancoTo) {
        if (classBancoTo == null) return "sem valor";
        BancosTo bancoTo = (BancosTo) classBancoTo;
        return bancoTo.getNumBanco();

    }
}
