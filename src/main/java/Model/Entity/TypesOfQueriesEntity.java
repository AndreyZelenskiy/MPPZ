package Model.Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by xoll on 11.04.16.
 */
@Entity
@Table(name = "TypesOfQueries", schema = "mydb", catalog = "")
public class TypesOfQueriesEntity {
    private int idType;
    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idType")
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypesOfQueriesEntity that = (TypesOfQueriesEntity) o;

        if (idType != that.idType) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idType;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

}
