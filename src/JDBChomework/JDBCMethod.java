package JDBChomework;

public class JDBCMethod {
    private Integer id;
    private String username;
    private String description;



    public JDBCMethod(Integer id, String username, String description) {

    }

    public JDBCMethod() {

    }


    @Override
    public String toString() {
        return "JDBCMethod{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void setName(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





    public String getUsername() {
        return username;
    }
}
