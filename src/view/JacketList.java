package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import model.Jacket;

/**
 * 
 * Klasa zawierająca listę kurtek znajdujących się aktualnie w sklepie
 *
 */
public class JacketList {

	/**
	 * lista dostępnych kurtek
	 */
    private List<Jacket> jacketsList;

    public JacketList() {
	jacketsList = new ArrayList<Jacket>();
    }

    /**
     * @param {@link Jacket} dodanie nowej kurtki
     */
    public void add(final Jacket j) {
	jacketsList.add(j);
    }

    /**
     * @param {@link Jacket} usunięcie kurtki
     */
    public void remove(final Jacket j) {
	jacketsList.remove(j);
    }

    /**
     * Edycja istniejącej kurtki
     * @param kurtka ze zmienionymi parametrami
     * @param index wskazujący na położenie kurtki do zamiany
     */
    public void edit(final Jacket j, final Integer index) {
	jacketsList.set(index, j);
    }

    /**
     * Pobranie kurtki
     * @param {@link Integer} index
     * @return {@link Jacket} znaleziona kurtka
     */
    public Jacket get(Integer index) {
	return jacketsList.get(index);
    }

    /**
     * Przekształcenie kurtek na model dla tabeli na widoku ({@link JTable})
     * @return {@link Object} dane do wyświetlenia w tabeli
     */
    public Object[][] getTableModel() {
	Object[][] data = new Object[jacketsList.size()][7];
	int i = 0;
	for (Jacket p : jacketsList) {
	    data[i][0] = p.getGender().getName();
	    data[i][1] = p.getName();
	    // data[i][2] = p.getPrice().toString();
	    data[i][3] = p.getColor();
	    data[i][4] = p.getBrand();
	    // data[i][5] = p.getWaistSize().toString();
	    // data[i][6] = p.getLength().toString();
	    i++;
	}
	return data;
    }

    /**
     * Pobranie listy dostępnych kurtek
     * @return {@link List} lista kurtek
     */
	public List<Jacket> getList() {
		return jacketsList;
	}

	/**
	 * Ustawienie listy kurtek (import)
	 * @param {@link List} nowa lista dostępnych kurtek
	 */
	public void setList(List<Jacket> jacketList) {
		this.jacketsList = jacketList;
	}

}
