package DAL;







import BL.Perdoruesi;
import java.util.List;

public interface PerdoruesiInterface {
    
    /**
     
     * @param perdoruesi
     * @throws PerdoruesiException
     */
    void create(Perdoruesi perdoruesi) throws PerdoruesiException;
    void edit (Perdoruesi perdoruesi) throws PerdoruesiException;
    void remove(Perdoruesi perdoruesi) throws PerdoruesiException;
    List<Perdoruesi> findAll();
    Perdoruesi findByUsername(String username, String password) throws PerdoruesiException;
    Perdoruesi findById(String perdoruesi) throws PerdoruesiException;
}