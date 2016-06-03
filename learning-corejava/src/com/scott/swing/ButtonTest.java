package com.scott.swing;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.security.KeyStore.PrivateKeyEntry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonTest {

	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	
	private Long count = new Long(0l);
	private boolean isCancel = false;
	private BlockingQueue<Item> countButtonQueue = new ArrayBlockingQueue<Item>(100);
	
	private Runnable processorThread = () -> {
		while (true) {
			try {
				countButtonTask(countButtonQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	public static void main(String[] args) {
		
		ButtonTest buttonTest = new ButtonTest();
		buttonTest.showEventDemo();
		
		new Thread(buttonTest.processorThread).start();
	}

	public ButtonTest() {
		prepareGUI();
	}

	private void prepareGUI() {
		mainFrame = new JFrame("Java SWING Examples");
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
		JButton cancelButton = new JButton("Cancel");
		
		countButton.addActionListener((ActionEvent e) -> {
			try {
				isCancel = false;
				countButtonQueue.put(new Item());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		cancelButton.addActionListener((ActionEvent e) -> {
			new Thread(() -> {
				isCancel = true;
				countButtonQueue.clear();
				statusLabel.setText("Cancel Button clicked. Stopped at " + count);
			}).start();
		});

		controlPanel.add(countButton);
		controlPanel.add(cancelButton);
		
		mainFrame.setVisible(true);
	}
	
	private void countButtonTask (Item item) {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (!isCancel) {
			item.setItemId(++count);
			statusLabel.setText("Item id : " + item.getItemId());
		}
	}
	
}

class Item  {
	private Long itemId;
	
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
}
