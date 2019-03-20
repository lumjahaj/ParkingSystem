package DAL;
import BL.Roli;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class RoliRepository extends EntMngClass implements RoliInterface {
    
    public void create(Roli roli) throws RoliException {
        try{
            em.getTransaction().begin();
            em.persist(roli);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new RoliException("E dhëna egziston !");
            }
        else{
                throw new RoliException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(Roli roli) throws RoliException {
        try{
            em.getTransaction().begin();
            em.merge(roli);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new RoliException("E dhëna egziston");
            }
            else{
                throw new RoliException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(Roli roli) throws RoliException {
        try{
            em.getTransaction().begin();
            em.remove(roli);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new RoliException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new RoliException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    @Override
    public List <Roli> findAll() {
        return em.createNamedQuery("Roli.findAll").getResultList();
    }
    @Override
    public Roli findById(String roliID) throws RoliException {
        Query query = em.createQuery("SELECT p FROM Roli p WHERE p.roliID = :roliID");
        query.setParameter("roliID", roliID);
        try{
            return (Roli)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new RoliException("E dhëna nuk egziston!");
        }
    }
}