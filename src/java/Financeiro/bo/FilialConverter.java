/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Financeiro.bo;

import Financeiro.to.FilialTo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Hugo Fabrício
 */
public class FilialConverter implements Converter {

    public Object getAsObject(FacesContext context, UIComponent component, String codEmpresa) {
        FilialTo filialTo = new FilialTo();
        try {
            if (codEmpresa.equals("") ){
            codEmpresa ="0";
            }
            filialTo.setCodEmpresa(Integer.parseInt(codEmpresa));
        } catch (Exception e) {
        }
        return filialTo;
    }

    public String getAsString(FacesContext context, UIComponent component, Object classFilialTo) {
        if (classFilialTo == null) {
            return "sem valor";
        }
        FilialTo filialTo = (FilialTo) classFilialTo;
        return filialTo.getCodEmpresa().toString();
    }
}
