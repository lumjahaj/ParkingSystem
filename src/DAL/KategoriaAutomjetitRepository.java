package DAL;
import BL.KategoriaAutomjetit;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class KategoriaAutomjetitRepository extends EntMngClass implements KategoriaAutomjetitInterface {
    
    public void create(KategoriaAutomjetit perdoruesi) throws KategoriaAutomjetitException {
        try{
            em.getTransaction().begin();
            em.persist(perdoruesi);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new KategoriaAutomjetitException("E dhëna egziston !");
            }
        else{
                throw new KategoriaAutomjetitException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(KategoriaAutomjetit perdoruesi) throws KategoriaAutomjetitException {
        try{
            em.getTransaction().begin();
            em.merge(perdoruesi);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new KategoriaAutomjetitException("E dhëna egziston");
            }
            else{
                throw new KategoriaAutomjetitException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(KategoriaAutomjetit perdoruesi) throws KategoriaAutomjetitException {
        try{
            em.getTransaction().begin();
            em.remove(perdoruesi);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new KategoriaAutomjetitException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new KategoriaAutomjetitException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <KategoriaAutomjetit> findAll() {
        return em.createNamedQuery("KategoriaAutomjetit.findAll").getResultList();
    }
    public KategoriaAutomjetit findById(String perdoruesiID) throws KategoriaAutomjetitException {
        Query query = em.createQuery("SELECT p FROM KategoriaAutomjetit p WHERE p.perdoruesiID = :perdoruesiID");
        query.setParameter("perdoruesiID", perdoruesiID);
        try{
            return (KategoriaAutomjetit)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new KategoriaAutomjetitException("E dhëna nuk egziston!");
        }
    }
    public KategoriaAutomjetit findByUsername(String username, String password) throws KategoriaAutomjetitException {
        Query query = em.createQuery("SELECT p FROM KategoriaAutomjetit p WHERE p.username = :username AND p.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            return (KategoriaAutomjetit) query.getSingleResult();
        } catch (NoResultException nre) {
            throw new KategoriaAutomjetitException("Ky User nuk ekziston!");
        }
    }
}