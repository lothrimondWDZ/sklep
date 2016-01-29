package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Promotion;

/**
 * 
 * Klasa zawieraj�ca list� promocji znajdujacych si� aktualnie w sklepie
 *
 */
public class PromotionList {
    /**
     * Lista dost�pnych promocji
     */
    private List<Promotion> promotionsList;

    public PromotionList() {
	promotionsList = new ArrayList<Promotion>();
    }

    /**
     * @param {@link
     *            Promotion} dodanie nowej promocji
     */
    public void add(final Promotion p) {
	promotionsList.add(p);
    }

    /**
     * @param {@link
     *            Promotion} usni�cie promocji
     */
    public void remove(final Promotion promotion) {
	promotionsList.remove(promotion);
    }

    /**
     * Edycja istniej�cej promocji
     * 
     * @param Promotion
     *            ze zmienionymi parametrami
     * @param index
     *            wskazuj�cy na po�o�enie promocji do zamiany
     */
    public void edit(final Promotion p, final Integer index) {
	promotionsList.set(index, p);
    }

    /**
     * Pobranie promocji
     * 
     * @param {@link
     *            Integer} index
     * @return {@link Promotion} znaleziona promocjia
     */
    public Promotion get(Integer index) {
	return promotionsList.get(index);
    }

    /**
     * Uzupe�nienie listy promocji pocz�tkowymi danymi
     */
    public void fileList() {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Promotion p = new Promotion();
	p.setReduction("brak");
	try {
	    p.setStartDate(sdf.parse("01/01/1990"));
	    p.setEndDate(sdf.parse("01/01/2990"));
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	add(p);
	Promotion p1 = new Promotion();
	p1.setReduction("10%");
	try {
	    p1.setStartDate(sdf.parse("01/02/2016"));
	    p1.setEndDate(sdf.parse("20/02/2016"));
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	add(p1);
	Promotion p2 = new Promotion();
	p2.setReduction("50%");
	try {
	    p2.setStartDate(sdf.parse("01/02/2016"));
	    p2.setEndDate(sdf.parse("20/02/2016"));
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	add(p2);
	Promotion p3 = new Promotion();
	p3.setReduction("70%");
	try {
	    p3.setStartDate(sdf.parse("01/02/2016"));
	    p3.setEndDate(sdf.parse("20/02/2016"));
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	add(p3);
    }

}
