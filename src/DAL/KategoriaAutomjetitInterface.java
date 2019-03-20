package DAL;







import BL.KategoriaAutomjetit;
import java.util.List;

public interface KategoriaAutomjetitInterface {
    
    /**
     *
     * @param kategoriaAutomjetit
     * @throws KategoriaAutomjetitException
     */
    void create(KategoriaAutomjetit kategoriaAutomjetit) throws KategoriaAutomjetitException;
    void edit (KategoriaAutomjetit kategoriaAutomjetit) throws KategoriaAutomjetitException;
    void remove(KategoriaAutomjetit kategoriaAutomjetit) throws KategoriaAutomjetitException;
    List<KategoriaAutomjetit> findAll();
    KategoriaAutomjetit findById(String kategoriaAutomjetit) throws KategoriaAutomjetitException;
}
