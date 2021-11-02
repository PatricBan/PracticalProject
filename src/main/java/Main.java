import dao.ClientRepository;
import dao.TrainerRepository;
import util.HibernateUtil;

public class Main {
    public static void main(String[] args) {

        //TODO: SignIn/LogIn
        /*
        LogIn verifica daca emailul si parola introdusa exista. -AZ
        -
        SignIn creaza un client/trainer nou si il introduce in baza de date.
        Clientul care se va crea va avea email si parola.

        Daca s-a autentificat ca si client atunci sa ii apara meniu cu functii specifice client repository:
        -set firstname, lastname, age... -DB
        -display all trainers - done
        -display all courses -M
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
        ClientRepository clientRepository = new ClientRepository();
        clientRepository.displayAllTrainers().stream().forEach(System.out::println);
        clientRepository.displayAllCourses().stream().forEach(System.out::println);
        TrainerRepository trainerRepository = new TrainerRepository();
        trainerRepository.displayAllClients().stream().forEach(System.out::println);
        trainerRepository.displayAllTrainerCourses().stream().forEach(System.out::println);
        HibernateUtil.shutdown();
    }
}
