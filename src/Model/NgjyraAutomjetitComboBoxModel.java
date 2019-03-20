package Model;

import BL.NgjyraAutomjetit;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class NgjyraAutomjetitComboBoxModel extends AbstractListModel<NgjyraAutomjetit> implements ComboBoxModel<NgjyraAutomjetit> {
    
    private NgjyraAutomjetit sItem;
    private List<NgjyraAutomjetit> data;
    
    public NgjyraAutomjetitComboBoxModel(List arrayList){
        data = arrayList;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public NgjyraAutomjetit getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        sItem = (NgjyraAutomjetit)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return sItem;
    }
    
}