package dao;


import entity.Client;
import entity.Trainer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    // TODO assign client to a course

    public static boolean checkEmail(String email) {

        List<String> emails = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("select c.email FROM Client c");
            emails = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (emails.stream().anyMatch(anyEmail -> anyEmail.equals(email))) {
            return true;
        }
        return false;
    }

    public Client logInByMail(String email, String password) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Client.class);
            Client client = (Client) criteria.add(Restrictions.eq("email", email))
                    .uniqueResult();
            if (client == null) {
                System.out.println("Emailul introdus nu exista");
            }

            if (client != null) {
                if (!(client.getPassword().equals(password))) {
//            client =(Client) criteria.add(Restrictions.eq("password", password)).uniqueResult();
//            if (client==null){
                    System.out.println("Parola incorecta");
                } else {
                    return client;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }




    //CRUD
    public void updateClient(Client client) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the client object
            session.update(client);
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void createClient(Client client) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the person object
            session.save(client);
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    // TODO : de modificat sa gaseasca clientul cu adresa introdusa ca email
    public Client getClient(String email) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Client client = session.find(Client.class, email);
            return client;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Client> getAllClients() {
        List<Client> clientList = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("select c from Client c", Client.class);
            clientList = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return clientList;
    }

    //public void assigntoCourse(){


    }
//}


