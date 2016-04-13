package Model.Service;

/**
 * Created by talizorah on 16.13.4.
 */
public interface ClientService  {
    boolean authorization(String login, String password);
    boolean registration(String login, String password, String firstName, String secondName);
}
