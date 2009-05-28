package Financeiro.bo;

import Financeiro.to.FormaPagamentoTo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/*********************************************************************
 Autor : Carlos Wagner
 ***********************************************************************/

public class FormaPagamentoConverter implements Converter {

    public FormaPagamentoConverter() {
    }

    public Object getAsObject(FacesContext context, UIComponent component, String newCodFormaPagamento) {
        FormaPagamentoTo formaPagtoTo = new FormaPagamentoTo();

        try {
            formaPagtoTo.setCodFormaPagamento(Integer.parseInt(newCodFormaPagamento));
        } catch (Exception e) {
        }

        return formaPagtoTo;
    }

    public String getAsString(FacesContext context, UIComponent component, Object classFormaPagamentoTo) {
        if (classFormaPagamentoTo == null){
           return "sem valor";
        }
        FormaPagamentoTo formaPagtoTo = (FormaPagamentoTo) classFormaPagamentoTo;
        return formaPagtoTo.getCodFormaPagamento().toString();
    }
}
