package DAL;







import BL.LlojiAutomjetit;
import java.util.List;

public interface LlojiAutomjetitInterface {
    
    /**
     *
     * @param llojiAutomjetit
     * @throws LlojiAutomjetitException
     */
    void create(LlojiAutomjetit llojiAutomjetit) throws LlojiAutomjetitException;
    void edit (LlojiAutomjetit llojiAutomjetit) throws LlojiAutomjetitException;
    void remove(LlojiAutomjetit llojiAutomjetit) throws LlojiAutomjetitException;
    List<LlojiAutomjetit> findAll();
    LlojiAutomjetit findById(String llojiAutomjetit) throws LlojiAutomjetitException;
    List<LlojiAutomjetit> findByTipiAutomjetitID(int tipiAutomjetitID) throws LlojiAutomjetitException;
}
