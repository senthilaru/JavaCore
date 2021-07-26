/**
 *
 */
package com.spsa.image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author sarumu1
 *
 */
public class ImageUtil {

	private int imgWidth;
	private int imgHeight;

	/**
	 * @param imgWidth
	 * @param imgHeight
	 */
	public ImageUtil(int imgWidth, int imgHeight) {
		super();
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
	}

	public List<Integer> getSurroundingPixelsIndex(int arrIndex, int surroundDepth) {
		ImageProperty imgProp = arrayToXY(arrIndex);
//		System.out.println("Source:" + imgProp);
		List<Integer> surrPixels = new ArrayList<>();
		if (arrIndex < 0 || arrIndex >= (imgWidth * imgHeight)) {
			return surrPixels;
		}
		xyToArrayIndex(imgProp.getX() - 1, imgProp.getY() - 1, surrPixels);
		xyToArrayIndex(imgProp.getX(), imgProp.getY() - 1, surrPixels);
		xyToArrayIndex(imgProp.getX() + 1, imgProp.getY() - 1, surrPixels);
		xyToArrayIndex(imgProp.getX() - 1, imgProp.getY(), surrPixels);
		xyToArrayIndex(imgProp.getX(), imgProp.getY(), surrPixels);
		xyToArrayIndex(imgProp.getX() + 1, imgProp.getY(), surrPixels);
		xyToArrayIndex(imgProp.getX() - 1, imgProp.getY() + 1, surrPixels);
		xyToArrayIndex(imgProp.getX(), imgProp.getY() + 1, surrPixels);
		xyToArrayIndex(imgProp.getX() + 1, imgProp.getY() + 1, surrPixels);
//		System.out.println("IN surrPixels:" + surrPixels); //surrPixels:[0, 0, 6, 1, 2, 3, 4, 5, 6]

		return surrPixels;
	}

	public List<Integer> getSurroundingPixels(int arrIndex, int[] srcImg, int surroundDepth) {
		List<Integer> surrPixels = new ArrayList<>();
		List<Integer> surrPixelsIndex = getSurroundingPixelsIndex(arrIndex, surroundDepth);
		for (Integer pxIndex : surrPixelsIndex) {
			ImageProperty prop = arrayToXY(pxIndex);
//			System.out.println("Surrounding Pixel Index:"+prop);
			surrPixels.add(srcImg[pxIndex]);
		}
		return surrPixels;
	}

	public ImageProperty arrayToXY(int arrayIndex) {
		int x = (arrayIndex % imgWidth) + 1;
		int y = (arrayIndex / imgHeight) + 1;
//		System.out.println("(" + x + "," + y + ") :" + arrayIndex);
		return new ImageProperty(arrayIndex, x, y);
	}

	public int xyToArrayIndex(int x, int y) {
		if (x < 1 || y < 1 || y > imgHeight || x > imgWidth) {
//			System.out.println("(" + x + "," + y + ") :" + "-1");
			return -1;
		}
		int result = ((y - 1) * imgWidth + x) - 1;
		result = result < 1 ? 0 : result;
//		System.out.println("(" + x + "," + y + ") :" + result);
		return result;
	}

	public void xyToArrayIndex(int x, int y, List<Integer> result) {
		int arrIndex = xyToArrayIndex(x, y);
		if (arrIndex != -1) {
			result.add(arrIndex);
		}
	}

	public int getImgWidth() {
		return imgWidth;
	}

	public void setImgWidth(int imgWidth) {
		this.imgWidth = imgWidth;
	}

	public int getImgHeight() {
		return imgHeight;
	}

	public void setImgHeight(int imgHeight) {
		this.imgHeight = imgHeight;
	}

	public static void main(String[] args) {
		ImageUtil util = new ImageUtil(3, 3);
		util.getSurroundingPixelsIndex(9, 1);
	}

	/**
	 * @param srcImg
	 * @return
	 */
	public int findThreshold(int[] srcImg) {

		Map<Integer, Integer> diffMap = new TreeMap<>();
		for (int pixelIndex = 0; pixelIndex < srcImg.length; pixelIndex++) {
			List<Integer> surroundedPixels = getSurroundingPixels(pixelIndex, srcImg, 8);
			if (surroundedPixels.size() != 0) {
				Collections.sort(surroundedPixels);
				int lowPixel = surroundedPixels.get(0);
				int highPixel = surroundedPixels.get(surroundedPixels.size() - 1);
				int diffPixel = highPixel - lowPixel;
				if (diffMap.get(diffPixel) != null) {
					diffMap.put(diffPixel, diffMap.get(diffPixel) + 1);
				} else {
					diffMap.put(diffPixel, 1);
				}
			}
		}
		ValueComparator comp = new ValueComparator(diffMap);
		TreeMap<Integer, Integer> sorted_map = new TreeMap<>(comp);
		sorted_map.putAll(diffMap);
		System.out.println("sorted_map.values():" + sorted_map);
		int i = 0;
		Integer totalPixel = 0;
		int avg = 0;
		for (Iterator<Integer> iterator = sorted_map.keySet().iterator(); iterator.hasNext() && i < 3; i++) {
			Integer pixel = iterator.next();
			if (pixel != 0) {
				totalPixel += pixel;
				avg++;
			}

		}
		int threshold = totalPixel / avg;
		System.out.println("threshold:" + threshold);
		return threshold;
	}

	private class ValueComparator implements Comparator<Integer> {

		Map<Integer, Integer> base;

		public ValueComparator(Map<Integer, Integer> base) {
			this.base = base;
		}

		// Note: this comparator imposes orderings that are inconsistent with equals.
		@Override
		public int compare(Integer a, Integer b) {
			if (base.get(a) >= base.get(b)) {
				return -1;
			} else {
				return 1;
			} // returning 0 would merge keys
		}
	}
}
