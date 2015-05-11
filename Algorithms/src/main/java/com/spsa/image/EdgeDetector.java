/**
 *
 */
package com.spsa.image;

import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;

/**
 * @author sarumu1
 *
 */
public class EdgeDetector {
	public void processImage() {
		try {
			File inputFile = new File("src/main/resources/image/shrek.jpg");
			File processedImageFile = new File("src/main/resources/image/shrek-out.jpg");
			System.out.println("f.getAbsoluteFile():" + inputFile.getAbsoluteFile());

			//Source Image into Array For processing
			final BufferedImage srcBufImg = readAsBufferedImage("src/main/resources/image/shrek.jpg"); //ImageIO.read(inputFile);
			System.out.println("bufferedImage.getColorModel():" + srcBufImg.getColorModel());
			int[] srcImgPixels = new int[srcBufImg.getWidth() * srcBufImg.getHeight()];
			srcBufImg.getRGB(0, 0, srcBufImg.getWidth(), srcBufImg.getHeight(), srcImgPixels, 0, srcBufImg.getWidth());

			// Destination Image Config
			int[] dst = new int[srcImgPixels.length];
			BufferedImage dstImage = srcBufImg.getSubimage(0, 0, srcBufImg.getWidth(), srcBufImg.getHeight());

			// Process Image Array
			long startTs = System.currentTimeMillis();
			dstImage = processImage(srcBufImg, srcImgPixels, dst);
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

	public BufferedImage readAsBufferedImage(String filename) {
		try {
			FileInputStream fis = new FileInputStream(filename);
			JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(fis);
			BufferedImage bi = decoder.decodeAsBufferedImage();
			return bi;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public BufferedImage processImage(BufferedImage srcBufImg, int[] srcImg, int[] destImg) {
		ConvolveOp sobelOp = getSobelVertOp();
		BufferedImage destImage = createEdgeImage(srcBufImg, sobelOp);

		return destImage;
	}

	public BufferedImage createEdgeImage(BufferedImage srcImage, BufferedImageOp op) {
		BufferedImage destImage = op.createCompatibleDestImage(srcImage, srcImage.getColorModel());
		destImage = op.filter(srcImage, destImage);
		return destImage;
	}

	public ConvolveOp getSobelVertOp() {
		float sbvMatrix[] = { -1.0f, -2.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f };
		Kernel kernel = new Kernel(3, 3, sbvMatrix);
		return getConvolveOp(kernel);
	}

	public ConvolveOp getSobelHorizOp() {
		float sbhMatrix[] = { 1.0f, -0.0f, -1.0f, 2.0f, 0.0f, -2.0f, 1.0f, 0.0f, -1.0f };
		Kernel kernel = new Kernel(3, 3, sbhMatrix);
		return getConvolveOp(kernel);
	}

	public ConvolveOp getConvolveOp(Kernel kernel) {

		RenderingHints hints = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		ConvolveOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, hints);
		return op;
	}

	public static void main(String[] args) {
		EdgeDetector reader = new EdgeDetector();
		reader.processImage();

	}
}
