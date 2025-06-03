/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.ctrl.dateconverter;

import com.svm.lrp.nfr.lnd.cbean.LandingPageCBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author salomi.a
 */
@FacesConverter("dateConveter")
public class DateConveter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println("==getAsObject====");
        if (value != null && value.trim().length() > 0) {
           return  getHelper().getDateConverter(value);
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object != null) {
            return object.toString();
        } else {
            return null;
        }
    }
    public LandingPageCBean getHelper() {
       FacesContext context = FacesContext.getCurrentInstance();
       return (LandingPageCBean) context.getApplication().evaluateExpressionGet(context, "#{LandingPageCBean}", LandingPageCBean.class); 
    }
}
