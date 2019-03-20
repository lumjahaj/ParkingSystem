package DAL;
import BL.LlojiNgjyres;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class LlojiNgjyresRepository extends EntMngClass implements LlojiNgjyresInterface {
    
    public void create(LlojiNgjyres automjeti) throws LlojiNgjyresException {
        try{
            em.getTransaction().begin();
            em.persist(automjeti);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new LlojiNgjyresException("E dhëna egziston !");
            }
        else{
                throw new LlojiNgjyresException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(LlojiNgjyres automjeti) throws LlojiNgjyresException {
        try{
            em.getTransaction().begin();
            em.merge(automjeti);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new LlojiNgjyresException("E dhëna egziston");
            }
            else{
                throw new LlojiNgjyresException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(LlojiNgjyres automjeti) throws LlojiNgjyresException {
        try{
            em.getTransaction().begin();
            em.remove(automjeti);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new LlojiNgjyresException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new LlojiNgjyresException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <LlojiNgjyres> findAll() {
        return em.createNamedQuery("LlojiNgjyres.findAll").getResultList();
    }
    public LlojiNgjyres findById(String automjetiID) throws LlojiNgjyresException {
        Query query = em.createQuery("SELECT p FROM LlojiNgjyres p WHERE p.automjetiID = :automjetiID");
        query.setParameter("automjetiID", automjetiID);
        try{
            return (LlojiNgjyres)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new LlojiNgjyresException("E dhëna nuk egziston!");
        }
    }    
}