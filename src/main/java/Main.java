import dao.ClientRepository;
import dao.CourseRepository;
import dao.TrainerRepository;
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
        ClientRepository clientRepository = new ClientRepository();
        TrainerRepository trainerRepository = new TrainerRepository();
        Client client = new Client();

        Scanner sc = new Scanner(System.in);
        boolean isChoosing = true;

        System.out.println("1. Register \n2. LogIn");
        byte registerIndex = sc.nextByte();
        sc.nextLine();

        while (isChoosing) {
            isChoosing = false;
            switch (registerIndex) {
                case 1:
                    client = new Client();
                    boolean isEmailTaken = true;
                    String email = null;

                    System.out.println("Registering");
                    while (isEmailTaken) {
                        System.out.print("email: ");
                        email = sc.nextLine();
                        isEmailTaken = clientRepository.checkEmail(email);
                        if (isEmailTaken == true) {
                            System.out.println("Email is taken!!");
                        }
                    }
                    client.setEmail(email);
                    System.out.print("password: ");
                    String password = sc.nextLine();
                    client.setPassword(password);
                    clientRepository.createClient(client);
                    client = clientRepository.getClient(email);
                    break;
                case 2:
                    System.out.println("Introduceti adresa email");
                    email = sc.nextLine();
                    System.out.println("Introduceti parola");
                    password = sc.nextLine();
                    client = clientRepository.logInByMail(email,password);
                    //client = clientRepository.getClient(clientRepository.logInByMail(email,password).getEmail());
                    break;
                default:
                    isChoosing = true;
                    System.out.println("1. SignIn \n2. LogIn");
                    registerIndex = sc.nextByte();
                    sc.nextLine();
                    break;
            }
            System.out.println("End of switch");


        }
        client.toString();
        System.out.println("End of while");

        HibernateUtil.shutdown();
    }
}




/*
    System.out.println("Introduceti numele cursului");
    String courseName = sc.nextLine();
 */


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





