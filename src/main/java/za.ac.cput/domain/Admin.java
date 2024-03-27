package za.ac.cput.domain;

/*
 *User:java
 *User: Model Class
 * Author: Luke Duffell
 * Student no: 217061567
 * Date: 27 March 2024
 */

public class Admin {
    private String adminId;
    private String privileges;

    public Admin(){
    }

    private Admin(Builder builder){
        this.adminId = builder.adminId;
        this.privileges = builder.privileges;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getPrivileges() {
        return privileges;
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
