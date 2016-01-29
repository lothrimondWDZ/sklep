package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import model.Shoes;

/**
 * 
 * Klasa zawierajaca liste butow znajdujacych sie aktualnie w sklepie
 *
 */
public class ShoesList {
    /**
     * Lista dostepnych butow
     */
    private List<Shoes> shoesList;

    public ShoesList() {
	shoesList = new ArrayList<Shoes>();
    }

    /**
     * @param {@link
     *            Shoes} dodanie nowych butow
     */
    public void add(final Shoes p) {
	shoesList.add(p);
    }

    /**
     * @param {@link
     *            Shoes} usniecie butow
     */
    public void remove(final Shoes pants) {
	shoesList.remove(pants);
    }

    /**
     * Edycja istniejacych butow
     * 
     * @param Shoes
     *            ze zmienionymi parametrami
     * @param index
     *            wskazujacy na polozenie butow do zamiany
     */
    public void edit(final Shoes p, final Integer index) {
	shoesList.set(index, p);
    }

    /**
     * Pobranie butow
     * 
     * @param {@link
     *            Integer} index
     * @return {@link Shoes} znalezione buty
     */
    public Shoes get(Integer index) {
	return shoesList.get(index);
    }

    /**
     * Przeksztalcenie butow na model dla tabeli na widoku ({@link JTable})
     * 
     * @return {@link Object} dane do wyswietlenia w tabeli
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
     * Pobranie listy dostepnych butow
     * 
     * @return {@link List} lista butow
     */
    public List<Shoes> getList() {
	return shoesList;
    }

    /**
     * Ustawienie listy butow (import)
     * 
     * @param {@link
     *            List} nowa lista dostepnych butow
     */
    public void setList(List<Shoes> shoesList) {
	this.shoesList = shoesList;
    }

}
