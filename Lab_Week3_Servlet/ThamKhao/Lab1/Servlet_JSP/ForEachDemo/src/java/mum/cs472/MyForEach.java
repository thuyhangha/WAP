/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs472;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author SOKLY
 */
public class MyForEach extends SimpleTagSupport {

    private Object[] items;
    private String var;

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut(); 
        int rows = items.length;
        /* invoke body on each row of the input table */
        for (int i = 0; i < rows; i++) {
            /* set an attribute in this page (name=var, value=items[i]) */
            getJspContext().setAttribute(var, items[i]);
            /* invoke the body for the next row in the table */
            getJspBody().invoke(null);
        }
    }

    public void setItems(Object[] items) {
        this.items = items;
    }

    public void setVar(String var) {
        this.var = var;
    }
}
