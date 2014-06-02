package com.ph3nx.java.verkehrsampel;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;

public class Verkehrsampel extends Applet {

	private static final long serialVersionUID = 1L;

	private int x,y; // Koordinaten Zeichenobjekte
	private int s;
	private Graphics g;
	
	public void init() {
		setSize(90, 190);
		x = 20;
		y = 20;
		s = 1;
	}
	
	@Override
	public void paint(Graphics _g) {
		g = _g;
		
		while (true) {
			zeichneAmpelkasten();
			
			switch (s) {
			case 1:
				zeichneLicht(Color.RED, y);
				break;
				
			case 2:
				zeichneLicht(Color.YELLOW, y + 50);
				break;
				
			case 3:
				zeichneLicht(Color.GREEN, y + 100);
				break;
			}
			
			try { Thread.sleep(1000);} catch (Exception e) {}
			s++;
			if (s == 4) s = 1;
			
		}
	}
	
	private void zeichneAmpelkasten() {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 50, 150);
	}
	
	private void zeichneLicht(Color c, int yNeu) {
		g.setColor(c);
		g.fillOval(x + 5, yNeu + 5, 40, 40);
	}

}
