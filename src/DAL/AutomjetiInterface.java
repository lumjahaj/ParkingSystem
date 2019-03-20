package DAL;







import BL.Automjeti;
import java.util.List;

public interface AutomjetiInterface {
    
    /**
     *
     * @param automjeti
     * @throws AutomjetiException
     */
    void create(Automjeti automjeti) throws AutomjetiException;
    void edit (Automjeti automjeti) throws AutomjetiException;
    void remove(Automjeti automjeti) throws AutomjetiException;
    List<Automjeti> findAll();
    Automjeti findById(String automjeti) throws AutomjetiException;
}
