package DAL;
import BL.Perdoruesi;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class PerdoruesiRepository extends EntMngClass implements PerdoruesiInterface {
    
    public void create(Perdoruesi perdoruesi) throws PerdoruesiException {
        try{
            em.getTransaction().begin();
            em.persist(perdoruesi);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new PerdoruesiException("E dhëna egziston !");
            }
        else{
                throw new PerdoruesiException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(Perdoruesi perdoruesi) throws PerdoruesiException {
        try{
            em.getTransaction().begin();
            em.merge(perdoruesi);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new PerdoruesiException("E dhëna egziston");
            }
            else{
                throw new PerdoruesiException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(Perdoruesi perdoruesi) throws PerdoruesiException {
        try{
            em.getTransaction().begin();
            em.remove(perdoruesi);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new PerdoruesiException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new PerdoruesiException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <Perdoruesi> findAll() {
        return em.createNamedQuery("Perdoruesi.findAll").getResultList();
    }
    public Perdoruesi findById(String perdoruesiID) throws PerdoruesiException {
        Query query = em.createQuery("SELECT p FROM Perdoruesi p WHERE p.perdoruesiID = :perdoruesiID");
        query.setParameter("perdoruesiID", perdoruesiID);
        try{
            return (Perdoruesi)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new PerdoruesiException("E dhëna nuk egziston!");
        }
    }
    public Perdoruesi findByUsername(String username, String password) throws PerdoruesiException {
        Query query = em.createQuery("SELECT p FROM Perdoruesi p WHERE p.username = :username AND p.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            return (Perdoruesi) query.getSingleResult();
        } catch (NoResultException nre) {
            throw new PerdoruesiException("Ky User nuk ekziston!");
        }
    }
}