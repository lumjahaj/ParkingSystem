package Model;

import BL.TipiAutomjetit;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class TipiAutomjetitComboBoxModel extends AbstractListModel<TipiAutomjetit> implements ComboBoxModel<TipiAutomjetit> {
    
    private TipiAutomjetit sItem;
    private List<TipiAutomjetit> data;
   
    public TipiAutomjetitComboBoxModel(List arrayList) {
        data = arrayList;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public TipiAutomjetit getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        sItem = (TipiAutomjetit)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return sItem;
    }   
}
