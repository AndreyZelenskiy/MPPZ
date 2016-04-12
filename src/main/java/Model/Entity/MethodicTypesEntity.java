package Model.Entity;

import javax.persistence.*;

/**
 * Created by xoll on 12.04.16.
 */
@Entity
@Table(name = "MethodicTypes", schema = "mydb", catalog = "")
public class MethodicTypesEntity {
    private int idMethodicTypes;
    private String methodicType;

    @Id
    @Column(name = "idMethodicTypes")
    public int getIdMethodicTypes() {
        return idMethodicTypes;
    }

    public void setIdMethodicTypes(int idMethodicTypes) {
        this.idMethodicTypes = idMethodicTypes;
    }

    @Basic
    @Column(name = "MethodicType")
    public String getMethodicType() {
        return methodicType;
    }

    public void setMethodicType(String methodicType) {
        this.methodicType = methodicType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MethodicTypesEntity that = (MethodicTypesEntity) o;

        if (idMethodicTypes != that.idMethodicTypes) return false;
        if (methodicType != null ? !methodicType.equals(that.methodicType) : that.methodicType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMethodicTypes;
        result = 31 * result + (methodicType != null ? methodicType.hashCode() : 0);
        return result;
    }
}
