package com.lectopia.quinque.view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ParentFrameView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private CardLayout cardLayout;
	
	public ParentFrameView(){
		super();
		
		
		mainPanel = new JPanel();
		cardLayout = new CardLayout();
		mainPanel.setLayout(cardLayout);
		
		mainPanel.add("MainMenuView", new MainMenuView());
		mainPanel.add("LocalRobbyView",new LocalRobbyView());
		mainPanel.add("LoginView",new LoginView(this));
		
		LocalInGameView localInGameView = new LocalInGameView();
		localInGameView.setName("LocalInGameView");
		
		mainPanel.add("LocalInGameView", localInGameView);
		mainPanel.add("MultiRoomView", new MultiRoomView());
		
		MultiInGameView multiInGameView = new MultiInGameView();
		multiInGameView.setName("MultiInGameView");
		
		mainPanel.add("MultiInGameView", new MultiInGameView());
		mainPanel.add("MyPageView", new MyPageView());
		mainPanel.add("TutorialView", new TutorialView());
		mainPanel.add("MultiPlayListView", new MultiPlayListView());
		
		System.out.println(multiInGameView.getName());
		
		ChangePanelService cpService = ChangePanelService.getInstance();
		
		
		cpService.setLayout(cardLayout);
		cpService.setMainPanel(mainPanel);
		
		add(mainPanel);
		
		cpService.changePanel("MainMenuView");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ParentFrameView();
	}
}