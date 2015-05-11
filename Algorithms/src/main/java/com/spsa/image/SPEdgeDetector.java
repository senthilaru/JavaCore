/**
 *
 */
package com.spsa.image;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

/**
 * @author sarumu1
 *
 */
public class SPEdgeDetector {
	private static final int SURROUNDING_DEPTH = 1;

	public void processImage() {
		try {
			File inputFile = new File("src/main/resources/image/shrek.jpg");
			File processedImageFile = new File("src/main/resources/image/shrek-out.jpg");
			System.out.println("f.getAbsoluteFile():" + inputFile.getAbsoluteFile());

			//Source Image into Array For processing
			BufferedImage srcBufImg = ImageIO.read(inputFile);
			System.out.println("bufferedImage.getColorModel():" + srcBufImg.getColorModel());
			int[] srcImgPixels = new int[srcBufImg.getWidth() * srcBufImg.getHeight()];
			srcImgPixels = srcBufImg.getRGB(0, 0, srcBufImg.getWidth(), srcBufImg.getHeight(), srcImgPixels, 0,
					srcBufImg.getWidth());

			// Destination Image Config
			int[] dst = new int[srcImgPixels.length];

			// Process Image Array
			long startTs = System.currentTimeMillis();
			BufferedImage dstImage = processImage(srcBufImg, srcImgPixels, dst);
			System.out.println("Time taken to Process:" + (System.currentTimeMillis() - startTs));

//			dstImage.setRGB(0, 0, srcBufImg.getWidth(), srcBufImg.getHeight(), dst, 0, srcBufImg.getWidth());
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

	public BufferedImage processImage(BufferedImage srcBufImg, int[] srcImg, int[] destImg) {
		ImageUtil util = new ImageUtil(srcBufImg.getWidth(), srcBufImg.getHeight());

		int threshold = util.findThreshold(srcImg); // 065530;//
		Set<Integer> diffPixArray = new HashSet<>();

		for (int pixelIndex = 0; pixelIndex < srcImg.length; pixelIndex++) {
			List<Integer> surroundedPixels = util.getSurroundingPixels(pixelIndex, srcImg, SURROUNDING_DEPTH);
			if (surroundedPixels.size() != 0) {
//				System.out.println("surroundedPixels;" + surroundedPixels);
				Collections.sort(surroundedPixels);
				int lowPixel = surroundedPixels.get(0);
				int highPixel = surroundedPixels.get(surroundedPixels.size() - 1);
//				if ((highPixel - lowPixel) != 0) {
//					System.out.println(util.arrayToXY(pixelIndex) + " :: lowPixel:" + lowPixel + " :: highPixel:"
//							+ highPixel + " :: Diff:" + (highPixel - lowPixel));
//				}
				diffPixArray.add(highPixel - lowPixel);
				if ((highPixel - lowPixel) > threshold) {
					destImg[pixelIndex] = 0xFFFFFFFF;
				} else {
					destImg[pixelIndex] = 0x00000000;
				}
			}
//			if (pixelIndex == 3) {
//				break;
//			}
		}
		System.out.println("diffPixArray;" + diffPixArray);
		System.out.println("srcImg.length:" + srcImg.length + ":: destImg:" + destImg.length);
		BufferedImage dstImage = srcBufImg.getSubimage(0, 0, srcBufImg.getWidth(), srcBufImg.getHeight());
		dstImage.setRGB(0, 0, srcBufImg.getWidth(), srcBufImg.getHeight(), destImg, 0, srcBufImg.getWidth());
		return dstImage;
	}

	/**
	 * @param srcImg
	 * @param i
	 * @return
	 */

	public static void main(String[] args) {
		SPEdgeDetector reader = new SPEdgeDetector();
		reader.processImage();

	}
}
