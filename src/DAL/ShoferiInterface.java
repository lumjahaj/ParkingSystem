package DAL;







import BL.Shoferi;
import java.util.List;

public interface ShoferiInterface {
    
    /**
     *
     * @param automjeti
     * @throws ShoferiException
     */
    void create(Shoferi automjeti) throws ShoferiException;
    void edit (Shoferi automjeti) throws ShoferiException;
    void remove(Shoferi automjeti) throws ShoferiException;
    List<Shoferi> findAll();
    Shoferi findById(String automjeti) throws ShoferiException;
}