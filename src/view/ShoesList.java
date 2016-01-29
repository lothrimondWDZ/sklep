package view;

import java.util.ArrayList;
import java.util.List;

import model.Shoes;

public class ShoesList {

    private List<Shoes> shoesList;

    public ShoesList() {
	shoesList = new ArrayList<Shoes>();
    }

    public void add(final Shoes p) {
	shoesList.add(p);
    }

    public void remove(final Shoes pants) {
	shoesList.remove(pants);
    }

    public void edit(final Shoes p, final Integer index) {
	shoesList.set(index, p);
    }

    public Shoes get(Integer index) {
	return shoesList.get(index);
    }

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

}
