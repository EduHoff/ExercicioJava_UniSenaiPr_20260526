package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import exercises.Exercise;
import utils.ConsoleUtils;



public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ConsoleUtils.clear();
        while (true) {
            try{

                System.out.print("""
                ================================================
                                MENU DE EXERCÍCIOS
                ================================================
                1 - Exercício
                2 - Exercício
                3 - Exercício
                0 - Sair
                ================================================
                """);

                System.out.print("||");
                int num = sc.nextInt();

                if (num == 0) {
                    break;
                }

                Class<?> clazz = Class.forName("exercises.Ex" + num);
                Exercise ex = (Exercise) clazz.getDeclaredConstructor().newInstance();
                ConsoleUtils.clear();
                ex.run(sc);

            
            }catch(InputMismatchException e){
                ConsoleUtils.clear();
                System.out.println("Digite apenas números inteiros!\n");
                sc.nextLine();
            }catch (ClassNotFoundException e) {
                ConsoleUtils.clear();
                System.out.println("Exercício não existe!\n");
            }catch(Exception e){
                ConsoleUtils.clear();
                e.printStackTrace();
            } 
        }

        sc.close();
    }
}