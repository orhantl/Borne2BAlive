/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import javax.ejb.Local;
import order.Line;
import order.OrderInfo;

/**
 *
 * @author Ludivine
 */
@Local
public interface BasketManagerLocal {

    public float getVATTotal(OrderInfo o);

    //public float getPreTaxeTotal(OrderInfo o);

    public int getItemNumber(OrderInfo o);

    public OrderInfo emptyBasket(OrderInfo o);

    public Line getLine(Long id, float f);

    public OrderInfo removeLine(OrderInfo o, int index);

    
}
