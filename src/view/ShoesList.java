package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import model.Shoes;

/**
 * 
 * Klasa zawieraj¹ca listê butów znajdujacych siê aktualnie w sklepie
 *
 */
public class ShoesList {
    /**
     * Lista dostêpnych butów
     */
    private List<Shoes> shoesList;

    public ShoesList() {
	shoesList = new ArrayList<Shoes>();
    }

    /**
     * @param {@link
     *            Shoes} dodanie nowych butów
     */
    public void add(final Shoes p) {
	shoesList.add(p);
    }

    /**
     * @param {@link
     *            Shoes} usniêcie butów
     */
    public void remove(final Shoes pants) {
	shoesList.remove(pants);
    }

    /**
     * Edycja istniej¹cych butów
     * 
     * @param Shoes
     *            ze zmienionymi parametrami
     * @param index
     *            wskazuj¹cy na po³o¿enie butów do zamiany
     */
    public void edit(final Shoes p, final Integer index) {
	shoesList.set(index, p);
    }

    /**
     * Pobranie butów
     * 
     * @param {@link
     *            Integer} index
     * @return {@link Shoes} znalezione buty
     */
    public Shoes get(Integer index) {
	return shoesList.get(index);
    }

    /**
     * Przekszta³cenie bytów na model dla tabeli na widoku ({@link JTable})
     * 
     * @return {@link Object} dane do wyœwietlenia w tabeli
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
     * Pobranie listy dostêpnych butów
     * 
     * @return {@link List} lista butów
     */
    public List<Shoes> getList() {
	return shoesList;
    }

    /**
     * Ustawienie listy butów (import)
     * 
     * @param {@link
     *            List} nowa lista dostêpnych butów
     */
    public void setList(List<Shoes> shoesList) {
	this.shoesList = shoesList;
    }

}
