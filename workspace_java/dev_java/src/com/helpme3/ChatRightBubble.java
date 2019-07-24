package com.helpme3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
/*
 * 오른쪽 말풍선(내가 작성하는)
 */
public class ChatRightBubble extends JPanel{
	   @Override
	   protected void paintComponent(final Graphics g) {
	      this.setAlignmentX(SwingConstants.RIGHT);
		   final Graphics2D g2d = (Graphics2D) g;
	      g2d.setColor(new Color(255,255,51));
	      int bottomLineY = getHeight()-3;
	      int width = getWidth()-12-(3*2);
	      //말풍선 채우기
	      g2d.fillRect(3/2, 3/2, width, bottomLineY);
	      //둥글게 둥글게...
	      RoundRectangle2D.Double rect = 
	       new RoundRectangle2D.Double(3/2,3/2,width,bottomLineY,10,10);
	      Polygon arrow = new Polygon();
	      arrow.addPoint(width, 8);
	      arrow.addPoint(width+12, 10);
	      arrow.addPoint(width, 12);
	      Area area = new Area(rect);
	      area.add(new Area(arrow));
	      g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING
	    		                                , RenderingHints.VALUE_ANTIALIAS_ON));
	      g2d.setStroke(new BasicStroke(3));
	      g2d.draw(area);
	   }
}
