package Model;

import BL.Shoferi;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class ShoferiComboBoxModel extends AbstractListModel<Shoferi> implements ComboBoxModel<Shoferi> {
    
    private Shoferi sItem;
    private List<Shoferi> data;
    
    public ShoferiComboBoxModel(List arrayList){
        data = arrayList;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Shoferi getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        sItem = (Shoferi)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return sItem;
    }
    
}
