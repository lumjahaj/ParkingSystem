package Model;

import BL.Automjeti;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class AutomjetiTableModel extends AbstractTableModel {
    
    private final String [] columnNames = {"Nr. i Targes","Lloji i Automjetit","Tipi i Automjetit","Ngjyra e Automjetit","Lloji i Ngjyres","Kategoria e Automjetit"};
    
    private List <Automjeti> data;
    
    public AutomjetiTableModel(List<Automjeti>data){
        this.data = data;
    }

    public AutomjetiTableModel() {
   
    }
    public void add(List<Automjeti>data){
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

    public Automjeti getAutomjeti(int index){
        return data.get(index);
    }
     public String getDate (Date date){
        DateFormat da = new SimpleDateFormat("dd/MM/yyyy");
        return da.format(date);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Automjeti s = (Automjeti)data.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return s.getNrTarges();
            case 1:
                return s.getTipiAutomjetitID().getLlojiAutomjetitID();
            case 2:
                return s.getTipiAutomjetitID();
            case 3:
                return s.getNgjyraAutomjetitID();
            case 4:
                return s.getLlojiNgjyresID();
            case 5:
                return s.getKategoriaAutomjetitID();             
                              
            default:
                return null;
        }
    }
        
    }


 