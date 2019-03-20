package DAL;







import BL.Roli;
import java.util.List;

public interface RoliInterface {
    
    /**
     
     * @param perdoruesi
     * @throws RoliException
     */
    void create(Roli perdoruesi) throws RoliException;
    void edit (Roli perdoruesi) throws RoliException;
    void remove(Roli perdoruesi) throws RoliException;
    List<Roli> findAll();
    
    Roli findById(String perdoruesi) throws RoliException;
}