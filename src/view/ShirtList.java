package view;

import java.util.ArrayList;
import java.util.List;

import model.Pants;
import model.Shirt;

public class ShirtList {

	private List<Shirt> shirtList;
	
	public ShirtList() {
		shirtList = new ArrayList<Shirt>();
	}

	public void add(final Shirt s) {
		shirtList.add(s);
	}

	public void remove(final Shirt shirt) {
		shirtList.remove(shirt);
	}

	public void edit(final Shirt s, final Integer index) {
		shirtList.set(index, s);
	}

	public Shirt get(Integer index) {
		return shirtList.get(index);
	}

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
}
