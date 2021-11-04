import dao.ClientRepository;
import dao.CourseRepository;
import dao.TrainerRepository;
import entity.Client;
import entity.Trainer;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CourseRepository courseRepository = new CourseRepository();
        ClientRepository clientRepository = new ClientRepository();
        TrainerRepository trainerRepository = new TrainerRepository();
        Client client = new Client();

        Scanner sc = new Scanner(System.in);
        boolean isRegistering = true;
        boolean isNavigatingApp = false;
        boolean isAppRunning = true;



        while (isAppRunning) {
            System.out.println("1. Register \n2. LogIn \n3. Shut Down");
            byte registerIndex = sc.nextByte();
            sc.nextLine();
            while (isRegistering) {
                isRegistering = false;
                switch (registerIndex) {
                    case 1:
                        client = new Client();
                        boolean isEmailTaken = true;
                        String email = null;
                        String password = null;
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
                        password = sc.nextLine();
                        client.setPassword(password);
                        clientRepository.createClient(client);
                        isNavigatingApp = true;
                        break;
                    case 2:
                        System.out.println("Introduceti adresa email");
                        email = sc.nextLine();
                        System.out.println("Introduceti parola");
                        password = sc.nextLine();
                        client = clientRepository.logInByMail(email, password);
                        isNavigatingApp = true;
                        break;
                    case 3:
                        isRegistering = false;
                        isNavigatingApp = false;
                        isAppRunning = false;
                        System.out.println("Byeeeeeeeeeeeee");
                        break;
                    default:
                        isRegistering = true;
                        System.out.println("1. Register \n2. LogIn \n3. Shut Down");
                        registerIndex = sc.nextByte();
                        sc.nextLine();
                        break;
                }

            }
            if (isNavigatingApp == true) {
                System.out.println("Welcome!");
            }


            while (isNavigatingApp) {

                byte navigateAppIndex;
                System.out.println("1. Update data");
                System.out.println("2. Sign up for a course");
                System.out.println("3. Find your personal trainer");
                System.out.println("4. Back to login menu");
                System.out.println("5. Exit");

                navigateAppIndex = sc.nextByte();
                sc.nextLine();
                switch (navigateAppIndex) {
                    case 1:
                        System.out.print("firstName: ");
                        String firstName = sc.nextLine();
                        System.out.print("lastName: ");
                        String lastName = sc.nextLine();
                        System.out.print("age: ");
                        Integer age = sc.nextInt();
                        sc.nextLine();
                        System.out.print("phoneNumber: ");
                        String phoneNumber = sc.nextLine();
                        System.out.print("birthDate: ");
                        SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
                        Date birthDate = null;
                        try {
                            birthDate = formatter.parse(sc.nextLine());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        client.setFirstName(firstName);
                        client.setLastName(lastName);
                        client.setAge(age);
                        client.setPhoneNumber(phoneNumber);
                        client.setBirthDate(birthDate);
                        client.setSubscriptionDate(LocalDate.now());

                        clientRepository.updateClient(client);
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    default:
                        isNavigatingApp = false;
                        isRegistering = true;
                        break;
                }
            }
            System.out.println("End of navigating app");
        }
        System.out.println("App Shut Down");
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





