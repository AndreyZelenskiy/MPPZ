package Model.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by xoll on 11.04.16.
 */
@Entity
@Table(name = "Methodics", schema = "mydb", catalog = "")
public class MethodicsEntity {
    private int idMethodic;
    private String nameOfMethodic;
    private String methodicText;
    private Date creatingDate;
    private List<ClientsEntity> developers;
    private List<QueriesEntity> queries;
    private List<PackagesEntity> packages;

    public MethodicsEntity(){}

    public MethodicsEntity(String nameOfMethodic, String methodicText, Date creatingDate) {
        this.nameOfMethodic = nameOfMethodic;
        this.methodicText = methodicText;
        this.creatingDate = creatingDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMethodic")
    public int getIdMethodic() {
        return idMethodic;
    }

    public void setIdMethodic(int idMethodic) {
        this.idMethodic = idMethodic;
    }

    @Basic
    @Column(name = "nameOfMethodic")
    public String getNameOfMethodic() {
        return nameOfMethodic;
    }

    public void setNameOfMethodic(String nameOfMethodic) {
        this.nameOfMethodic = nameOfMethodic;
    }

    @Basic
    @Column(name = "methodicText")
    public String getMethodicText() {
        return methodicText;
    }

    public void setMethodicText(String methodicText) {
        this.methodicText = methodicText;
    }

    @Basic
    @Column(name = "creatingDate")
    public Date getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Date creatingDate) {
        this.creatingDate = creatingDate;
    }

    @OneToMany(mappedBy = "method")
    public List<PackagesEntity> getPackages() {
        return packages;
    }

    public void setPackages(List<PackagesEntity> packages) {
        this.packages = packages;
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

    @OneToMany(mappedBy = "method")
    public List<QueriesEntity> getQueries() {
        return queries;
    }

    public void setQueries(List<QueriesEntity> queries) {
        this.queries = queries;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "MethodicAuthor",
            joinColumns = @JoinColumn(name = "idAuthor"),
            inverseJoinColumns = @JoinColumn(name = "idMethodic")
    )
    public List<ClientsEntity> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<ClientsEntity> developers) {
        this.developers = developers;
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
