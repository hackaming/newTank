package com.mashibin.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class ResourceManager {
	public static BufferedImage goodTankL,goodTankR,goodTankU,goodTankD,goodTankLD,goodTankLU,goodTankRD,goodTankRU;
	public static BufferedImage badTankL,badTankR,badTankU,badTankD,badTankLD,badTankLU,badTankRD,badTankRU;
	
	public static BufferedImage missileL,missileR,missileU,missileD,missileLD,missileLU,missileRD,missileRU;
	public static List<BufferedImage> explosion = new ArrayList<>();
	
	
	{
		try {
			goodTankU = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			goodTankRU = ImageUtil.rotateImage(goodTankU, 45);//try
			goodTankR = ImageUtil.rotateImage(goodTankU, 90);
			goodTankD = ImageUtil.rotateImage(goodTankR, 90);
			goodTankRD = ImageUtil.rotateImage(goodTankR, 45);
			goodTankL = ImageUtil.rotateImage(goodTankD, 90);
			goodTankLD = ImageUtil.rotateImage(goodTankD, 45);
			goodTankLU = ImageUtil.rotateImage(goodTankL, 45);
			
			
			badTankU = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/badTank1.png"));
			badTankRU = ImageUtil.rotateImage(badTankU, 45);//try
			badTankR = ImageUtil.rotateImage(badTankU, 90);
			badTankD = ImageUtil.rotateImage(badTankR, 90);
			badTankRD = ImageUtil.rotateImage(badTankR, 45);
			badTankL = ImageUtil.rotateImage(badTankD, 90);
			badTankLD = ImageUtil.rotateImage(badTankD, 45);
			badTankLU = ImageUtil.rotateImage(badTankL, 45);
			
			
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
