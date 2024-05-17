package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

/*
 *Admin:java
 *Admin: Model Class
 * Author: Luke Duffell
 * Student no: 217061567
 * Date: 17 May 2024
 */

@Entity
public class Admin {
    @Id
    private String adminId;
    private String privileges;

    protected Admin(){}

    public Admin(Builder builder){
        this.adminId = builder.adminId;
        this.privileges = builder.privileges;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getPrivileges() {return privileges;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(adminId, admin.adminId) && Objects.equals(privileges, admin.privileges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, privileges);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Admin{" +
                "adminId=" + adminId + '\'' +
                ", privileges=" + privileges + '\'' +
                '}';
    }

    public static class Builder{
        private String adminId;
        private String privileges;

        public Builder setAdminId(String adminId){
            this.adminId = adminId;
            return this;
        }

        public Builder setPrivileges(String privileges){
            this.privileges = privileges;
            return this;
        }

        public Builder copy(Admin admin){
            this.adminId = admin.adminId;
            this.privileges = admin.privileges;
            return this;
        }

        public Admin build(){
            return new Admin(this);
        }
    }
}
