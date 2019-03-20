package Model;

import BL.Roli;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class RoliComboBoxModel extends AbstractListModel<Roli> implements ComboBoxModel<Roli> {
    
    private Roli sItem;
    private List<Roli> data;
   
    public RoliComboBoxModel(List arrayList) {
        data = arrayList;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Roli getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        sItem = (Roli)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return sItem;
    }   
}