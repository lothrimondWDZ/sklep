package view;

import java.util.ArrayList;
import java.util.List;

import model.Jacket;

public class JacketList {

    private List<Jacket> jacketsList;

    public JacketList() {
	jacketsList = new ArrayList<Jacket>();
    }

    public void add(final Jacket p) {
	jacketsList.add(p);
    }

    public void remove(final Jacket pants) {
	jacketsList.remove(pants);
    }

    public void edit(final Jacket p, final Integer index) {
	jacketsList.set(index, p);
    }

    public Jacket get(Integer index) {
	return jacketsList.get(index);
    }

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

}
