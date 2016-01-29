package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import model.Tshirt;
/**
 * 
 * Klasa zawierająca listę koszulek dostępnych w sklepie
 *
 */
public class TShirtList {

	/**
	 * lista koszulek dostępnych w sklepie
	 */
	private List<Tshirt> tshirtList;
	
	public TShirtList() {
		tshirtList = new ArrayList<Tshirt>();
	}

	/**
	 * Dodanie nowej koszulki
	 * @param {@link Tshirt} nowa koszulka
	 */
	public void add(final Tshirt t) {
		tshirtList.add(t);
	}

	/**
	 * Usunięcie koszulki
	 * @param {@link Tshirt} koszulka do usunięcia
	 */
	public void remove(final Tshirt tshirt) {
		tshirtList.remove(tshirt);
	}

	/**
	 * Edycja istniejącej koszulki
	 * @param {@link Tshirt} koszulka z nowymi parametrami
	 * @param {@link Integer} index koszulki
	 */
	public void edit(final Tshirt t, final Integer index) {
		tshirtList.set(index, t);
	}

	/**
	 * Pobranie istniejącej koszulki
	 * @param {@link Integer} index koszulki
	 * @return {@link Tshirt} znaleziona koszulka
	 */
	public Tshirt get(Integer index) {
		return tshirtList.get(index);
	}

	/**
	 * Przygotowanie listy koszulek do wyświetlenia w tabeli ({@link JTable})
	 * @return {@link Object} dane do tabeli koszulek
	 */
	public Object[][] getTableModel() {
		Object[][] data = new Object[tshirtList.size()][5];
		int i = 0;
		for (Tshirt t : tshirtList) {
			data[i][0] = t.getGender().getName();
			data[i][1] = t.getName();
			data[i][2] = t.getPrice().toString();
			data[i][3] = t.getColor();
			data[i][4] = t.getBrand();
			i++;
		}
		return data;
	}

	/**
	 * Pobranie listy koszulek dostępnych w sklepie
	 * @return {@link List} lista koszulek
	 */
	public List<Tshirt> getList() {
		return tshirtList;
	}

	/**
	 * Import listy koszulek
	 * @param {@link List} lista koszulek do zaimportowania
	 */
	public void setList(List<Tshirt> tshirtList) {
		this.tshirtList = tshirtList;
	}
}
