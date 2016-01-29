package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import model.Jacket;
import model.Pants;

/**
 * 
 * Klasa zawieraj¹ca listê spodni znajdujacych siê aktualnie w sklepie
 *
 */
public class PantsList {
    /**
     * Lista dostêpnych spodni
     */
    private List<Pants> pantsList;

    public PantsList() {
	pantsList = new ArrayList<Pants>();
    }

    /**
     * @param {@link
     *            Pants} dodanie nowych spodni
     */
    public void add(final Pants p) {
	pantsList.add(p);
    }

    /**
     * @param {@link
     *            Pants} usniêcie spodni
     */
    public void remove(final Pants pants) {
	pantsList.remove(pants);
    }

    /**
     * Edycja istniej¹cych spodni
     * 
     * @param Pants
     *            ze zmienionymi parametrami
     * @param index
     *            wskazuj¹cy na po³o¿enie spodni do zamiany
     */
    public void edit(final Pants p, final Integer index) {
	pantsList.set(index, p);
    }

    /**
     * Pobranie spodni
     * 
     * @param {@link
     *            Integer} index
     * @return {@link Jacket} znalezione spodni
     */
    public Pants get(Integer index) {
	return pantsList.get(index);
    }

    /**
     * Przekszta³cenie spodni na model dla tabeli na widoku ({@link JTable})
     * 
     * @return {@link Object} dane do wyœwietlenia w tabeli
     */
    public Object[][] getTableModel() {
	Object[][] data = new Object[pantsList.size()][7];
	int i = 0;
	for (Pants p : pantsList) {
	    data[i][0] = p.getGender().getName();
	    data[i][1] = p.getName();
	    data[i][2] = p.getPrice().toString();
	    data[i][3] = p.getColor();
	    data[i][4] = p.getBrand();
	    data[i][5] = p.getWaistSize().toString();
	    data[i][6] = p.getLength().toString();
	    i++;
	}
	return data;
    }

    /**
     * Pobranie listy dostêpnych spodni
     * 
     * @return {@link List} lista spodni
     */
    public List<Pants> getList() {
	return pantsList;
    }

    /**
     * Ustawienie listy spodni (import)
     * 
     * @param {@link
     *            List} nowa lista dostêpnych spodni
     */
    public void setList(List<Pants> pantsList) {
	this.pantsList = pantsList;
    }

}
