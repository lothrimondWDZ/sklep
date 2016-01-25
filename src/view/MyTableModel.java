package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
    private List list;
    private final String headers[];

    public MyTableModel(List list, String[] headers) {
	this.list = list;
	this.headers = headers;
    }

    @Override
    public int getRowCount() {
	return list.size();
    }

    @Override
    public int getColumnCount() {
	return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
	return list.get(rowIndex);
    }

    @Override
    public void setValueAt(Object object, int rowIndex, int columnIndex) {

    }

    @Override
    public String getColumnName(int column) {
	return headers[column];
    }

}
