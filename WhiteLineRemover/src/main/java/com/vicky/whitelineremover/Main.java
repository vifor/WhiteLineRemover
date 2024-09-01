/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.vicky.whitelineremover;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
/**
 *
 * @author victoria
 */
public class Main {

    /**
     * @param args the command line arguments
     */

private static int height, width;
private static  BufferedImage image;
private static File inputFile;

    public static void main(String[] args) {
    
     String imageName = args[0];
     System.out.println("se analizara presencia de lineas blancas en "+ imageName);
     
      try{
            loadImage(imageName);
            Analyzer analizer = new Analyzer();
            if(analizer.confirmsWhiteLine(image, width, height))
               {
                System.out.println("Se confirmo linea blanca");
                BackupManager backuper = new BackupManager();
                
                backuper.doBackup(image);
                
                Cropper cropper = new Cropper();
               BufferedImage newImage= cropper.removeLastLine(image, width, height);
  // Determine the format of the input file
            String formatName = getFormatName(inputFile);                

                // Write the modified image back to the original file
                ImageIO.write(newImage, formatName, inputFile); 

               }
    



    }
    catch(Exception ex)
    {
       System.out.println("Excepcion "+ ex.getMessage());
    }
    
}

    private static void loadImage(String imageName) throws IOException {

            inputFile = new File(imageName);
            image = ImageIO.read(inputFile);

            // Process the image to remove white lines
            width = image.getWidth();
            height = image.getHeight();

        }
    private static String getFormatName(File file) throws Exception {
        // Get the file extension
        String fileName = file.getName();
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

        // Check if the extension is a known image format
        Iterator<ImageWriter> writers = ImageIO.getImageWritersBySuffix(extension);
        if (writers.hasNext()) {
            return writers.next().getOriginatingProvider().getFormatNames()[0];
        }

        // If the extension is not recognized, try to infer the format from the file itself
        ImageInputStream iis = ImageIO.createImageInputStream(file);
        Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
        if (readers.hasNext()) {
            return readers.next().getFormatName();
        }

        throw new IllegalArgumentException("Unknown image format for file: " + fileName);
    }
}