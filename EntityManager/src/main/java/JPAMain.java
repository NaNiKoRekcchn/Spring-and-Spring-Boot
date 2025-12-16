import jakarta.persistence.EntityManager;

public class JPAMain {
    public static void main(String [] args){

        EntityManager em = JPAUtil.getEntityManager();

        try{
            UserClassJPA user = new UserClassJPA("Mustaali");
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            System.out.println("User Saved : "+user.getId());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
            JPAUtil.close();
        }
    }
}
