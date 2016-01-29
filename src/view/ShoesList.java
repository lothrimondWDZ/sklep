package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import model.Shoes;

/**
 * 
 * Klasa zawieraj�ca list� but�w znajdujacych si� aktualnie w sklepie
 *
 */
public class ShoesList {
    /**
     * Lista dost�pnych but�w
     */
    private List<Shoes> shoesList;

    public ShoesList() {
	shoesList = new ArrayList<Shoes>();
    }

    /**
     * @param {@link
     *            Shoes} dodanie nowych but�w
     */
    public void add(final Shoes p) {
	shoesList.add(p);
    }

    /**
     * @param {@link
     *            Shoes} usni�cie but�w
     */
    public void remove(final Shoes pants) {
	shoesList.remove(pants);
    }

    /**
     * Edycja istniej�cych but�w
     * 
     * @param Shoes
     *            ze zmienionymi parametrami
     * @param index
     *            wskazuj�cy na po�o�enie but�w do zamiany
     */
    public void edit(final Shoes p, final Integer index) {
	shoesList.set(index, p);
    }

    /**
     * Pobranie but�w
     * 
     * @param {@link
     *            Integer} index
     * @return {@link Shoes} znalezione buty
     */
    public Shoes get(Integer index) {
	return shoesList.get(index);
    }

    /**
     * Przekszta�cenie byt�w na model dla tabeli na widoku ({@link JTable})
     * 
     * @return {@link Object} dane do wy�wietlenia w tabeli
     */
    public Object[][] getTableModel() {
	Object[][] data = new Object[shoesList.size()][7];
	int i = 0;
	for (Shoes p : shoesList) {
	    data[i][0] = p.getGender().getName();
	    data[i][1] = p.getName();
	    data[i][2] = p.getPrice().toString();
	    data[i][3] = p.getColor();
	    data[i][4] = p.getBrand();
	    data[i][5] = p.getSize().toString();
	    i++;
	}
	return data;
    }

    /**
     * Pobranie listy dost�pnych but�w
     * 
     * @return {@link List} lista but�w
     */
    public List<Shoes> getList() {
	return shoesList;
    }

    /**
     * Ustawienie listy but�w (import)
     * 
     * @param {@link
     *            List} nowa lista dost�pnych but�w
     */
    public void setList(List<Shoes> shoesList) {
	this.shoesList = shoesList;
    }

}
