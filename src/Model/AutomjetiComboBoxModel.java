package Model;

import BL.Automjeti;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class AutomjetiComboBoxModel extends AbstractListModel<Automjeti> implements ComboBoxModel<Automjeti> {
    
    private Automjeti sItem;
    private List<Automjeti> data;
    
    public AutomjetiComboBoxModel(List arrayList){
        data = arrayList;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Automjeti getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        sItem = (Automjeti)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return sItem;
    }
    
}