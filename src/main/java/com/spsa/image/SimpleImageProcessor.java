package com.spsa.image;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.imageio.ImageIO;

public class SimpleImageProcessor {

	public void processImage() {
		try {
			File inputFile = new File("src/main/resources/image/shrek.jpg");
			File processedImageFile = new File("src/main/resources/image/shrek-out.jpg");
			System.out.println("f.getAbsoluteFile():" + inputFile.getAbsoluteFile());

			//Source Image into Array For processing
			final BufferedImage bufferedImage = ImageIO.read(inputFile);
			System.out.println("bufferedImage.getColorModel():" + bufferedImage.getColorModel());
			int[] srcImgPixels = new int[bufferedImage.getWidth() * bufferedImage.getHeight()];
			bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), srcImgPixels, 0,
					bufferedImage.getWidth());

			// Destination Image Config
			int[] dst = new int[srcImgPixels.length];
			BufferedImage dstImage = bufferedImage.getSubimage(0, 0, bufferedImage.getWidth(),
					bufferedImage.getHeight());

			// Process Image Array
			long startTs = System.currentTimeMillis();
			processImage(srcImgPixels, dst);
			System.out.println("Time taken to Process:" + (System.currentTimeMillis() - startTs));

			dstImage.setRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), dst, 0, bufferedImage.getWidth());
			System.out.println("dstImage.getColorModel():" + dstImage.getColorModel());
			ImageIO.write(
					dstImage,
					"jpg",
					new BufferedOutputStream(Files.newOutputStream(Paths.get(processedImageFile.toURI()),
							StandardOpenOption.CREATE)));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void processImage(int[] srcImg, int[] destImg) {
		System.out.println("srcImg Length:" + srcImg.length);
		for (int i = 0; i < srcImg.length; i++) {
			int srcPixel = srcImg[i];
			int red = (srcPixel & 0x00FF0000) >> 16;
			int green = (srcPixel & 0x0000FF00) >> 8;
			int blue = (srcPixel & 0x000000FF) >> 0;

			red = red * 2;
//			green = (int) (green * 0.1);
//			blue = (int) (blue * 0.1);

			destImg[i] = ((0xFF000000) | (red << 16) | (green << 8) | (blue << 0));
		}
	}

	public static void main(String[] args) {
		SimpleImageProcessor reader = new SimpleImageProcessor();
		reader.processImage();

	}

}
