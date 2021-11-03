import dao.ClientRepository;
import dao.CourseRepository;
import entity.Client;
import entity.Trainer;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CourseRepository courseRepository = new CourseRepository();

        Scanner sc = new Scanner(System.in);
        System.out.println(courseRepository.checkCourseName("abc"));
//        boolean isRegistering = true;
//        System.out.println("1. Register \n2. LogIn");
//        byte registerIndex = sc.nextByte();
//        sc.nextLine();
//
//
//        while (isRegistering) {
//            switch (registerIndex) {
//                case 1:
//                    boolean isEmailTaken = true;
//                    System.out.println("Registering");
//                    while (isEmailTaken) {
//                        System.out.print("email: ");
//                        String email = sc.nextLine();
//                        isEmailTaken = checkEmail(email);
//                        if (isEmailTaken == true) {
//                            System.out.println("Email is taken!!");
//                        }
//                    }
//                    System.out.print("password: ");
//                    String password = sc.nextLine();
//                    isRegistering = false;
//                    break;
//                case 2:
//
//                    isRegistering = false;
//                    break;
//                default:
//                    System.out.println("1. SignIn \n2. LogIn");
//                    registerIndex = sc.nextByte();
//                    sc.nextLine();
//                    break;
//            }
//        }

/*
    System.out.println("Introduceti numele cursului");
    String courseName = sc.nextLine();
 */

    }

    //TODO: SignIn/LogIn
        /*
        LogIn verifica daca emailul si parola introdusa exista. -AZ
        -
        SignIn creaza un client/trainer nou si il introduce in baza de date.
        Clientul care se va crea va avea email si parola.

        Daca s-a autentificat ca si client atunci sa ii apara meniu cu functii specifice client repository:
        -set firstname, lastname, age... -DB
        -display all trainers - done
        -display all courses - M
        -assign to a trainer - setam idTrainer din client = trainer primit ca si parametru (numele unui trainer- cauta in trainers
        numele primit ca si parametru, daca il gaseste seteaza idTrainer din tabela client = idTrainer din tabela trainer care are numele
        = numele primit ca si parametru) - AZ
        -assign to a course - string primit ca si parametru (ca si mai sus) -AȚ

        Daca s-a autentificat ca si trainer sa aiba functii specifice trainer repository:
                -set firstname, lastname, age... -DB
        -sa vada toti clientii (displayAllClients()) -M
        -sa vada toate cursurile lui (displayAllTrainersCourses()) -M
        -sa elimimne un client din lista (seteaza idClient din tabela trainer "null") - AȚ
        -sa renunte la un curs (seteze idCourse ca si "null" - DB
         */
//        ClientRepository clientRepository = new ClientRepository();
//        clientRepository.displayAllTrainers().stream().forEach(System.out::println);
//        HibernateUtil.shutdown();


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




}
