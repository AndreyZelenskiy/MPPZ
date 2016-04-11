package Model.Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by xoll on 11.04.16.
 */
@Entity
@Table(name = "Roles", schema = "mydb", catalog = "")
public class RolesEntity {
    private int idRoles;
    private String type;
    private List<ClientsEntity> clients;

    public RolesEntity(){}

    public RolesEntity(String type) {
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idRoles")
    public int getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(int idRoles) {
        this.idRoles = idRoles;
    }

    @Basic
    @Column(name = "Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ManyToMany(mappedBy = "roles")
    public List<ClientsEntity> getClients() {
        return clients;
    }

    public void setClients(List<ClientsEntity> clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesEntity that = (RolesEntity) o;

        if (idRoles != that.idRoles) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRoles;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
