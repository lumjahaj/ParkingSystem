package DAL;
import BL.Fatura;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class FaturaRepository extends EntMngClass implements FaturaInterface {
    
    public void create(Fatura Fatura) throws FaturaException {
        try{
            em.getTransaction().begin();
            em.persist(Fatura);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new FaturaException("E dhëna egziston !");
            }
        else{
                throw new FaturaException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(Fatura Fatura) throws FaturaException {
        try{
            em.getTransaction().begin();
            em.merge(Fatura);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new FaturaException("E dhëna egziston");
            }
            else{
                throw new FaturaException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(Fatura Fatura) throws FaturaException {
        try{
            em.getTransaction().begin();
            em.remove(Fatura);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new FaturaException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new FaturaException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    @Override
    public List <Fatura> findAll() {
        return em.createNamedQuery("Fatura.findAll").getResultList();
    }
    @Override
    public Fatura findById(String FaturaID) throws FaturaException {
        Query query = em.createQuery("SELECT p FROM Fatura p WHERE p.FaturaID = :FaturaID");
        query.setParameter("FaturaID", FaturaID);
        try{
            return (Fatura)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new FaturaException("E dhëna nuk egziston!");
        }
    }
}