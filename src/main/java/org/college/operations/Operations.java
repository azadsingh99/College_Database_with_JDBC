package org.college.operations;

import org.Collge.connection.JDBCconnect;

import java.sql.ResultSet;
import java.util.Scanner;

public class Operations {

    public static void main(String args[]) throws Exception {

        int option, result;
        int roll_no;
        String name, query;
        String standard;
        float marks;

        Scanner sc = new Scanner(System.in);
        JDBCconnect jdbc = new JDBCconnect();

        while(true){
            System.out.println("--------COLLEGE DATABASE---------");
            System.out.println("1. SYBSC");
            System.out.println("2. TYBSC");
            System.out.println("3. EXIT");
            System.out.print("Choose Option : ");
            option = sc.nextInt();

            switch (option){
                case 1:
                    System.out.println("1. ADD NEW STUDENT");
                    System.out.println("2. REMOVE STUDENT DATA");
                    System.out.println("3. UPDATE MARKS");
                    System.out.println("4. DISPLAY STUDENT DATA");
                    System.out.println("5. EXIT");

                    System.out.print("Choose Option : ");
                    option = sc.nextInt();

                    switch (option){
                        case 1:
                            System.out.print("Enter Roll No : ");
                            roll_no = sc.nextInt();

                            System.out.println("Enter Student's Name : ");
                            name = sc.next();

                            System.out.println("Enter total Marks : ");
                            marks = sc.nextFloat();

                            query = "INSERT INTO sy_student values("+roll_no+", '"+ name +"',"+ marks+")";
                            System.out.println(query);
                            result = jdbc.executeUpdate(query);
                            System.out.println(result + " DATA INSERTED");
                            break;

                        case 2:
                            System.out.print("Enter Student's Roll No : ");
                            roll_no = sc.nextInt();

                            query = "DELETE FROM sy_student where roll_no = " + roll_no;
                            System.out.println(query);
                            result = jdbc.executeUpdate(query);
                            System.out.println(result + " DATA DELETED");
                            break;

                        case 3:
                            System.out.print("Enter Student's Roll_no : ");
                            roll_no = sc.nextInt();

                            System.out.print("Enter Updated Marks : ");
                            marks = sc.nextFloat();

                            query = "UPDATE sy_student set marks = " + marks +" where roll_no = " + roll_no;
                            System.out.println(query);
                            System.out.println("ROLL NO " + roll_no + " MARKS UPDATED");
                            break;

                        case 4:
                            System.out.print("Enter Student's Roll No : ");
                            roll_no = sc.nextInt();

                            query = "select * from sy_student where roll_no = " + roll_no;
                            System.out.println(query);
                            ResultSet resultSet = jdbc.executeQuery(query);

                            while(resultSet.next()){
                                System.out.println(resultSet.getString("roll_no"));
                                System.out.println(resultSet.getString("name"));
                                System.out.println(resultSet.getString("marks"));
                            }
                            break;
                        case 5:
                            System.out.println("THANKS!!!!!!");
                            System.exit(0);
                    }
            }

        }
    }
}
