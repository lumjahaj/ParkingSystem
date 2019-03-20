package DAL;
import BL.Shoferi;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class ShoferiRepository extends EntMngClass implements ShoferiInterface {
    
    public void create(Shoferi shoferi) throws ShoferiException {
        try{
            em.getTransaction().begin();
            em.persist(shoferi);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new ShoferiException("E dhëna egziston !");
            }
        else{
                throw new ShoferiException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(Shoferi shoferi) throws ShoferiException {
        try{
            em.getTransaction().begin();
            em.merge(shoferi);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new ShoferiException("E dhëna egziston");
            }
            else{
                throw new ShoferiException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(Shoferi shoferi) throws ShoferiException {
        try{
            em.getTransaction().begin();
            em.remove(shoferi);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new ShoferiException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new ShoferiException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <Shoferi> findAll() {
        return em.createNamedQuery("Shoferi.findAll").getResultList();
    }
    public Shoferi findById(String shoferiID) throws ShoferiException {
        Query query = em.createQuery("SELECT p FROM Shoferi p WHERE p.shoferiID = :shoferiID");
        query.setParameter("shoferiID", shoferiID);
        try{
            return (Shoferi)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new ShoferiException("E dhëna nuk egziston!");
        }
    }   
}