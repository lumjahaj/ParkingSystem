package Model;

import BL.LlojiNgjyres;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class LlojiNgjyresComboBoxModel extends AbstractListModel<LlojiNgjyres> implements ComboBoxModel<LlojiNgjyres> {
    
    private LlojiNgjyres sItem;
    private List<LlojiNgjyres> data;
   
    public LlojiNgjyresComboBoxModel(List arrayList) {
        data = arrayList;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public LlojiNgjyres getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        sItem = (LlojiNgjyres)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return sItem;
    }   
}
