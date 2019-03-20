package DAL;
import BL.NgjyraAutomjetit;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class NgjyraAutomjetitRepository extends EntMngClass implements NgjyraAutomjetitInterface {
    
    public void create(NgjyraAutomjetit perdoruesi) throws NgjyraAutomjetitException {
        try{
            em.getTransaction().begin();
            em.persist(perdoruesi);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new NgjyraAutomjetitException("E dhëna egziston !");
            }
        else{
                throw new NgjyraAutomjetitException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(NgjyraAutomjetit perdoruesi) throws NgjyraAutomjetitException {
        try{
            em.getTransaction().begin();
            em.merge(perdoruesi);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new NgjyraAutomjetitException("E dhëna egziston");
            }
            else{
                throw new NgjyraAutomjetitException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(NgjyraAutomjetit perdoruesi) throws NgjyraAutomjetitException {
        try{
            em.getTransaction().begin();
            em.remove(perdoruesi);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new NgjyraAutomjetitException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new NgjyraAutomjetitException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <NgjyraAutomjetit> findAll() {
        return em.createNamedQuery("NgjyraAutomjetit.findAll").getResultList();
    }
    public NgjyraAutomjetit findById(String perdoruesiID) throws NgjyraAutomjetitException {
        Query query = em.createQuery("SELECT p FROM NgjyraAutomjetit p WHERE p.perdoruesiID = :perdoruesiID");
        query.setParameter("perdoruesiID", perdoruesiID);
        try{
            return (NgjyraAutomjetit)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new NgjyraAutomjetitException("E dhëna nuk egziston!");
        }
    }
    public NgjyraAutomjetit findByUsername(String username, String password) throws NgjyraAutomjetitException {
        Query query = em.createQuery("SELECT p FROM NgjyraAutomjetit p WHERE p.username = :username AND p.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            return (NgjyraAutomjetit) query.getSingleResult();
        } catch (NoResultException nre) {
            throw new NgjyraAutomjetitException("Ky User nuk ekziston!");
        }
    }
}