package com.mashibin.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceManager {
	public static BufferedImage tankL,tankR,tankU,tankD,tankLD,tankLU,tankRD,tankRU;
	{
		try {
			tankL = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/tankL.gif"));
			tankR = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/tankR.gif"));
			tankU = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/tankU.gif"));
			tankD = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/tankD.gif"));
			tankLD = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/tankLD.gif"));
			tankLU = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/tankLU.gif"));
			tankRD = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/tankRD.gif"));
			tankRU = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/tankRU.gif"));
			System.out.println("Initialized");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
