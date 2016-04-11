package Model.Entity;

import javax.persistence.*;

/**
 * Created by xoll on 11.04.16.
 */
@Entity
@Table(name = "CoordinationResults", schema = "mydb", catalog = "")
public class CoordinationResultsEntity {
    private int idCoordinationResult;
    private String resultText;
    private QueriesEntity query;

    public CoordinationResultsEntity(){}

    @Id
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
}
