package DAL;

import BL.TipiAutomjetit;
import java.util.List;

public interface TipiAutomjetitInterface {
    
    /**
     *
     * @param automjeti
     * @throws TipiAutomjetitException
     */
    void create(TipiAutomjetit automjeti) throws TipiAutomjetitException;
    void edit (TipiAutomjetit automjeti) throws TipiAutomjetitException;
    void remove(TipiAutomjetit automjeti) throws TipiAutomjetitException;
    List<TipiAutomjetit> findAll();
    TipiAutomjetit findById(String automjeti) throws TipiAutomjetitException;
    List<TipiAutomjetit> findByLlojiAutomjetitId(int llojiAutomjetitID) throws TipiAutomjetitException;
}