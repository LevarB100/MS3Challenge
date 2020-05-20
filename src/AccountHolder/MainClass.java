package AccountHolder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class MainClass {
  
  public static void main(String[] args) {
    try {
      Class.forName("org.sqlite.JDBC");
      System.out.println("Load driver success");
      
      Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Levar-PC\\java notes\\SQLitenew.db");  
          
      //Query insert to table product with 4 value
      String query = "INSERT INTO MS3Challenge VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      //cREATE pREPARE STATEMENT
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      
     //Get list account from file text
     ArrayList<Account> listAccount = getListAccountFromTextFile ("C:\\Users\\Levar-PC\\java notes\\ms3Interview.csv");
     //Insert list to db; 
     for(int i = 0; i < listAccount.size(); i ++) {
       preparedStatement.setString(1, listAccount.get(i).getA());
       preparedStatement.setString(2, listAccount.get(i).getB());
       preparedStatement.setString(3, listAccount.get(i).getC());
       preparedStatement.setString(4, listAccount.get(i).getD());
       preparedStatement.setString(5, listAccount.get(i).getE());
       preparedStatement.setString(6, listAccount.get(i).getF());
       preparedStatement.setString(7, listAccount.get(i).getG());
       preparedStatement.setString(8, listAccount.get(i).getH());
       preparedStatement.setString(9, listAccount.get(i).getI());
       preparedStatement.setString(10, listAccount.get(i).getJ());
       
       preparedStatement.executeUpdate();
       System.out.println("Insert success record:" + (i + 1));
     }
     
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static ArrayList<Account> getListAccountFromTextFile (String filePath) {
    FileInputStream fis = null;
    InputStreamReader isr = null;
    BufferedReader bReader = null;
    ArrayList<Account> listResult = new ArrayList<Account>();
    try {
      
      fis = new FileInputStream(filePath);
      isr = new InputStreamReader(fis);
      bReader = new BufferedReader(isr);
      // String save line get from text file
      String line = null;
      //Array save product
      String[]strAccount = null;
      
      //Loop and get all data in text file
      while(true) {
        //Get i line
        line = bReader.readLine();
        //Check line get empty, exit loop
        if(line == null) {
          break;
        } else {
          strAccount = line.split(",");
          listResult.add(new Account(strAccount[0], strAccount[1], strAccount[2], strAccount[3], strAccount[4], strAccount[5], strAccount[6], strAccount[7], strAccount[8], strAccount[9] ));
          
        }
      }
      
    } catch (Exception e) {
      System.out.println("read file Error");
      e.printStackTrace();
    } finally {
      //close file
      try {
        bReader.close();
        isr.close();
        fis.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return listResult;
  }
}
