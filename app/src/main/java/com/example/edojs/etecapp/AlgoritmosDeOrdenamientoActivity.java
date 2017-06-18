package com.example.edojs.etecapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;

public class AlgoritmosDeOrdenamientoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algoritmos_de_busqueda);
    }
}




//********************** BubleSort ************************
class BubleSort {

    public static String[] bubble_srtPRECIO(String lista) {


        String[] array = lista.split(",");
        float a =9;

        int n = array.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;


                String[] produUno = array[i].split(";");
                float precioUno = Float.parseFloat(produUno[3]);

                String[] produDos = array[k].split(";");
                float precioDos = Float.parseFloat(produDos[3]);



                if (precioUno > precioDos) {
                    String temp;
                    temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
            }
        }
        return array;
    }


    public static String[] bubble_srtStrArray(String[] inputStrArray) { //ordena el string array
        String[] strArray = inputStrArray;
        for(int j=0;j<strArray.length;j++) {
            for(int i=0;i<strArray.length-(j+1);i++) {
                if (strArray[i].compareTo(strArray[i+1])>0) {
                    String aux;
                    aux=strArray[i];
                    strArray[i]=strArray[i+1];
                    strArray[i+1]=aux;
                }
            }
        }
        return strArray;
    }

    public static void imprimirInfo(String[] strArray) {
        for(int i=0;i<strArray.length;i++) {
            System.out.print(strArray[i]+",");
        }
    }


    private static void printNumbers(int[] input) {

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println("\n");
    }

    public static void runIntPrecioBubleSort(String inputPrecioArray) { //Se llama este metodo para ordenar por precio
        bubble_srtPRECIO(inputPrecioArray);



    }
    public static void runStringBubleSort(String[] strArray) {  //Se llama este metodo para ordenar alfabeticamente
        String[] inputStrArray = strArray;
        bubble_srtStrArray(inputStrArray);
    }
}













//******************** QuickSort ************************
class QuickSort{

    public static String[] ordenarStringQuicksrt(String[] strArray){
        //Array de String
        String[] inputStrArray = strArray;

        //Ordena el array
        Arrays.sort(inputStrArray);

        return inputStrArray;
    }

    public static int[] ordenarIntQuicksrt(int[] intArray){
        //Array de String
        int[] inputIntArray = intArray;

        //Ordena el array
        Arrays.sort(inputIntArray);

        return inputIntArray;
    }



    public static void runIntQuicksrt(int[] intArray) {
        ordenarIntQuicksrt(intArray);

    }

    public static void runStringQuicksrt(String[] strArray) {
        ordenarStringQuicksrt(strArray);
    }
}




