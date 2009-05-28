/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Financeiro.bo;

import Financeiro.to.ClienteFornecTo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Hugo Fabrício
 */
public class ClienteFornecConverter implements Converter {

    public ClienteFornecConverter() {
    }

    public Object getAsObject(FacesContext context, UIComponent component, String codcliente) {
        ClienteFornecTo clienteFornec = new ClienteFornecTo();
        try {
            clienteFornec.setCodCliente(Integer.parseInt(codcliente));
        } catch (Exception e) {
        }

        return clienteFornec;
    }

    public String getAsString(FacesContext context, UIComponent component, Object classClienteFornecTo) {
        if (classClienteFornecTo == null) {
            return "sem valor";
        }
        ClienteFornecTo clientFornecTo = (ClienteFornecTo) classClienteFornecTo;
        return clientFornecTo.getCodCliente().toString();
    }
}
