package com.mashibin.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class ResourceManager {
	public static BufferedImage goodTankL,goodTankR,goodTankU,goodTankD,goodTankLD,goodTankLU,goodTankRD,goodTankRU;
	public static BufferedImage badTankL,badTankR,badTankU,badTankD,badTankLD,badTankLU,badTankRD,badTankRU;
	
	public static BufferedImage goodTank00L,goodTank00R,goodTank00U,goodTank00D,goodTank00LD,goodTank00LU,goodTank00RD,goodTank00RU;
	public static BufferedImage badTank00L,badTank00R,badTank00U,badTank00D,badTank00LD,badTank00LU,badTank00RD,badTank00RU;
	
	public static BufferedImage missileL,missileR,missileU,missileD,missileLD,missileLU,missileRD,missileRU;
	public static List<BufferedImage> explosion = new ArrayList<>();
	
	
	{
		try {
		//第一张坦 克图片，
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
			
			//第二辆坦 克图片，这样可以闪烁
			goodTank00U = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/GoodTank2.png"));
			goodTank00RU = ImageUtil.rotateImage(goodTank00U, 45);//try
			goodTank00R = ImageUtil.rotateImage(goodTank00U, 90);
			goodTank00D = ImageUtil.rotateImage(goodTank00R, 90);
			goodTank00RD = ImageUtil.rotateImage(goodTank00R, 45);
			goodTank00L = ImageUtil.rotateImage(goodTank00D, 90);
			goodTank00LD = ImageUtil.rotateImage(goodTank00D, 45);
			goodTank00LU = ImageUtil.rotateImage(goodTank00L, 45);
			
			
			badTank00U = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/badTank2.png"));
			badTank00RU = ImageUtil.rotateImage(badTank00U, 45);//try
			badTank00R = ImageUtil.rotateImage(badTank00U, 90);
			badTank00D = ImageUtil.rotateImage(badTank00R, 90);
			badTank00RD = ImageUtil.rotateImage(badTank00R, 45);
			badTank00L = ImageUtil.rotateImage(badTank00D, 90);
			badTank00LD = ImageUtil.rotateImage(badTank00D, 45);
			badTank00LU = ImageUtil.rotateImage(badTank00L, 45);
			
			missileU = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/BulletU.png"));
			missileRU = ImageUtil.rotateImage(missileU, 45);//try
			missileR = ImageUtil.rotateImage(missileU, 90);
			missileD = ImageUtil.rotateImage(missileR, 90);
			missileRD = ImageUtil.rotateImage(missileR, 45);
			missileL = ImageUtil.rotateImage(missileD, 90);
			missileLD = ImageUtil.rotateImage(missileD, 45);
			missileLU = ImageUtil.rotateImage(missileL, 45);
			
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
