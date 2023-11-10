/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen1p1_stelinlarios;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author stelinlarios
 */
public class Examen1P1_StelinLarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int selectedOption = 0;
        Scanner sc = new Scanner(System.in);

        while (selectedOption != 3) {
            System.out.println("Seleccione una opción");
            System.out.println("1. Fight or Flight");
            System.out.println("2. Tri Fuerza");
            System.out.println("3. Salir");

            selectedOption = sc.nextInt();

            switch (selectedOption) {
                case 1:
                    System.out.println("Fight or Flight");

                    Random rand = new Random();
                    int level = 0;
                    int extraProb = 0;

                    System.out.println("1. Principiante (0% de hit extra + extra damage)");
                    System.out.println("2. Intermedio (5% de hit extra + extra damage)");
                    System.out.println("3. Experto (15% de hit extra + extra damage)");

                    while (level != 1 && level != 2 && level != 3) {
                        System.out.println("Ingrese maestria");
                        level = sc.nextInt();

                        switch (level) {
                            case 1:
                                extraProb = 0;
                                break;
                            case 2:
                                extraProb = 5;
                                break;
                            case 3:
                                extraProb = 15;
                                break;
                            default:
                                System.out.println("Ingrese una opción valida");
                                break;
                        }
                    }

                    int zombieDistance = rand.nextInt(15) + 16;
                    int zombieHp = 25;
                    int ammo = 20;
                    int hitProb = 60 + extraProb;
                    boolean keepPlaying = true;

                    while (keepPlaying) {

                        System.out.println("El zombie se encuentra a " + zombieDistance + " metros!");
                        System.out.println("El jugador cuenta con  " + ammo + " balas!");

                        ammo--;

                        int randomProb = rand.nextInt(100);

                        if (randomProb <= hitProb) {

                            int zombieDmg = rand.nextInt(7) + 1;
                            zombieHp -= zombieDmg;

                            if (zombieHp > 0) {
                                System.out.println("Hit! El tiro ha reducido del HP del zombie a por un total de: " + zombieDmg);
                                System.out.println("Vida restante del  zombie: " + zombieHp);
                            } else {
                                System.out.println("Vida restante del  zombie 0");
                                System.out.println("YOU WIN! has logrado vencer al zombie");
                                keepPlaying = false;
                            }

                        } else {
                            int zombieMov = rand.nextInt(3) + 3;
                            zombieDistance -= zombieMov;

                            if (zombieDistance > 0) {
                                System.out.println("Ha fallado! El zombie se encuentra a: " + zombieDistance + " metros");

                            } else {
                                System.out.println("Ha fallado! El zombie se encuentra a 0 metros");
                                System.out.println("Game over: la distancia con el zombie se redujo a 0");
                                keepPlaying = false;
                            }

                        }

                        if (ammo == 0 && zombieHp > 0) {
                            System.out.println("Game over: No te quedan balas");
                            keepPlaying = false;
                        }

                        if (zombieHp > 0 && zombieDistance > 0) {
                            char wantsToKeepPlaying = 'z';

                            while (wantsToKeepPlaying != 'S' && wantsToKeepPlaying != 'N') {
                                System.out.println("Listo para la siguiente ronda? [S/N]");
                                wantsToKeepPlaying = sc.next().charAt(0);

                            }

                            if (wantsToKeepPlaying == 'N') {
                                keepPlaying = false;
                            }

                        }

                    }

                    break;
                case 2:
                    System.out.println("Tri Fuerza");
                    System.out.println("Ingrese el tamańo");
                    int figureSize = sc.nextInt();

                    int halfFigureSize = figureSize / 2;

                    if (figureSize % 2 == 0 && figureSize > 20 && halfFigureSize % 2 != 0) {
                        printFigure(figureSize);
                    } else {
                        System.out.println("Número invalido");
                    }

                    break;
                case 3:
                    System.out.println("ADIOS :)");

                    break;
                default:
                    System.out.println("Seleccione una opción valida");
                    break;

            }
        }

    }

    public static void printFigure(int size) {

        int whitespaces = (size / 2) + 1;
        String figure = "";
        int amountOfDots = 1;
        String twoFigures = "";

        while (amountOfDots <= size / 2) {
            for (int i = whitespaces; i > 0; i--) {
                figure = " " + figure;
            }
            for (int i = amountOfDots; i > 0; i--) {
                figure += "*";
            }

            System.out.println(figure);
            twoFigures = twoFigures + figure + '\n';
            whitespaces = whitespaces - 1;
            amountOfDots = amountOfDots + 2;
            figure = "";
        }

        whitespaces = amountOfDots;
        figure = "";
        amountOfDots = 1;
        while (amountOfDots <= size / 2) {
            for (int i = whitespaces; i > 0; i--) {
                figure = " " + figure;
            }
            for (int i = amountOfDots; i > 0; i--) {
                figure += "*";
            }

            System.out.print(figure);
            System.out.println(figure);

            whitespaces = whitespaces - 1;
            amountOfDots = amountOfDots + 2;
            figure = "";
        }

    }

}
