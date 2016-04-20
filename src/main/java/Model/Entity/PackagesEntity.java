package Model.Entity;

import javax.persistence.*;

/**
 * Created by xoll on 12.04.16.
 */
@Entity
@Table(name = "Packages", schema = "mydb", catalog = "")
public class PackagesEntity {
    private int idPackage;
    private String review;
    private CoordinationResultsEntity coordinationResult;
    private MethodicsEntity method;
    private JucticeResultEntity jucticeResult;
    private TypeOfQuery type;

    @Id
    @Column(name = "idPackage")
    public int getIdPackage() {
        return idPackage;
    }

    public void setIdPackage(int idPackage) {
        this.idPackage = idPackage;
    }

    @Basic
    @Column(name = "review")
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "idCoordResult")
    public CoordinationResultsEntity getCoordinationResult() {
        return coordinationResult;
    }

    public void setCoordinationResult(CoordinationResultsEntity coordinationResult) {
        this.coordinationResult = coordinationResult;
    }


    @Enumerated(EnumType.ORDINAL)
    public TypeOfQuery getType() {
        return type;
    }

    public void setType(TypeOfQuery type) {
        this.type = type;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idJusticeResult")
    public JucticeResultEntity getJucticeResult() {
        return jucticeResult;
    }

    public void setJucticeResult(JucticeResultEntity jucticeResult) {
        this.jucticeResult = jucticeResult;
    }

    @ManyToOne
    @JoinColumn(name = "idMethodic")
    public MethodicsEntity getMethod() {
        return method;
    }

    public void setMethod(MethodicsEntity method) {
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackagesEntity that     = (PackagesEntity) o;

        if (idPackage != that.idPackage) return false;
        if (review != null ? !review.equals(that.review) : that.review != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPackage;
        result = 31 * result + (review != null ? review.hashCode() : 0);
        return result;
    }
}
