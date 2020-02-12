package com.soul.tools;

import javax.swing.*;
import java.awt.*;

public class AddImage {
	
	public static Image getimage(String url) {
		ImageIcon icon = new ImageIcon(AddImage.class.getClassLoader().getResource(url));//"images/enemy.jpg"
	
		return icon.getImage();
	}

}
