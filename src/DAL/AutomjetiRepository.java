package DAL;
import BL.Automjeti;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class AutomjetiRepository extends EntMngClass implements AutomjetiInterface {
    
    public void create(Automjeti automjeti) throws AutomjetiException {
        try{
            em.getTransaction().begin();
            em.persist(automjeti);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new AutomjetiException("E dhëna egziston !");
            }
        else{
                throw new AutomjetiException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(Automjeti automjeti) throws AutomjetiException {
        try{
            em.getTransaction().begin();
            em.merge(automjeti);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new AutomjetiException("E dhëna egziston");
            }
            else{
                throw new AutomjetiException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(Automjeti automjeti) throws AutomjetiException {
        try{
            em.getTransaction().begin();
            em.remove(automjeti);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new AutomjetiException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new AutomjetiException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <Automjeti> findAll() {
        return em.createNamedQuery("Automjeti.findAll").getResultList();
    }
    public Automjeti findById(String automjetiID) throws AutomjetiException {
        Query query = em.createQuery("SELECT p FROM Automjeti p WHERE p.automjetiID = :automjetiID");
        query.setParameter("automjetiID", automjetiID);
        try{
            return (Automjeti)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new AutomjetiException("E dhëna nuk egziston!");
        }
    }   
}