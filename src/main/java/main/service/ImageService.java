package main.service;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class ImageService {

  static String uploadFld = "D:/Skill/IdeaProjects/BlogEngine/src/main/resources/static/";

   public static String imageResize(MultipartFile photo, String dstFolder, String fileName) {

      try {

        BufferedImage image = ImageIO.read(photo.getInputStream());

        int newWidth = 36;
        int newHeight = 36;

        newWidth *= 2;
        newHeight *= 2;

        BufferedImage newImage = new BufferedImage(
            newWidth, newHeight, BufferedImage.TYPE_INT_RGB
        );

        int widthStep = image.getWidth() / newWidth;
        int heightStep = image.getHeight() / newHeight;

        for (int x = 0; x < newWidth; x++) {
          for (int y = 0; y < newHeight; y++) {
            int rgb = image.getRGB(x * widthStep, y * heightStep);
            newImage.setRGB(x, y, rgb);
          }
        }


        AffineTransform transform = AffineTransform.getScaleInstance(0.5, 0.5);
        AffineTransformOp op = new AffineTransformOp(transform, (AffineTransformOp.TYPE_NEAREST_NEIGHBOR) );

        newImage = op.filter(newImage, null);

        File dir = new File((uploadFld+dstFolder));

        if (!dir.exists()) {
          dir.mkdir();
        }

        File newFile = new File((uploadFld+dstFolder) , fileName );
        if (newFile.exists()){
          newFile.delete();
        }

        try
        {
          boolean created = newFile.createNewFile();
          if(created)
            ImageIO.write(newImage, "jpg", newFile);
        }
        catch(IOException ex){

          System.out.println(ex.getMessage());
        }

      } catch (Exception ex) {
        ex.printStackTrace();
      }

      return "/" + dstFolder + "/" + fileName;
    }


  public static String imageDelete(String dstFolder, String fileName) {

      File deleteFile = new File((uploadFld+dstFolder) , fileName );
      if (deleteFile.exists()){
        deleteFile.delete();
      }

    return "";
  }



  public static String imageLoad(MultipartFile imageIn, String dstFolder, String fileName) {

     boolean resultLoad = false;
     
    try {

      String extension = FilenameUtils.getExtension(imageIn.getOriginalFilename());

      BufferedImage image = ImageIO.read(imageIn.getInputStream());

      File dir = new File((uploadFld + dstFolder));

      if (!dir.exists()) {
        dir.mkdirs();
      }

      File newFile = new File((uploadFld+dstFolder) , fileName );
      if (newFile.exists()){
        newFile.delete();
      }

      try
      {
        boolean created = newFile.createNewFile();
        if(created)
          resultLoad = ImageIO.write(image, "jpg", newFile);
      }
      catch(IOException ex){

        System.out.println(ex.getMessage());
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return resultLoad ? "/" + dstFolder + "/" +  fileName : "";
  }

}



