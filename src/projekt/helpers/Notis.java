/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.helpers;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

/**
 *
 * @author Josef
 */
public class Notis
{
	SystemTray tray = SystemTray.getSystemTray();
	public static void main(String[] args) throws AWTException
	{
		if (SystemTray.isSupported()) {
			Notis td = new Notis();
			td.displayTray();
			td.visaNotis("Cool title","Cheeseknife");
		} else {
			System.err.println("System tray not supported!");
		}
	}

	public void visaNotis(String title, String meddelande) throws AWTException
	{
		
		Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
		TrayIcon trayIcon = new TrayIcon(image, "Grupp 1");
//		trayIcon.setImageAutoSize(true);
		trayIcon.setToolTip("Inlägg");
		tray.add(trayIcon);
		trayIcon.displayMessage(title, meddelande, MessageType.NONE);
		
		
	}

	public void displayTray() throws AWTException
	{
		//Obtain only one instance of the SystemTray object
		//If the icon is a file
		Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
		//Alternative (if the icon is on the classpath):
		//Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

		TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
		//Let the system resize the image if needed
		trayIcon.setImageAutoSize(true);
		//Set tooltip text for the tray icon
		trayIcon.setToolTip("System tray icon demo");
		tray.add(trayIcon);

		trayIcon.displayMessage("Hello, World", "notification demo", MessageType.INFO);
	}
}
