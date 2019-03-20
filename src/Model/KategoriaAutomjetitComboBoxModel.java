package Model;

import BL.KategoriaAutomjetit;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class KategoriaAutomjetitComboBoxModel extends AbstractListModel<KategoriaAutomjetit> implements ComboBoxModel<KategoriaAutomjetit> {
    
    private KategoriaAutomjetit sItem;
    private List<KategoriaAutomjetit> data;
    
    public KategoriaAutomjetitComboBoxModel(List arrayList){
        data = arrayList;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public KategoriaAutomjetit getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        sItem = (KategoriaAutomjetit)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return sItem;
    }
}