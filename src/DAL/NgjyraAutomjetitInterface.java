package DAL;







import BL.NgjyraAutomjetit;
import java.util.List;

public interface NgjyraAutomjetitInterface {
    
    /**
     *
     * @param llojiAutomjetit
     * @throws NgjyraAutomjetitException
     */
    void create(NgjyraAutomjetit llojiAutomjetit) throws NgjyraAutomjetitException;
    void edit (NgjyraAutomjetit llojiAutomjetit) throws NgjyraAutomjetitException;
    void remove(NgjyraAutomjetit llojiAutomjetit) throws NgjyraAutomjetitException;
    List<NgjyraAutomjetit> findAll();
    NgjyraAutomjetit findById(String llojiAutomjetit) throws NgjyraAutomjetitException;
}
