package com.msds.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class ImageUtils {
	/**
	 * 图片水印
	 * 
	 * @param pressImg
	 *            水印图片
	 * @param targetImg
	 *            目标图片
	 * @param x
	 *            修正值 默认在中间
	 * @param y
	 *            修正值 默认在中间
	 * @param alpha
	 *            透明度
	 */
	public final static void pressImage(String pressImg, String targetImg,
			int x, int y, float alpha) {
		try {
			File img = new File(targetImg);
			Image src = ImageIO.read(img);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);
			// 水印文件
			Image src_biao = ImageIO.read(new File(pressImg));
			int wideth_biao = src_biao.getWidth(null);
			int height_biao = src_biao.getHeight(null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
					alpha));
			g.drawImage(src_biao, (wideth - wideth_biao) / 2,
					(height - height_biao) / 2, wideth_biao, height_biao, null);
			// 水印文件结束
			g.dispose();
			ImageIO.write((BufferedImage) image, "jpg", img);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 文字水印
	 * 
	 * @param pressText
	 *            水印文字
	 * @param targetImg
	 *            目标图片
	 * @param fontName
	 *            字体名称
	 * @param fontStyle
	 *            字体样式
	 * @param color
	 *            字体颜色
	 * @param fontSize
	 *            字体大小
	 * @param x
	 *            修正值
	 * @param y
	 *            修正值
	 * @param alpha
	 *            透明度
	 */
	public static void pressText(String pressText, String targetImg,
			String fontName, int fontStyle, Color color, int fontSize, int x,
			int y, float alpha) {
		try {
			File img = new File(targetImg);
			Image src = ImageIO.read(img);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(src, 0, 0, width, height, null);
			g.setColor(color);
			g.setFont(new Font(fontName, fontStyle, fontSize));
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
					alpha));
			g.drawString(pressText, (width - (getLength(pressText) * fontSize))
					/ 2 + x, (height - fontSize) / 2 + y);
			g.dispose();
			ImageIO.write((BufferedImage) image, "jpg", img);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 缩放
	 * 
	 * @param filePath
	 *            图片路径
	 * @param height
	 *            高度
	 * @param width
	 *            宽度 (小于零则自动计算)
	 * @param bb
	 *            比例不对时是否需要补白
	 */
	public static String resize(String root_path, String filePath, int height,
			int width, boolean bb) {
		String jpgfilePath = "";
		// String pngfilePath = "";
		try {
			double ratio = 0.0; // 缩放比例
			jpgfilePath = filePath.substring(0, filePath.lastIndexOf("."))
					+ "_a.jpg";
			// pngfilePath = filePath.substring(0, filePath.lastIndexOf("."))
			// + "_a.png";
			File f = new File(root_path + filePath);
			File jpgf = new File(root_path + jpgfilePath);
			// File pngf = new File(root_path + pngfilePath);
			BufferedImage bi = ImageIO.read(f);
			if (width <= 0) {
				width = bi.getWidth() * height / bi.getHeight();
			}
			Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);

			// 计算比例
			if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
				if (bi.getHeight() > bi.getWidth()) {
					ratio = (new Integer(height)).doubleValue()
							/ bi.getHeight();
				} else {
					ratio = (new Integer(width)).doubleValue() / bi.getWidth();
				}
				AffineTransformOp op = new AffineTransformOp(
						AffineTransform.getScaleInstance(ratio, ratio), null);
				itemp = op.filter(bi, null);
			}
			if (bb) {
				BufferedImage image = new BufferedImage(width, height,
						BufferedImage.TYPE_USHORT_555_RGB);
				Graphics2D g = image.createGraphics();
				g.setColor(Color.white);
				g.fillRect(0, 0, width, height);
				if (width == itemp.getWidth(null))
					g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				else
					g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				g.dispose();
				itemp = image;
			}

			ImageIO.write((BufferedImage) itemp, "jpg", jpgf);
			// ImageIO.write((BufferedImage) itemp, "png", pngf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jpgfilePath;
	}

	/**
	 * 缩放
	 * 
	 * @param root_path
	 * @param filePath
	 *            图片路径
	 * @param height
	 *            高度
	 * @param width
	 *            宽度 (小于零则自动计算)
	 * @param bb
	 *            比例不对时是否需要补白
	 * @param tail
	 *            文件名附加字段
	 * @param picType
	 *            切后图片类型
	 */
	public static String resize2(String root_path, String filePath, int height,
			int width, boolean bb, String tail, String picType) {
		String picfilePath = "";
		try {
			double ratio = 0.0; // 缩放比例
			picfilePath = filePath.substring(0, filePath.lastIndexOf("."))
					+ tail + "." + picType;
			File f = new File(root_path + filePath);
			File picf = new File(root_path + picfilePath);
			BufferedImage bi = ImageIO.read(f);
			if (width <= 0) {
				width = bi.getWidth() * height / bi.getHeight();
			}
			Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);

			// 计算比例
			if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
				if (bi.getHeight() > bi.getWidth()) {
					ratio = (new Integer(height)).doubleValue()
							/ bi.getHeight();
				} else {
					ratio = (new Integer(width)).doubleValue() / bi.getWidth();
				}
				AffineTransformOp op = new AffineTransformOp(
						AffineTransform.getScaleInstance(ratio, ratio), null);
				itemp = op.filter(bi, null);
			} else {
				if (bi.getHeight() > bi.getWidth()) {
					ratio = (new Integer(height)).doubleValue()
							/ bi.getHeight();
				} else {
					ratio = (new Integer(width)).doubleValue() / bi.getWidth();
				}
				AffineTransformOp op = new AffineTransformOp(
						AffineTransform.getScaleInstance(ratio, ratio), null);
				itemp = op.filter(bi, null);
			}
			if (bb) {
				BufferedImage image = new BufferedImage(width, height,
						BufferedImage.TYPE_USHORT_555_RGB);
				Graphics2D g = image.createGraphics();
				g.setColor(Color.white);
				g.fillRect(0, 0, width, height);
				if (width == itemp.getWidth(null))
					g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				else
					g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				g.dispose();
				itemp = image;
			}
			ImageIO.write((BufferedImage) itemp, picType, picf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return picfilePath;
	}

	/**
	 * 缩放
	 * 
	 * @param filePath
	 *            图片路径
	 * @param height
	 *            高度
	 * @param width
	 *            宽度 (小于零则自动计算)
	 * @param bb
	 *            比例不对时是否需要补白
	 */
	public static String resizeBySize(String root_path, String filePath,
			int height, int width, boolean bb) {
		String jpgfilePath = "";
		String pngfilePath = "";
		try {
			double ratio = 0.0; // 缩放比例
			jpgfilePath = filePath.substring(0, filePath.lastIndexOf("."))
					+ "_" + height + "_" + width + ".jpg";
			pngfilePath = filePath.substring(0, filePath.lastIndexOf("."))
					+ "_" + height + "_" + width + ".png";
			File f = new File(root_path + filePath);
			File jpgf = new File(root_path + jpgfilePath);
			File pngf = new File(root_path + pngfilePath);
			BufferedImage bi = ImageIO.read(f);
			if (width <= 0) {
				width = bi.getWidth() * height / bi.getHeight();
			}
			Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);

			// 计算比例
			if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
				if (bi.getHeight() > bi.getWidth()) {
					ratio = (new Integer(height)).doubleValue()
							/ bi.getHeight();
				} else {
					ratio = (new Integer(width)).doubleValue() / bi.getWidth();
				}
				AffineTransformOp op = new AffineTransformOp(
						AffineTransform.getScaleInstance(ratio, ratio), null);
				itemp = op.filter(bi, null);
			}
			if (bb) {
				BufferedImage image = new BufferedImage(width, height,
						BufferedImage.TYPE_USHORT_555_RGB);
				Graphics2D g = image.createGraphics();
				g.setColor(Color.white);
				g.fillRect(0, 0, width, height);
				if (width == itemp.getWidth(null))
					g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				else
					g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				g.dispose();
				itemp = image;
			}

			ImageIO.write((BufferedImage) itemp, "jpg", jpgf);
			ImageIO.write((BufferedImage) itemp, "png", pngf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pngfilePath;
	}

	public static void main(String[] args) throws IOException {
		// pressImage("G:\\imgtest\\sy.jpg", "G:\\imgtest\\test1.jpg", 0, 0,
		// 0.5f);
		// pressText("我是文字水印", "G:\\imgtest\\test1.jpg", "黑体", 36, Color.white,
		// 80, 0, 0, 0.3f);
		// resize2("D:/png/","aef276420c0c4847882d640ca1432890.png", 125,100,
		// true);
		resize2("D:/png/", "aef276420c0c4847882d640ca1432890.png", 51, 49,
				true, "_b", "png");
	}

	public static int getLength(String text) {
		int length = 0;
		for (int i = 0; i < text.length(); i++) {
			if (new String(text.charAt(i) + "").getBytes().length > 1) {
				length += 2;
			} else {
				length += 1;
			}
		}
		return length / 2;
	}
}
