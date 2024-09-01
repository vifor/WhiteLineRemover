/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vicky.whitelineremover;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

/**
 *
 * @author victoria
 */
public class BackupManager {

    void doBackup(BufferedImage image) throws IOException {
   
            // Generate timestamp
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

            // Save the processed image with timestamp in the filename
            File outputFile = new File("output_" + timeStamp + ".jpeg");
            ImageIO.write(image, "jpeg", outputFile);

       

   }
    
}
