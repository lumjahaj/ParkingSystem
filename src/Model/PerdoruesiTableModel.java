package Model;

import BL.Perdoruesi;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class PerdoruesiTableModel extends AbstractTableModel {
    
    private final String [] columnNames = {"Perdoruesi ID","Username","Password","Roli ID"};
    
    private List <Perdoruesi> data;
    
    public PerdoruesiTableModel(List<Perdoruesi>data){
        this.data = data;
    }

    public PerdoruesiTableModel() {
   
    }
    public void add(List<Perdoruesi>data){
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public String getColumnName(int col){
        return columnNames[col];
    }
    public void remove(int row){
        data.remove(row);
    }

    public Perdoruesi getPerdoruesi(int index){
        return data.get(index);
    }
     public String getDate (Date date){
        DateFormat da = new SimpleDateFormat("dd/MM/yyyy");
        return da.format(date);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Perdoruesi s = (Perdoruesi)data.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return s.getPerdoruesiID();
            case 1:
                return s.getUsername();
            case 2:
                return s.getPassword().length() + " characters";
            case 3:
                return s.getRoliID().getEmriRolit();
                
            default:
                return null;
        }
    }
        
    }