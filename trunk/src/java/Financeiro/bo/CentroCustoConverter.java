package Financeiro.bo;

import Financeiro.to.CentroCustoTo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Hugo Fabrício
 */
public class CentroCustoConverter implements Converter {

      public Object getAsObject(FacesContext context, UIComponent component, String codCentroCusto) {
        CentroCustoTo centroCustoTo = new CentroCustoTo();
        centroCustoTo.setCodCentroCusto(Integer.parseInt(codCentroCusto));
        return centroCustoTo;
    }

    public String getAsString(FacesContext context, UIComponent component, Object classCentroCustoTo) {
        if (classCentroCustoTo == null) return "sem valor";
        CentroCustoTo centroCustoTo = (CentroCustoTo) classCentroCustoTo;
        return centroCustoTo.getCodCentroCusto().toString();

    }
}
