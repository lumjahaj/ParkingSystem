package Model;

import BL.LlojiAutomjetit;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class LlojiAutomjetitComboBoxModel extends AbstractListModel<LlojiAutomjetit> implements ComboBoxModel<LlojiAutomjetit> {
    
    private LlojiAutomjetit sItem;
    private List<LlojiAutomjetit> data;
    
    public LlojiAutomjetitComboBoxModel(List arrayList){
        data = arrayList;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public LlojiAutomjetit getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        sItem = (LlojiAutomjetit)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return sItem;
    }
    
}
