import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//import Connector.java;


public class DBSearch {
    public static Connection connection;
    private static String fromKlient;
    private PreparedStatement prep;
    //  private static InputStreamReader ins = new InputStreamReader(System.in);
    // private String bf;

  /*  static {
        try {
            bf = ServerProjekt.sendToKlient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   */

    public static String mail;
    public static String password;
    public static String X;
    static String sendTilbage;
    //private static ServerProjekt serverProjekt = new ServerProjekt();


    static Connector connector = new Connector();


    public static void main(String[] args) throws IOException {
        //connection = null;

        //connection = Connector.getConnection();
        connection = connector.getConnection();


        //getHomeData();
        findUser(mail, password);

    }

    void verifyUser() {

    }

    //db.getHomeData();


    public DBSearch() {


    }

    public static void insertIntoHome() {


    }

    public static ArrayList getHomeData() {
        ArrayList data = new ArrayList();
        try {
            String sql = "select * from sys.login;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
//rs.getDataType( tal) ; giver os en datatype paa den 1, 2 osv. plads -
// Hvad sker hvis vi forsoger at hente et Int fra String?

                System.out.println(rs.getInt(1) + rs.getString("Mail") + rs.getString("Password"));
//hvad hvis vi henviser til det ud fra navne fremfor index?
            }
            connection.close();


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    private static String[] findUser(String mail, String password) {
        String[] result = new String[2];
        String[] mailOgPass;
        String mailsql=null;
        String passwordsql=null;

        try {
            // System.out.println("indtast mail: ");
            mailOgPass = ServerProjekt.sendToKlient();

            mail = mailOgPass[0];
            mail = mail.replace("%40", "@");
            password = mailOgPass[1];


            //    String sql = "select * from sys.login where mail=" +"'" +mail+"'" +"limit 1;";
            String sql = "select * from sys.login where mail= " + "'" + mail + "'" + "and password =" + "'" + password + "'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
//rs.getDataType( tal) ; giver os en datatype paa den 1, 2 osv. plads -
// Hvad sker hvis vi forsoger at hente et Int fra String?

                System.out.println(
                        "mail: " + rs.getString("Mail") + "\n" +
                                "pass:" + rs.getString("Password") + "\n");
//hvad hvis vi henviser til det ud fra navne fremfor index?
                mailsql = rs.getString("Mail");
                passwordsql = rs.getString("Password");



            }

            if (mail.equals(mailsql) && password.equals(passwordsql)) {
                System.out.println("jeg er blevet dum i hovedet");
                X = "Velkommen til:";
                ServerProjekt.sendFromServer(X);


            }
            connection.close();

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return result;

    }


    public static void insertIntoRemote() {


    }

    public static ArrayList getRemoteData() {

        return null;
    }

    /*

    private static String findbruger(String mail, String Pass) {
        String UserCPR = null;
        String sqlFindUser = "\n" + "select idloginoplysninger, cpr, mail from PatientPortal.loginoplysninger where cpr password = 'Johari' and mail = 'daniel@dtu.dk'; ";

       // ResultSet Rs = statement.e

    }

     */
}
