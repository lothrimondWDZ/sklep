package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import model.Pants;
import model.Shirt;

/**
 * 
 * Klasa zawierająca listę koszul dostępnych w sklepie
 *
 */
public class ShirtList {

	/**
	 * Lista koszul dostępnych w sklepie
	 */
	private List<Shirt> shirtList;
	
	public ShirtList() {
		shirtList = new ArrayList<Shirt>();
	}

	/**
	 * Dodanie nowej koszuli
	 * @param {@link Shirt} nowa koszula
	 */
	public void add(final Shirt s) {
		shirtList.add(s);
	}

	/**
	 * Usunięcie koszuli
	 * @param {@link Shirt} koszula do usunięcia
	 */
	public void remove(final Shirt shirt) {
		shirtList.remove(shirt);
	}

	/**
	 * Edycja istniejącej koszuli
	 * @param {@link Shirt} koszula ze zmienionymi parametrami
	 * @param {@link Integer} index istniejącej koszuli
	 */
	public void edit(final Shirt s, final Integer index) {
		shirtList.set(index, s);
	}

	/**
	 * Pobierz istniejącą koszulę
	 * @param {@link Integer} index koszuli do pobrania
	 * @return {@link Shirt} znaleziona koszula
	 */
	public Shirt get(Integer index) {
		return shirtList.get(index);
	}

	/**
	 * Zwrócenie koszul w postaci odpowiedniej dla tabeli ({@link JTable})
	 * @return {@link Object} gotowe dane do tabeli
	 */
	public Object[][] getTableModel() {
		Object[][] data = new Object[shirtList.size()][5];
		int i = 0;
		for (Shirt s : shirtList) {
			data[i][0] = s.getGender().getName();
			data[i][1] = s.getName();
			data[i][2] = s.getPrice().toString();
			data[i][3] = s.getColor();
			data[i][4] = s.getBrand();
			i++;
		}
		return data;
	}

	/**
	 * Pobranie listy koszul dostępnych w sklepie
	 * @return {@link List} lista koszul dostępnych w sklepie
	 */
	public List <Shirt>getList() {
		return shirtList;
	}

	/**
	 * Import listy koszul
	 * @param {@link List} lista koszul do zaimportowania
	 */
	public void setList(List<Shirt> shirtList) {
		this.shirtList = shirtList;
	}
}
