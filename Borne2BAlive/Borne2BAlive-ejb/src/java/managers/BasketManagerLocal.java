/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import Product.Optional;
import java.util.ArrayList;
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

    public float getOptionPriceApplied(String[] optionId);

    public ArrayList<Optional> getOptionList(String[] optionId);

    public OrderInfo plusItem(OrderInfo o, int index);

    public OrderInfo minusItem(OrderInfo o, int index);

    public ArrayList<Optional> mergeOptionList(ArrayList<Optional> a, ArrayList<Optional> b);

    public float mergeOptionPriceApplied(float a, float b);

    
}
