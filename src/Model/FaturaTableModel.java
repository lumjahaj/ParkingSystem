package Model;

import BL.Fatura;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class FaturaTableModel extends AbstractTableModel {
    
    private final String [] columnNames = {"Data e Fatures","Koha e hyrjes","KOha e daljes","Totali"};
    
    private List <Fatura> data;
    
    public FaturaTableModel(List<Fatura>data){
        this.data = data;
    }

    public FaturaTableModel() {
   
    }
    public void add(List<Fatura>data){
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

    public Fatura getFatura(int index){
        return data.get(index);
    }
     public String getDate (Date date){
        DateFormat da = new SimpleDateFormat("dd/MM/yyyy");
        return da.format(date);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Fatura s = (Fatura)data.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return s.getDataFatures();
            case 1:
                return s.getFaturaDetajetID().getKohaHyrjes();
            case 2:
                return s.getFaturaDetajetID().getKohaDaljes();
            case 3:
                return s.getFaturaDetajetID().getTotali();
            
            default:
                return null;
        }
    }
        
    }