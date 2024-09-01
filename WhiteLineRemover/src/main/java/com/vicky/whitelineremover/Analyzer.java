/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vicky.whitelineremover;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author victoria
 */
public class Analyzer {

    boolean confirmsWhiteLine(BufferedImage image, int width, int height) {
       

boolean isWhiteLine = false;

 try{
   // Extract the last line of the image
            List<Integer> reds = new ArrayList<>();
            List<Integer> greens = new ArrayList<>();
            List<Integer> blues = new ArrayList<>();

            for (int x = 0; x < width; x++) {
                Color color = new Color(image.getRGB(x, height - 1));
                reds.add(color.getRed());
                greens.add(color.getGreen());
                blues.add(color.getBlue());
            }

            // Calculate mean color
            int meanRed = (int) reds.stream().mapToInt(Integer::intValue).average().orElse(0);
            int meanGreen = (int) greens.stream().mapToInt(Integer::intValue).average().orElse(0);
            int meanBlue = (int) blues.stream().mapToInt(Integer::intValue).average().orElse(0);
            Color meanColor = new Color(meanRed, meanGreen, meanBlue);

            // Calculate 95th percentile color
            Collections.sort(reds);
            Collections.sort(greens);
            Collections.sort(blues);
            int p95Index = (int) (0.95 * width);
            Color p95Color = new Color(reds.get(p95Index), greens.get(p95Index), blues.get(p95Index));

            // Print the results
            System.out.println("Mean Color: " + meanColor);
            System.out.println("95th Percentile Color: " + p95Color);
            isWhiteLine = p95Color.equals(Color.WHITE);
        } catch (Exception e) {
            e.printStackTrace();
        }
         
          return isWhiteLine;
   }
    
}
