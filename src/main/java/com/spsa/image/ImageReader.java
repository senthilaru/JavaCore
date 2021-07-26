package com.spsa.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.imageio.ImageIO;

public class ImageReader {

	public void oldProcessImageThreads() {
		try {
			File inputFile = new File("src/main/resources/image/shrek.jpg");
			final File processedImageFile = new File("src/main/resources/image/shrek-out.jpg");
			System.out.println("f.getAbsoluteFile():" + inputFile.getAbsoluteFile());
			final BufferedImage bufferedImage = ImageIO.read(inputFile);
			System.out.println("bufferedImage.getHeight():" + bufferedImage.getHeight()
					+ "::bufferedImage.getWidth():" + bufferedImage.getWidth());

			final WritableRaster raster = bufferedImage.getRaster();
			long startTs = System.currentTimeMillis();
			System.out.println("raster.getHeight():" + raster.getHeight() + "::raster.getWidth():"
					+ raster.getWidth());

			int[] srcImgPixels = bufferedImage.getRGB(0, 0, bufferedImage.getWidth(),
					bufferedImage.getHeight(), null, 0, 0);

			OldSegmentProcess(bufferedImage, raster, 0, 0, raster.getWidth() / 2,
					raster.getHeight() / 2);
			OldSegmentProcess(bufferedImage, raster, raster.getWidth() / 2, 0, raster.getWidth(),
					raster.getHeight() / 2);
			OldSegmentProcess(bufferedImage, raster, 0, raster.getHeight() / 2,
					raster.getWidth() / 2, raster.getHeight());
			OldSegmentProcess(bufferedImage, raster, raster.getWidth() / 2, raster.getHeight() / 2,
					raster.getWidth(), raster.getHeight());

			ImageIO.write(
					bufferedImage,
					"jpg",
					new BufferedOutputStream(Files.newOutputStream(
							Paths.get(processedImageFile.toURI()), StandardOpenOption.CREATE)));
			System.out.println("Time Taken Total:" + (System.currentTimeMillis() - startTs));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void oldProcessImage() {
		try {
			File inputFile = new File("src/main/resources/image/shrek.jpg");
			final File processedImageFile = new File("src/main/resources/image/shrek-out.jpg");
			System.out.println("f.getAbsoluteFile():" + inputFile.getAbsoluteFile());
			final BufferedImage bufferedImage = ImageIO.read(inputFile);
			System.out.println("bufferedImage.getHeight():" + bufferedImage.getHeight()
					+ "::bufferedImage.getWidth():" + bufferedImage.getWidth());

			final WritableRaster raster = bufferedImage.getRaster();
			long startTs = System.currentTimeMillis();
			System.out.println("raster.getHeight():" + raster.getHeight() + "::raster.getWidth():"
					+ raster.getWidth());

			OldSegmentProcess(bufferedImage, raster, 0, 0, raster.getWidth() / 2,
					raster.getHeight() / 2);
			OldSegmentProcess(bufferedImage, raster, raster.getWidth() / 2, 0, raster.getWidth(),
					raster.getHeight() / 2);
			OldSegmentProcess(bufferedImage, raster, 0, raster.getHeight() / 2,
					raster.getWidth() / 2, raster.getHeight());
			OldSegmentProcess(bufferedImage, raster, raster.getWidth() / 2, raster.getHeight() / 2,
					raster.getWidth(), raster.getHeight());

			ImageIO.write(
					bufferedImage,
					"jpg",
					new BufferedOutputStream(Files.newOutputStream(
							Paths.get(processedImageFile.toURI()), StandardOpenOption.CREATE)));
			System.out.println("Time Taken Total:" + (System.currentTimeMillis() - startTs));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void processImageConcurrently() {
		try {
			File inputFile = new File("src/main/resources/image/shrek.jpg");
			File processedImageFile = new File("src/main/resources/image/shrek-out.jpg");
			System.out.println("f.getAbsoluteFile():" + inputFile.getAbsoluteFile());

			//Source Image into Array For processing
			final BufferedImage bufferedImage = ImageIO.read(inputFile);
			System.out.println("bufferedImage.getColorModel():" + bufferedImage.getColorModel());
			int[] srcImgPixels = new int[bufferedImage.getWidth() * bufferedImage.getHeight()];
			bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(),
					srcImgPixels, 0, bufferedImage.getWidth());

			// Process Image Array

			// Destination Image Config
			int[] dst = new int[srcImgPixels.length];
			BufferedImage dstImage = bufferedImage.getSubimage(0, 0, bufferedImage.getWidth(),
					bufferedImage.getHeight());
			processImage(srcImgPixels, dst);

			dstImage.setRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), dst, 0,
					bufferedImage.getWidth());
			System.out.println("dstImage.getColorModel():" + dstImage.getColorModel());
			ImageIO.write(
					dstImage,
					"jpg",
					new BufferedOutputStream(Files.newOutputStream(
							Paths.get(processedImageFile.toURI()), StandardOpenOption.CREATE)));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BufferedImage blur(BufferedImage srcImage) {
		int w = srcImage.getWidth();
		int h = srcImage.getHeight();

		int[] src = srcImage.getRGB(0, 0, w, h, null, 0, w);
		int[] dst = new int[src.length];

		System.out.println("Array size is " + src.length);
//        System.out.println("Threshold is " + sThreshold);

		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println(Integer.toString(processors) + " processor"
				+ (processors != 1 ? "s are " : " is ") + "available");

//        ForkBlur fb = new ForkBlur(src, 0, src.length, dst);
//
//        ForkJoinPool pool = new ForkJoinPool();
//
//        long startTime = System.currentTimeMillis();
//        pool.invoke(fb);
//        long endTime = System.currentTimeMillis();

//        System.out.println("Image blur took " + (endTime - startTime) +
//                " milliseconds.");

		BufferedImage dstImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dstImage.setRGB(0, 0, w, h, dst, 0, w);

		return dstImage;
	}

	public void processImage(int[] srcImg, int[] destImg) {
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

	public void OldSegmentProcess(BufferedImage bufferedImage, WritableRaster raster, int startX,
			int startY, int imgWidth, int imgHeight) {
		for (int y = startY; y < imgHeight; y++) {
			for (int x = startX; x < imgWidth; x++) {
				Color color = new Color(bufferedImage.getRGB(x, y));
				int argb = bufferedImage.getRGB(x, y);
				int oldAlpha = (argb >>> 24);
				argb = (80 << 24) | (argb & 0xffffff);
				bufferedImage.setRGB(x, y, argb);
//					System.out.println("color:["+ color.getAlpha() +" - " +color.getRed() + "," + color.getGreen() + "," + color.getBlue()+"]");

				int[] newRgb = new int[] { (0), 0, color.getBlue() };
				raster.setPixel(x, y, newRgb);
			}
		}
	}

	public static void main(String[] args) {
		ImageReader reader = new ImageReader();
		reader.processImageConcurrently();

	}

}
