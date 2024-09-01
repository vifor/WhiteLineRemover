/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vicky.whitelineremover;

import java.awt.image.BufferedImage;

/**
 *
 * @author victoria
 */
public class Cropper {


public BufferedImage removeLastLine(BufferedImage image, int width, int height)
{
             // Create a new image with the same width but height-1
             int newHeight = height -1;

            BufferedImage newImage = new BufferedImage(width, newHeight, image.getType());

            // Copy pixels from the original image to the new image
            for (int y = 0; y < newHeight; y++) {
                for (int x = 0; x < width; x++) {
                    newImage.setRGB(x, y, image.getRGB(x, y));
                }
            }

     return newImage;
}        
}
    

