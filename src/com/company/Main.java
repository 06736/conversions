package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean stop = false;

        while(stop == false){
            System.out.println("1 for Binary -> Denary\n2 for Binary -> Hex\n3 for Denary -> Binary\n4 for Denary -> Hex\n5 for Hex -> Denary\n6 for Hex ->Binary\n7 to Quit");
            String choice_of_conversion = in.nextLine();
            int real_choice = Integer.parseInt(choice_of_conversion);
            switch (real_choice){
                case 1:
                    System.out.println("How many Bits is the binary number?");
                    String a = in.nextLine();
                    int bits1 = Integer.parseInt(a);
                    System.out.println("Please enter the binary number:");
                    String binary_number = in.nextLine();
                    System.out.println(binary_to_denary(bits1, binary_number));
                    break;
                case 2:
                    System.out.println("How many bits is the binary number?");
                    String b = in.nextLine();
                    int bits2 = Integer.parseInt(b);
                    System.out.println("Please enter the binary number:");
                    String binary_number2 = in.nextLine();
                    System.out.println(binary_to_hex(bits2, binary_number2));
                    break;
                case 3:
                    System.out.println("Please enter the denary number");
                    String c = in.nextLine();
                    int denary = Integer.parseInt(c);
                    System.out.println(denary_to_binary(denary));
                    break;
                case 4:
                    System.out.println("Please enter the denary number");
                    String d = in.nextLine();
                    int denary2 = Integer.parseInt(d);
                    System.out.println(denary_to_hex(denary2));
                    break;
                case 5:
                    System.out.println("Please enter the hex value");
                    String hex = in.nextLine();
                    System.out.println(hex_to_denary(hex));
                    break;
                case 6:
                    break;
                case 7:
                    stop = true;
                    break;
            }

        }
    }
    public static int binary_to_denary(int bits1, String binary_number){
        ArrayList<Integer> bitsAmount = new ArrayList<Integer>();
        int place_value = 1;
        int denary_value = 0;
        for(int i = 0;i<bits1;i++){
            bitsAmount.add(place_value);
            place_value *= 2;
        }
        Collections.reverse(bitsAmount);
        for(int i = 0; i<bits1;i++){
            if(binary_number.charAt(i) == '1'){
                denary_value += bitsAmount.get(i);
            }
        }
        return denary_value;
    }
    public static String binary_to_hex(int bits2, String binary_number2){
        ArrayList<String> nibbleString = new ArrayList<String>();
        Integer[] place_values = {8,4,2,1};
        String[] hex_values = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

        String hex_final = "";
        int nibbles = bits2/4;
        for(int i = 0; i < nibbles;i++){
            nibbleString.add(binary_number2.substring(i*4, i*4+4));
        }
        for(int i = 0; i < nibbleString.size(); i++){
            int place_value = 0;
            for(int j = 0; j < 4;j++) {
                if (nibbleString.get(i).charAt(j) == '1') {
                    place_value += place_values[j];

                }
            }
            hex_final += hex_values[place_value];
        }
        return hex_final;
    }
    public static String denary_to_binary(int denary){
        String binary = "";
        int weight = 1;
        for(int x = 1; weight <= denary;x*=2){weight = x;}
        for(int y = weight; y >=1; y/=2){
            if(y<=denary){
                binary += "1";
                denary -= y;
            }else{
                binary += "0";
            }
        }
        return binary;
    }
    public static String denary_to_hex(int denary2){
        String digits = "0123456789ABCDEF";
        if (denary2 <= 0) return "0";
        int base = 16;
        String hex = "";
        while (denary2 > 0) {
            int digit = denary2 % base;
            hex = digits.charAt(digit) + hex;
            denary2 = denary2 / base;
        }
        return hex;
    }
    public static int hex_to_denary(String hex){
        String hex_values = "0123456789ABCDEF";
        int denary = 0;
        int len = hex.length();
        for(int i = 0;i < len;i++){
            denary += hex_values.indexOf(hex.charAt(i));
            
        }
        System.out.println(denary);
        return denary;

    }
    }



