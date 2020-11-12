package com.mashibin.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class ResourceManager {
	public static BufferedImage tankL,tankR,tankU,tankD,tankLD,tankLU,tankRD,tankRU;
	public static BufferedImage missileL,missileR,missileU,missileD,missileLD,missileLU,missileRD,missileRU;
	public static List<BufferedImage> explosion = new ArrayList<>();
	
	
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
			
			missileL = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/missileL.gif"));
			missileR = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/missileR.gif"));
			missileU = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/missileU.gif"));
			missileD = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/missileD.gif"));
			missileLD = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/missileLD.gif"));
			missileLU = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/missileLU.gif"));
			missileRD = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/missileRD.gif"));
			missileRU = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/missileRU.gif"));
			
			for (int i=0;i<10;i++){
				System.out.println("images/"+i+".gif");
				explosion.add(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/"+i+".gif")));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
