package DAL;
import BL.TipiAutomjetit;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class TipiAutomjetitRepository extends EntMngClass implements TipiAutomjetitInterface {
    
    public void create(TipiAutomjetit automjeti) throws TipiAutomjetitException {
        try{
            em.getTransaction().begin();
            em.persist(automjeti);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new TipiAutomjetitException("E dhëna egziston !");
            }
        else{
                throw new TipiAutomjetitException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(TipiAutomjetit automjeti) throws TipiAutomjetitException {
        try{
            em.getTransaction().begin();
            em.merge(automjeti);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new TipiAutomjetitException("E dhëna egziston");
            }
            else{
                throw new TipiAutomjetitException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(TipiAutomjetit automjeti) throws TipiAutomjetitException {
        try{
            em.getTransaction().begin();
            em.remove(automjeti);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new TipiAutomjetitException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new TipiAutomjetitException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <TipiAutomjetit> findAll() {
        return em.createNamedQuery("TipiAutomjetit.findAll").getResultList();
    }
    public TipiAutomjetit findById(String automjetiID) throws TipiAutomjetitException {
        Query query = em.createQuery("SELECT p FROM TipiAutomjetit p WHERE p.automjetiID = :automjetiID");
        query.setParameter("automjetiID", automjetiID);
        try{
            return (TipiAutomjetit)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new TipiAutomjetitException("E dhëna nuk egziston!");
        }        
    }
    public List<TipiAutomjetit> findByLlojiAutomjetitId(int LlojiAutomjetitID) throws TipiAutomjetitException {
        Query query = em.createQuery("SELECT p FROM TipiAutomjetit p WHERE p.llojiAutomjetitID.llojiAutomjetitID = :LlojiAutomjetitID");
        query.setParameter("LlojiAutomjetitID", LlojiAutomjetitID);
        try {
            return query.getResultList();
        } catch (NoResultException nre) {
            throw new TipiAutomjetitException("E dhëna nuk egziston!");
        }
    } 
}