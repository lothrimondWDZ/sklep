package view;

import java.util.ArrayList;
import java.util.List;

import model.Tshirt;

public class TShirtList {

	private List<Tshirt> tshirtList;
	
	public TShirtList() {
		tshirtList = new ArrayList<Tshirt>();
	}

	public void add(final Tshirt t) {
		tshirtList.add(t);
	}

	public void remove(final Tshirt tshirt) {
		tshirtList.remove(tshirt);
	}

	public void edit(final Tshirt t, final Integer index) {
		tshirtList.set(index, t);
	}

	public Tshirt get(Integer index) {
		return tshirtList.get(index);
	}

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
}
