package Model.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

/**
 * Created by xoll on 11.04.16.
 */
@Entity
@Table(name = "methodics", schema = "mydb", catalog = "")
public class MethodicsEntity {
    private int idMethodic;
    private String nameOfMethodic;
    private String methodicText;
    private Date creatingDate;
    private ClientsEntity author;
    private int methodType;

    public MethodicsEntity(){}

    public MethodicsEntity(String nameOfMethodic, String methodicText, Date creatingDate) {
        this.nameOfMethodic = nameOfMethodic;
        this.methodicText = methodicText;
        this.creatingDate = creatingDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMethodic")
    public int getIdMethodic() {
        return idMethodic;
    }

    public void setIdMethodic(int idMethodic) {
        this.idMethodic = idMethodic;
    }

    @Basic
    @Column(name = "nameOfMethodic")
    @Size(min=3, message = "Мінімальний розмір назви - 3 символи!")
    public String getNameOfMethodic() {
        return nameOfMethodic;
    }

    public void setNameOfMethodic(String nameOfMethodic) {
        this.nameOfMethodic = nameOfMethodic;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "methodicAuthor")
    public ClientsEntity getAuthor() {
        return author;
    }

    public void setAuthor(ClientsEntity author) {
        this.author = author;
    }

    @Basic
    @Column(name = "methodicText")
   // @Size(min = 3, message = "Enter the name")
    public String getMethodicText() {
        return methodicText;
    }

    public void setMethodicText(String methodicText) {
        this.methodicText = methodicText;
    }

    @Basic
    @Column(name = "methodType")
    public int getMethodType(){
        return methodType;
    }
    public void setMethodType(int methodType){
        this.methodType = methodType;
    }

    @Basic
    @Column(name = "creatingDate")
    public Date getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Date creatingDate) {
        this.creatingDate = creatingDate;
    }
    @Override
    public String toString() {
        return "MethodicsEntity{" +
                "creatingDate=" + creatingDate +
                ", methodicText='" + methodicText + '\'' +
                ", nameOfMethodic='" + nameOfMethodic + '\'' +
                ", idMethodic=" + idMethodic +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MethodicsEntity that = (MethodicsEntity) o;

        if (idMethodic != that.idMethodic) return false;
        if (nameOfMethodic != null ? !nameOfMethodic.equals(that.nameOfMethodic) : that.nameOfMethodic != null)
            return false;
        if (methodicText != null ? !methodicText.equals(that.methodicText) : that.methodicText != null) return false;
        if (creatingDate != null ? !creatingDate.equals(that.creatingDate) : that.creatingDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMethodic;
        result = 31 * result + (nameOfMethodic != null ? nameOfMethodic.hashCode() : 0);
        result = 31 * result + (methodicText != null ? methodicText.hashCode() : 0);
        result = 31 * result + (creatingDate != null ? creatingDate.hashCode() : 0);
        return result;
    }
}
