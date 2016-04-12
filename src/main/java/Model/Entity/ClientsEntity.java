package Model.Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by xoll on 11.04.16.
 */
@Entity
@Table(name = "Clients", schema = "mydb", catalog = "")
public class ClientsEntity {
    private int idClients;
    private String login;
    private String password;
    private String name;
    private String surname;
    private List<RolesEntity> roles;
    private List<MethodicsEntity> methodics;
    private List<CoordinationResultsEntity> coordinationResults;

    public ClientsEntity(){}

    public ClientsEntity(String login, String password, String name, String surname) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idClients")
    public int getIdClients() {
        return idClients;
    }

    public void setIdClients(int idClients) {
        this.idClients = idClients;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "ClientRole",
            joinColumns = @JoinColumn(name = "idRole"),
            inverseJoinColumns = @JoinColumn(name = "idClient")
    )
    public List<RolesEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesEntity> role) {
        this.roles = role;
    }

    @ManyToMany(mappedBy = "developers")
    public List<MethodicsEntity> getMethodics() {
        return methodics;
    }

    public void setMethodics(List<MethodicsEntity> methodics) {
        this.methodics = methodics;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "DeveloperCoordResult",
        joinColumns = @JoinColumn(name = "idCoordinationResult"),
            inverseJoinColumns = @JoinColumn(name = "idDeveloper")
    )
    public List<CoordinationResultsEntity> getCoordinationResults() {
        return coordinationResults;
    }

    public void setCoordinationResults(List<CoordinationResultsEntity> coordinationResults) {
        this.coordinationResults = coordinationResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsEntity that = (ClientsEntity) o;

        if (idClients != that.idClients) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClients;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientsEntity{" +
                "idClients=" + idClients +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
