package DAL;

import BL.LlojiNgjyres;
import java.util.List;

public interface LlojiNgjyresInterface {
    
    /**
     *
     * @param automjeti
     * @throws LlojiNgjyresException
     */
    void create(LlojiNgjyres automjeti) throws LlojiNgjyresException;
    void edit (LlojiNgjyres automjeti) throws LlojiNgjyresException;
    void remove(LlojiNgjyres automjeti) throws LlojiNgjyresException;
    List<LlojiNgjyres> findAll();
    LlojiNgjyres findById(String automjeti) throws LlojiNgjyresException;
}