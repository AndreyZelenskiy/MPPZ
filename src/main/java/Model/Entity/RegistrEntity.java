package Model.Entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by xoll on 12.04.16.
 */
@Entity
@Table(name = "Registr", schema = "mydb", catalog = "")
public class RegistrEntity {
    private int idRegist;
    private Date editDate;
    private Date endDate;
    private MethodicsEntity method;
    private MethodType type;

    @Id
    @Column(name = "idRegist")
    public int getIdRegist() {
        return idRegist;
    }

    public void setIdRegist(int idRegist) {
        this.idRegist = idRegist;
    }

    @Basic
    @Column(name = "editDate")
    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idMethodic")
    public MethodicsEntity getMethod() {
        return method;
    }

    public void setMethod(MethodicsEntity method) {
        this.method = method;
    }


    @Enumerated(EnumType.ORDINAL)
    public MethodType getType() {
        return type;
    }

    public void setType(MethodType type) {
        this.type = type;
    }

    @Basic
    @Column(name = "endDate")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistrEntity that = (RegistrEntity) o;

        if (idRegist != that.idRegist) return false;
        if (editDate != null ? !editDate.equals(that.editDate) : that.editDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRegist;
        result = 31 * result + (editDate != null ? editDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}
