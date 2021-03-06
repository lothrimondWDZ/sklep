package logic;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * 
 * Implementacja klasy XmlAdapter dla BufferedImage
 * @see {@link XmlAdapter}, {@link BufferedImage}
 *
 */
public class ImageAdapter extends XmlAdapter<String, BufferedImage>{

	/**
	 * Metoda przekształcająca obrazek z postaci String na BufferedImage
	 * @see {@link String}, {@link BufferedImage} 
	 */
	@Override
	public BufferedImage unmarshal(String imageString) throws Exception {
		BufferedImage bImage = null;
        BASE64Decoder b64dec = new BASE64Decoder();
        try {
            byte[] output = b64dec.decodeBuffer(imageString);
            ByteArrayInputStream bais = new ByteArrayInputStream(output);
            bImage = ImageIO.read(bais);
        } catch (IOException e) {
            System.err.println("Error");
        }

        return bImage;
	}

	/**
	 * Metoda przekształcająca obrazek z postaci BufferedImage na String
	 * @see {@link String}, {@link BufferedImage} 
	 */
	@Override
	public String marshal(BufferedImage image) throws Exception {
		String imageString = null;
        byte[] imageBytes = ((DataBufferByte) image.getData().getDataBuffer()).getData();

		//bytes to string
		BASE64Encoder b64enc = new BASE64Encoder();
		imageString = b64enc.encode(imageBytes);
		return imageString;
	}

}
