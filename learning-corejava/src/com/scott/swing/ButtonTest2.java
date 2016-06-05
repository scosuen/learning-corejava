package com.scott.swing;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonTest2 {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

	private Long count = new Long(0l);

	private ExecutorService executorService = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		ButtonTest2 buttonTest = new ButtonTest2();
		buttonTest.showEventDemo();
	}

	public ButtonTest2() {
		prepareGUI();
	}

	private void prepareGUI() {
		mainFrame = new JFrame("Java SWING Examples 2");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 1));
		headerLabel = new JLabel("", JLabel.CENTER);
		headerLabel.setText("Control in action: Button");
		statusLabel = new JLabel("", JLabel.CENTER);
		statusLabel.setSize(350, 100);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);

	}

	private void showEventDemo() {
		JButton countButton = new JButton("+1");

		countButton.addActionListener((ActionEvent e) -> {

			executorService.execute(() -> {
				try {
					Item2 item = new Item2();
					item.setItemId(++count);
					int randomSec = new Random().nextInt(10);
					TimeUnit.SECONDS.sleep(randomSec);
					statusLabel.setText("Item id : " + item.getItemId() + ", randomSec: " + randomSec);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			});

			// new Thread(new CountTask()).start();
		});

		controlPanel.add(countButton);
		mainFrame.setVisible(true);
	}

	class CountTask implements Runnable {
		@Override
		public void run() {
			try {
				int randomSec = new Random().nextInt(10);
				Item2 item = new Item2();
				item.setItemId(++count);
				TimeUnit.SECONDS.sleep(randomSec);
				
				statusLabel.setText("Item id : " + item.getItemId() + ", randomSec: " + randomSec);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}

class Item2 {
	private Long itemId;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
}
