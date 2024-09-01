/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vicky.whitelineremover;

import java.awt.image.BufferedImage;

import java.util.ArrayList;

/**
 *
 * @author victoria
 */
public class Analyzer {

    boolean confirmsWhiteLine(BufferedImage image, int width, int height) {
       

boolean isWhiteLine = false;

 try{


       int whitePixelCount = 0;

// recorro ultima linea para confirmar que al menos un 50% de pixels se
// acercan al blanco en escala de grises
// TO DO: hacer que los topes y threshold sean configurables 


 for (int x = 0; x < width; x++) {
                      int grayValue = getGrayValue(image.getRGB(x, height-1));
                    if(grayValue > 240)
                         whitePixelCount++;

                }


                // Calculo el %
                double whitePercentage = (double) whitePixelCount / width * 100;
                System.out.println("Porcentaje de blancos: "+ whitePercentage);
                if (whitePercentage >= 50.0) {
                
     // analizo el renglon anterior para ver si es un Edge. Porque, puede ser 
     // una imagen con fondo blanco o muy clarito con algun detalle en el último renglón

ArrayList modulos = new ArrayList();
          for (int x = 0; x < width; x++) {
     
                     int grayValuePenultima = getGrayValue(image.getRGB(x, height-2));                       
                       int grayValueUltima = getGrayValue(image.getRGB(x, height-1));

                    modulos.add(Math.abs(grayValuePenultima - grayValueUltima));
                    System.out.println(grayValuePenultima - grayValueUltima);

                      
            }


              if (countGreaterThan80(modulos)> (width * 0.8)) isWhiteLine = true;
                
     

}
        } catch (Exception e) {
            e.printStackTrace();
        }
         
          return isWhiteLine;
   }
        // Helper para verificar que un pixel es blanco
        // tomo 80 como diferencia porque implica una variación sustancial entre colores    

  
private  int getGrayValue(int pixel) {
        int red = (pixel >> 16) & 0xFF;
        int green = (pixel >> 8) & 0xFF;
        int blue = pixel & 0xFF;
        // Usar la fórmula de luminancia para calcular el valor en escala de grises
        return (int)(0.299 * red + 0.587 * green + 0.114 * blue);
    }
   public int countGreaterThan80(ArrayList<Integer> list) {
        int count = 0;
        for (int number : list) {
            if (number > 80) {
                count++;
            }
        }
        return count;
    }

}
