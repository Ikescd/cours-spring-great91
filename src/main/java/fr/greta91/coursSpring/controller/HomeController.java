package fr.greta91.coursSpring.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.awt.*;
import java.awt.image.*;

@Controller //composant de type controller de MVC
public class HomeController {
	@ResponseBody
	@GetMapping("/")
//	@RequestMapping(value="/", method= RequestMethod.GET)
	public String home() {
		return "Salut !";
	}

	@GetMapping(value = "/cercle")
	public void cercle(OutputStream out, HttpServletResponse response) throws IOException {
		response.setContentType("image/png");
		int taille = 500;
		int marge = 10;
		int diametre = taille - 2 * marge;
		BufferedImage img = new BufferedImage(taille, taille, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		g.setColor(Color.RED);
		g.fillOval(marge, marge, diametre, diametre);
		g.dispose();
		ImageIO.write(img, "png", out);
	}
}
