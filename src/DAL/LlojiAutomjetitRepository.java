package DAL;
import BL.LlojiAutomjetit;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class LlojiAutomjetitRepository extends EntMngClass implements LlojiAutomjetitInterface {
    
    public void create(LlojiAutomjetit perdoruesi) throws LlojiAutomjetitException {
        try{
            em.getTransaction().begin();
            em.persist(perdoruesi);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new LlojiAutomjetitException("E dhëna egziston !");
            }
        else{
                throw new LlojiAutomjetitException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(LlojiAutomjetit perdoruesi) throws LlojiAutomjetitException {
        try{
            em.getTransaction().begin();
            em.merge(perdoruesi);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new LlojiAutomjetitException("E dhëna egziston");
            }
            else{
                throw new LlojiAutomjetitException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(LlojiAutomjetit perdoruesi) throws LlojiAutomjetitException {
        try{
            em.getTransaction().begin();
            em.remove(perdoruesi);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new LlojiAutomjetitException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new LlojiAutomjetitException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <LlojiAutomjetit> findAll() {
        return em.createNamedQuery("LlojiAutomjetit.findAll").getResultList();
    }
    public LlojiAutomjetit findById(String perdoruesiID) throws LlojiAutomjetitException {
        Query query = em.createQuery("SELECT p FROM LlojiAutomjetit p WHERE p.perdoruesiID = :perdoruesiID");
        query.setParameter("perdoruesiID", perdoruesiID);
        try{
            return (LlojiAutomjetit)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new LlojiAutomjetitException("E dhëna nuk egziston!");
        }
    }
    @Override
    public List<LlojiAutomjetit> findByTipiAutomjetitID(int tipiAutomjetitID) throws LlojiAutomjetitException {
        Query query = em.createQuery("SELECT l FROM Lenda l WHERE l.tipiAutomjetitID = :tipiAutomjetitID");
        query.setParameter("tipiAutomjetitID", tipiAutomjetitID);
        try {
            return query.getResultList();
        } catch (NoResultException nre) {
            throw new LlojiAutomjetitException("E dhëna nuk egziston!");
        }
    }
} 

