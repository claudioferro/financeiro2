/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Financeiro.bo;

import Financeiro.to.CidadeTo;
import javax.faces.component.UIComponent;

import javax.faces.context.FacesContext;

import javax.faces.convert.Converter;

/**
 *
 * @author Hugo Fabrício
 */
public class CidadeConverter implements Converter {

    /** Creates a new instance of CidadeConverter */
    public CidadeConverter() {
    }

    public Object getAsObject(FacesContext context, UIComponent component, String municipio) {
        CidadeTo cidadeto = new CidadeTo();
        cidadeto.setMunicipio(municipio);
        return cidadeto;
    }

    public String getAsString(FacesContext context, UIComponent component, Object classCidadeTo) {
        if (classCidadeTo == null) return "sem valor";
        CidadeTo cidadeto = (CidadeTo) classCidadeTo;
        return cidadeto.getMunicipio();
        
    }
}
