package sss.yyao.tieba.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 验证码工具类
 * 生成验证码图片
 * @author yyao
 *
 */
public class ImageUtil {
	private static final char[] chars = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z' };
	private static final int SIZE = 4;
	private static final int LINES = 1;
	private static final int WIDTH = 80;
	private static final int HEIGHT = 25;
	private static final int FONT_SIZE = 15;

	public static Map<String, BufferedImage> createImage() {
		StringBuffer sb = new StringBuffer();
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		Random random = new Random();
		// 随机字符
		for (int i = 1; i <= SIZE; i++) {
			int r = random.nextInt(chars.length);
			graphics.setColor(getRandomColorF());
			graphics.setFont(new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE));
			graphics.drawString(chars[r] + "", (i - 1) * WIDTH / SIZE,
					HEIGHT - 6);
			sb.append(chars[r]);
		}
		// 干扰线
		for (int i = 1; i <= LINES; i++) {
			graphics.setColor(getRandomColorL());
			graphics.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT),
					random.nextInt(WIDTH), random.nextInt(HEIGHT));
		}
		Map<String, BufferedImage> map = new HashMap<String, BufferedImage>();
		map.put(sb.toString(), image);
		return map;
	}

	private static Color getRandomColorF() {
		Random random = new Random();
		Color color = new Color(random.nextInt(128), random.nextInt(128),
				random.nextInt(256));
		return color;
	}

	private static Color getRandomColorL() {
		Random random = new Random();
		Color color = new Color(random.nextInt(256), random.nextInt(256),
				random.nextInt(256));
		return color;
	}

	public static InputStream getInputStream(BufferedImage image)
			throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
		encoder.encode(image);
		byte[] imageBts = bos.toByteArray();
		InputStream in = new ByteArrayInputStream(imageBts);
		return in;
	}
}
