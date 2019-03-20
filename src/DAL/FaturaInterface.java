package DAL;







import BL.Fatura;
import java.util.List;

public interface FaturaInterface {
    
    /**
     
     * @param perdoruesi
     * @throws FaturaException
     */
    void create(Fatura perdoruesi) throws FaturaException;
    void edit (Fatura perdoruesi) throws FaturaException;
    void remove(Fatura perdoruesi) throws FaturaException;
    List<Fatura> findAll();
    
    Fatura findById(String perdoruesi) throws FaturaException;
}