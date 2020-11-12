package com.mashibin.test;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class ImageTest {

	@Test
	public void test() throws IOException {
		//fail("Not yet implemented");
		
		BufferedImage image = ImageIO.read(new File("C:/Users/xianming/git/Tank/Tank/src/img/tankU.gif"));
		
		
		assertNotNull(image);
	}

}
