package Model;

import BL.Shoferi;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ShoferiTableModel extends AbstractTableModel {
    
    private final String [] columnNames = {"Nr.i Patentes","Emri","Mbiemri","Nr.i telefonit"};
    
    private List <Shoferi> data;
    
    public ShoferiTableModel(List<Shoferi>data){
        this.data = data;
    }

    public ShoferiTableModel() {
   
    }
    public void add(List<Shoferi>data){
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

    public Shoferi getShoferi(int index){
        return data.get(index);
    }
     public String getDate (Date date){
        DateFormat da = new SimpleDateFormat("dd/MM/yyyy");
        return da.format(date);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Shoferi s = (Shoferi)data.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return s.getNrPatentes();
            case 1:
                return s.getEmri();
            case 2:
                return s.getMbiemri();  
            case 3:
                return s.getNrTelefonit();
            
            default:
                return null;
        }
    }
        
    }