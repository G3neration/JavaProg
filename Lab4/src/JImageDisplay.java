import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends JComponent {
	private final BufferedImage bufferedImage;

	public JImageDisplay(int width, int height) {
		bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		super.setPreferredSize(new Dimension(width, height));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
	}

	public void clearImage() {
		for (int x = 0; x < bufferedImage.getWidth(); x++)
			for (int y = 0; y < bufferedImage.getHeight(); y++)
				bufferedImage.setRGB(x, y, 0);

	}

	public void drawPixel(int x, int y, int rgbColor) {
		if (rgbColor == -1)
			return;
		int c = (int) (rgbColor * 0xFFEFFF / 21d);
		bufferedImage.setRGB(x, y, c);
	}
}