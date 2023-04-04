package JDBChomework;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainJDBC {
    static int option;
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        ImplJDBC implJDBC = new ImplJDBC();
        JDBCMethod jdbcMethod = new JDBCMethod();
        Connection conn = implJDBC.dataSource().getConnection();


        do {
            System.out.println(">>>>>>>> Welcome to JDBC Operations <<<<<<<<");
            System.out.println(">>>>>> 1. Insert Your Database");
            System.out.println(">>>>>> 2. Update Your Database");
            System.out.println(">>>>>> 3. Delete Your Database");
            System.out.println(">>>>>> 4. Select Your Database");
            System.out.println(">>>>>> 5. Exist From Operation");
            System.out.println(">>>>>> Choose option from 1 - 5 ");

            option = scanner.nextInt();
            switch (option){
                case 1 :

                    boolean isINSERTValid = false;
                    do {
                        System.out.println("======================= Insert Your Data =======================");
                        System.out.println("Enter ID:");
                        jdbcMethod.setId(scanner.nextInt());
                        System.out.println("Enter Username:");
                        jdbcMethod.setName(scanner.next());
                        System.out.println("Enter Description:");
                        jdbcMethod.setDescription(scanner.next());
                        System.out.println("Enter Email:");

                        try {
                            String insert =  "INSERT INTO jdbchomework (id ,username, description)VALUES(?,?,?)";
                            PreparedStatement statement = conn.prepareStatement(insert);
                            statement.setInt(1, jdbcMethod.getId());
                            statement.setString(2,jdbcMethod.getUsername());
                            statement.setString(3, jdbcMethod.getDescription());
                            statement.executeUpdate();
                            System.out.println("Successfully Inserted");
                            isINSERTValid = true;
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }while (!isINSERTValid);

                case 2 :

                    boolean isUpdateValid = false;
                    System.out.println("Input Your ID to Update:");
                    jdbcMethod.setId(scanner.nextInt());
                    do {
                        System.out.println("================== Update Your Database ==================");
                        System.out.println(">>>>1. Update ID ");
                        System.out.println(">>>>2. Update Username ");
                        System.out.println(">>>>3. Exist ");
                        option = scanner.nextInt();

                        switch (option){
                            case 1 :
                                System.out.println(">>>> Update ID <<<<");
                                try {
                                    Statement statement2 = conn.createStatement();

                                    String newID = "";
                                    String updateID = "UPDATE jdbchomework set id = '" + newID +"'WHERE id = '" +jdbcMethod.getId()+"'";
                                    int upID = statement2.executeUpdate(updateID);
                                    if (upID > 0){
                                        isUpdateValid = true;
                                        System.out.println("ID Successfully Updated");}
                                    else
                                        System.out.println("Retry To Update ID Later!!!");
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            case 2:
                                System.out.println(">>>> Update Username <<<<");
                                try {
                                    Statement statement3 = conn.createStatement();

                                    String newUSERNAME = "";
                                    String updateUSER = "UPDATE jdbchomework set username = '" + newUSERNAME +"'WHERE username = '" +jdbcMethod.getUsername()+"'";
                                    int upUSER = statement3.executeUpdate(updateUSER);
                                    if (upUSER > 0){
                                        isUpdateValid = true;
                                        System.out.println("Username Successfully Updated");}
                                    else
                                        System.out.println("Retry To Update Username Later!!!");
                                } catch (SQLException e) {
                                   e.printStackTrace();
                                }
                            case 3:
                                System.out.println("-----------------Exist------------------");
                        }

                    }while (!isUpdateValid);
                case 3 :

                    boolean isDeleteValid = false;
                    System.out.println("Input your ID to entry the Delete Operation:");
                    jdbcMethod.setId(scanner.nextInt());

                    do {
                        System.out.println("================= Delete Your Database ==================== ");
                        System.out.println(">>>>1. Delete by ID ");
                        System.out.println(">>>>2. Delete by Username ");
                        System.out.println(">>>>3. Exist ");
                        option = scanner.nextInt();
                        switch (option){
                            case 1:
                                System.out.println(">>>> Delete by ID <<<<");
                                try {
                                    Statement statement6 = conn.createStatement();

                                    String deleteID = "DELETE from jdbchomework WHERE id = '" + jdbcMethod.getId() +
                                            "'username = '"+jdbcMethod.getUsername()+"'description = '"+jdbcMethod.getDescription()+"'";
                                    int delID = statement6.executeUpdate(deleteID);
                                    if (delID > 0){
                                        isDeleteValid = true;
                                        System.out.println("One UserAccount Successfully Deleted");}
                                    else
                                        System.out.println("Retry again later!!!");
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                            case 2:
                                System.out.println(">>>> Delete by Username <<<<");
                                try {
                                    Statement statement7 = conn.createStatement();

                                    String deleteID = "DELETE from jdbchomework WHERE username = '" + jdbcMethod.getUsername() +
                                            "'id = '"+jdbcMethod.getId()+"'description = '"+jdbcMethod.getDescription()+"'";
                                    int delUser = statement7.executeUpdate(deleteID);
                                    if (delUser > 0){
                                        isDeleteValid = true;
                                        System.out.println("One UserAccount Successfully Deleted");}
                                    else
                                        System.out.println("Retry again later!!!");
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            case 3:  System.out.println("-----------------Exist------------------");
                        }
                    }while (!isDeleteValid);
                case 4 :

                    boolean isSelectValid = false;
                    do {
                        System.out.println("=================== Select Your Database =====================");
                        System.out.println(">>>>1. Select by ID ");
                        System.out.println(">>>>2. Select by Username ");
                        System.out.println(">>>>3. Select by All ");
                        System.out.println(">>>>4. Exist");
                        option = scanner.nextInt();

                        switch (option){
                            case 1:
                                System.out.println(">>>> Select by ID <<<<");
                                try {
                                    Statement statement8 = conn.createStatement();

                                    String selectID = "SELECT * FROM jdbchomework WHERE id = '"+jdbcMethod.getId()+"'";
                                    ResultSet rs = statement8.executeQuery(selectID);
                                    if (rs.next()) {
                                        isSelectValid = true;
                                        System.out.println("Your Database ID: " +rs.getInt("id"));
                                    }
                                    else
                                        System.out.println("No such User id is already registered");

                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            case 2:
                                System.out.println(">>>> Select by Username <<<<");
                                try {
                                    Statement statement9 = conn.createStatement();

                                    String selectUSER = "SELECT * FROM jdbchomework WHERE username = '"+jdbcMethod.getId()+"'";
                                    ResultSet rs = statement9.executeQuery(selectUSER);
                                    if (rs.next()) {
                                        isSelectValid = true;
                                        System.out.println("Your Database Username: " +rs.getString("username"));
                                    }
                                    else
                                        System.out.println("No such Username is already registered");

                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            case 3:
                                System.out.println(">>>> Select ALL  <<<<");
                                try {
                                    String selectALL = "SELECT * FROM jdbchomework ";
                                    PreparedStatement preparedStatement = conn.prepareStatement(selectALL);
                                    ResultSet rs = preparedStatement.executeQuery(selectALL);
                                    List<JDBCMethod> jdbcMethodList = new ArrayList<>();
                                    if (rs.next()) {
                                        isSelectValid = true;
                                        Integer id = rs.getInt("id");
                                        String username = rs.getString("username");
                                        String description = rs.getString("description");
                                        String email = rs.getString("course");
                                        String pwd = rs.getString("pwd");
                                        jdbcMethodList.add(new JDBCMethod(id,username,description));
                                        jdbcMethodList.forEach(System.out::println);
                                    }
                                    else
                                        System.out.println("None User is already registered");
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            case 4 :     System.out.println("-----------------Exist------------------");
                        }
                    }while (!isSelectValid);
                case 5 : System.out.println("-----------------Exist------------------");
            }
        }while (option!=5);
    }

}
