package Model.Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by xoll on 11.04.16.
 */
@Entity
@Table(name = "CoordinationResults", schema = "mydb", catalog = "")
public class CoordinationResultsEntity {
    private int idCoordinationResult;
    private String resultText;
    private QueriesEntity query;
    private List<ClientsEntity> developers;
    private PackagesEntity packageEntity;

    public CoordinationResultsEntity(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCoordinationResult")
    public int getIdCoordinationResult() {
        return idCoordinationResult;
    }

    public void setIdCoordinationResult(int idCoordinationResult) {
        this.idCoordinationResult = idCoordinationResult;
    }

    public CoordinationResultsEntity(String resultText) {
        this.resultText = resultText;
    }

    @Basic
    @Column(name = "resultText")
    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    @OneToOne(mappedBy = "coordinationResult")
    public QueriesEntity getQuery() {
        return query;
    }

    public void setQuery(QueriesEntity query) {
        this.query = query;
    }

    @OneToOne(mappedBy = "coordinationResult")
    public PackagesEntity getPackageEntity() {
        return packageEntity;
    }

    public void setPackageEntity(PackagesEntity packeEntity) {
        this.packageEntity = packeEntity;
    }

    @ManyToMany(mappedBy = "coordinationResults", fetch = FetchType.EAGER)
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

        CoordinationResultsEntity that = (CoordinationResultsEntity) o;

        if (idCoordinationResult != that.idCoordinationResult) return false;
        if (resultText != null ? !resultText.equals(that.resultText) : that.resultText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCoordinationResult;
        result = 31 * result + (resultText != null ? resultText.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CoordinationResultsEntity{" +
                "idCoordinationResult=" + idCoordinationResult +
                ", resultText='" + resultText + '\'' +
                ", query=" + query +
                '}';
    }

}
