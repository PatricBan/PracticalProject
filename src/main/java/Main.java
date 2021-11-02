import util.HibernateUtil;

public class Main {
    public static void main(String[] args) {

        //TODO: SignIn/LogIn
        /*
        LogIn verifica daca emailul si parola introdusa exista.
        SignIm creaza un client/trainer nou si il introduce in baza de date.
        Daca s-a autentificat ca si client atunci sa ii apara meniu cu functii specifice client repository:
        -display all trainers
        -display all courses
        -assign to a trainer
        -assign to a course
        daca s-a autentificat ca si trainer sa aiba functii specifice trainer repository:
        -sa vada toti clientii
        -sa vada toate cursurile lui
        -sa elimimne un client din lista
        -sa renunte la un curs
         */

        HibernateUtil.shutdown();
    }
}
