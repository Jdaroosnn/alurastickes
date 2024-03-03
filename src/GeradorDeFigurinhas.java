import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws IOException {
        BufferedImage original = ImageIO.read(inputStream);

        int newHeight = original.getHeight() + 200;
        BufferedImage novaImagem = new BufferedImage(
            original.getWidth(), 
            newHeight, 
            BufferedImage.TRANSLUCENT);

        Graphics2D graphics2d = (Graphics2D) novaImagem.getGraphics();
        graphics2d.drawImage(original, 0, 0, null);

        graphics2d.setColor(Color.YELLOW);
        graphics2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 96));

        graphics2d.drawString("NOTA 2", 100, newHeight);

        ImageIO.write(novaImagem, "jpg", new File(nomeArquivo));
    }

}
