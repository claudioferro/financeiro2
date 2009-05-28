/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Financeiro.bo;

import Financeiro.to.ContaCorrenteTo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Hugo Fabrício
 */
public class ContaCorrenteConverter implements Converter {

    public Object getAsObject(FacesContext context, UIComponent component, String codConta) {
        ContaCorrenteTo contaCorrenteTo = new ContaCorrenteTo();
        contaCorrenteTo.setCodContaCorrente(Integer.parseInt(codConta));
        return contaCorrenteTo;
    }

    public String getAsString(FacesContext context, UIComponent component, Object classContaCorrenteTo) {
       if (classContaCorrenteTo == null) return "sem valor";
        ContaCorrenteTo contaCorrenteTo = (ContaCorrenteTo) classContaCorrenteTo;
        return contaCorrenteTo.getCodContaCorrente().toString();
    }

}
