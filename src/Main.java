import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        SSMManager ssm = new SSMManager(20);
        Scanner scanner = new Scanner(System.in);
        File fileReport = new File("filereport.json");
        File urgentFile = new File("urgent.dat");
        try {
            ssm.personRegister("Facundo", "Aguilera", 31, "La Florida", 37867025, "LifeGuard");
            ssm.personRegister("Sofía", "Martínez", 28, "Alfar", 98765432, "Nurse");
            ssm.personRegister("Lucas", "Pérez", 35, "San Jose", 12345678, "Engineer");
            ssm.personRegister("Valentina", "González", 24, "Constitucion", 45678901, "Student");
        } catch (ItDoesntHaveKitsException e) {
            System.out.println("¿Can u get more kits? y/n");
            String question = scanner.nextLine();

            if (question.equalsIgnoreCase("y")) {
                System.out.println("Entry the quantity of new kits: ");
                ssm.setKitsQuantity(30);
                System.out.println("Kits quantity updated");
            }
        }
        //TESTING PERSONS
        ssm.tester();

        //ISOLATING AND ADDING TO FILE
        try {
            ssm.isolate();
        } catch (HighFeverException e) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(urgentFile, true))) {
                writer.write(e.getMessage());
                writer.newLine();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            //GENERATE JSON TO SAVE THE REPORT

            try {
                ssm.generateJson(fileReport);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }
}
