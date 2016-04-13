package Model.Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by xoll on 12.04.16.
 */
@Entity
@Table(name = "JucticeResult", schema = "mydb", catalog = "")
public class JucticeResultEntity {
    private int idJucticeResult;
    private String resultText;
    private List<ClientsEntity> developers;

    @Id
    @Column(name = "idJucticeResult")
    public int getIdJucticeResult() {
        return idJucticeResult;
    }

    public void setIdJucticeResult(int idJucticeResult) {
        this.idJucticeResult = idJucticeResult;
    }

    @Basic
    @Column(name = "resultText")
    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "DeveloperJusticeResult",
            joinColumns = @JoinColumn(name = "idDeveloper"),
            inverseJoinColumns = @JoinColumn(name = "idJusticeResult")
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

        JucticeResultEntity that = (JucticeResultEntity) o;

        if (idJucticeResult != that.idJucticeResult) return false;
        if (resultText != null ? !resultText.equals(that.resultText) : that.resultText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idJucticeResult;
        result = 31 * result + (resultText != null ? resultText.hashCode() : 0);
        return result;
    }
}
