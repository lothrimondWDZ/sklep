package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import model.Jacket;
import model.Pants;

/**
 * 
 * Klasa zawierajaca liste spodni znajdujacych sie aktualnie w sklepie
 *
 */
public class PantsList {
    /**
     * Lista dostepnych spodni
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
     *            Pants} usuniecie spodni
     */
    public void remove(final Pants pants) {
	pantsList.remove(pants);
    }

    /**
     * Edycja istniejacych spodni
     * 
     * @param Pants
     *            ze zmienionymi parametrami
     * @param index
     *            wskazujacy na polozenie spodni do zamiany
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
     * Przeksztalcenie spodni na model dla tabeli na widoku ({@link JTable})
     * 
     * @return {@link Object} dane do wyswietlenia w tabeli
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
     * Pobranie listy dostepnych spodni
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
     *            List} nowa lista dostepnych spodni
     */
    public void setList(List<Pants> pantsList) {
	this.pantsList = pantsList;
    }

}
