/**
 *
 */
package com.spsa.image;

/**
 * @author sarumu1
 *
 */
public class ImageProperty {
	private int pixelIndex;
	private int x;
	private int y;

	/**
	 * @param pixelIndex
	 * @param x
	 * @param y
	 */
	public ImageProperty(int pixelIndex, int x, int y) {
		super();
		this.pixelIndex = pixelIndex;
		this.x = x;
		this.y = y;
	}

	public int getPixelIndex() {
		return pixelIndex;
	}

	public void setPixelIndex(int pixelIndex) {
		this.pixelIndex = pixelIndex;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pixelIndex;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ImageProperty other = (ImageProperty) obj;
		if (pixelIndex != other.pixelIndex) {
			return false;
		}
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ImageProperty [pixelIndex=");
		builder.append(pixelIndex);
		builder.append(", x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append("]");
		return builder.toString();
	}

}
