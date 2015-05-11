/**
 *
 */
package com.spsa.image;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author sarumu1
 *
 */
public class ImageUtilTest {

	ImageUtil util = new ImageUtil(3, 3);

	@Test
	public void testgetSurroundingPixelsIndex() {
		List<Integer> result = util.getSurroundingPixelsIndex(4, 1);
		Assert.assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8]", result.toString());

		result = util.getSurroundingPixelsIndex(0, 1);
		System.out.println("result:" + result);
		Assert.assertEquals("[0, 1, 3, 4]", result.toString());

		result = util.getSurroundingPixelsIndex(1, 1);
		Assert.assertEquals("[0, 1, 2, 3, 4, 5]", result.toString());

		result = util.getSurroundingPixelsIndex(2, 1);
		Assert.assertEquals("[1, 2, 4, 5]", result.toString());

		result = util.getSurroundingPixelsIndex(3, 1);
		Assert.assertEquals("[0, 1, 3, 4, 6, 7]", result.toString());

		result = util.getSurroundingPixelsIndex(8, 1);
		Assert.assertEquals("[4, 5, 7, 8]", result.toString());

		result = util.getSurroundingPixelsIndex(9, 1);
		Assert.assertEquals("[]", result.toString());

		result = util.getSurroundingPixelsIndex(-1, 1);
		Assert.assertEquals("[]", result.toString());

	}

	@Test
	public void testArrayToXY() {
		ImageProperty props = util.arrayToXY(0);
		Assert.assertEquals(1, props.getX());
		Assert.assertEquals(1, props.getY());

		props = util.arrayToXY(1);
		Assert.assertEquals(2, props.getX());
		Assert.assertEquals(1, props.getY());

		props = util.arrayToXY(2);
		Assert.assertEquals(3, props.getX());
		Assert.assertEquals(1, props.getY());

		props = util.arrayToXY(3);
		Assert.assertEquals(1, props.getX());
		Assert.assertEquals(2, props.getY());

		props = util.arrayToXY(4);
		Assert.assertEquals(2, props.getX());
		Assert.assertEquals(2, props.getY());

		props = util.arrayToXY(5);
		Assert.assertEquals(3, props.getX());
		Assert.assertEquals(2, props.getY());

		props = util.arrayToXY(6);
		Assert.assertEquals(1, props.getX());
		Assert.assertEquals(3, props.getY());

		props = util.arrayToXY(7);
		Assert.assertEquals(2, props.getX());
		Assert.assertEquals(3, props.getY());

		props = util.arrayToXY(8);
		Assert.assertEquals(3, props.getX());
		Assert.assertEquals(3, props.getY());
	}

	@Test
	public void testXyToArrayIndex() {
		int arrIndex = util.xyToArrayIndex(1, 1);
		Assert.assertEquals(0, arrIndex);

		arrIndex = util.xyToArrayIndex(2, 1);
		Assert.assertEquals(1, arrIndex);

		arrIndex = util.xyToArrayIndex(3, 1);
		Assert.assertEquals(2, arrIndex);

		arrIndex = util.xyToArrayIndex(1, 2);
		Assert.assertEquals(3, arrIndex);

		arrIndex = util.xyToArrayIndex(2, 2);
		Assert.assertEquals(4, arrIndex);

		arrIndex = util.xyToArrayIndex(3, 2);
		Assert.assertEquals(5, arrIndex);

		arrIndex = util.xyToArrayIndex(1, 3);
		Assert.assertEquals(6, arrIndex);

		arrIndex = util.xyToArrayIndex(2, 3);
		Assert.assertEquals(7, arrIndex);

		arrIndex = util.xyToArrayIndex(3, 3);
		Assert.assertEquals(8, arrIndex);

	}

	@Test
	public void testXyToArrayBoundaryChecks() {
		int arrIndex = util.xyToArrayIndex(0, 0);
		Assert.assertEquals(-1, arrIndex);

		arrIndex = util.xyToArrayIndex(0, 1);
		Assert.assertEquals(-1, arrIndex);

		arrIndex = util.xyToArrayIndex(4, 1);
		Assert.assertEquals(-1, arrIndex);

		arrIndex = util.xyToArrayIndex(1, 4);
		Assert.assertEquals(-1, arrIndex);

		arrIndex = util.xyToArrayIndex(1, 0);
		Assert.assertEquals(-1, arrIndex);
	}

}
