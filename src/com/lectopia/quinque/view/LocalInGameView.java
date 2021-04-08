package com.lectopia.quinque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.lectopia.quinque.service.GameServiceManager;


public class LocalInGameView extends JPanel { 


	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	
	// ��Ű ���� �̹���
	private JLabel stoneImage;
	
	// �̵� ȿ��
	private JLabel moveEffect;
	
	// player1�� ĳ����(��)���� ����� �迭
	private JButton[] player1Characters;
	
	// player2�� ĳ����(��)���� ����� �迭
	private JButton[] player2Characters;
	
	// ������ �� ������ ĳ���͵��� ����� �迭
	private JButton[] selectCharacter;
	
	// Cursor : �÷��̾ ĳ���� ���ý� ������ ĳ������ ������ ���� ����
	// rollButton : �ֻ��� ������ ��ư
	// actionButton : �׼� ��ư
	// selectButton : ���� ��ư (�ÿ��� �����ֱ� ���� ����)
	private JButton player1Cursor, player2Cursor, rollButton, actionButton, selectButton;
	private JButton actionCharacter;
	
	private JLabel[] mapTiles;
	
	// ��Ű ���� �̹������� ����� �÷��� (�촩��, �ο� �� ������ ��� ���� ������ ���� ������
	private ArrayList<ArrayList<JLabel>> quinqueStones;
	
	// ��Ű ���� �̹����� ��Ÿ�� ��ġ ��ǥ
	private Rectangle stoneRectangle;
	
	// �ֻ�����ư�� �������� üũ�ϴ� �÷���
	private boolean isRoll;
	
	// �ֻ�����ư�� �� �� ������ ���� �������� ������,
	// �� ���� ������ �� ��Ű������ �������� �ϱ� ���� �÷���
	private boolean gageFlag;
	
	// ���� �� ���� ���� ����
	private int turn;

	// �պ��� ���� �߾����� �̵��� ĳ������ ���� ��ġ�� ������ ����
	private Rectangle prevState;
	
	public LocalInGameView() {
		setBounds(0, 0, 1280, 720);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		CharacterButtonHandler characterButtonHandler = new CharacterButtonHandler();
		TileHandler tileHandler = new TileHandler();
		
		stoneRectangle = new Rectangle(990, 49, 170, 150);
		
		mapTiles = new JLabel[25];
		for (int i = 0; i < mapTiles.length; i++) {
			mapTiles[i] = new JLabel();
			mapTiles[i].addMouseListener(tileHandler);
		}
		
		selectCharacter = new JButton[2];
		
		player1Characters = new JButton[4];
		player2Characters = new JButton[4];
		
		player1Cursor = null;
		player2Cursor = null;
		turn = 1;
		isRoll = false;
		gageFlag = false;
		
		selectCharacter[0] = new JButton();
		selectCharacter[1] = new JButton();
		
		selectCharacter[0].setBounds(456, 238, 300, 300);
		selectCharacter[1].setBounds(756, 238, 300, 300);
		
		selectCharacter[0].setVisible(false);
		selectCharacter[1].setVisible(false);
		
		add(selectCharacter[0]);
		add(selectCharacter[1]);
		
		addQuinqueStones();
		
		JLabel chooseTable = new JLabel(new ImageIcon(LocalInGameView.class.getResource("/playUI/chooseTable.png")));
		chooseTable.setBounds(400, 238, 500, 300);
		chooseTable.setVisible(false);
	
		JLabel rockEffect = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/rockEffect.gif")));
		rockEffect.setVisible(false);
		add(rockEffect);
		
		JLabel scissorsEffect = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/scissorsEffect.gif")));
		scissorsEffect.setVisible(false);
		add(scissorsEffect);
	
		JLabel paperEffect = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/paperEffect.gif")));
		paperEffect.setVisible(false);
		add(paperEffect);
	
		for (int i = 0; i < player1Characters.length; i++) {
			player1Characters[i] = new JButton();
			player1Characters[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			player1Characters[i].setFocusPainted(false);
			player1Characters[i].setContentAreaFilled(false);
			player1Characters[i].setBorderPainted(false);
			add(player1Characters[i]);
			player1Characters[i].addActionListener(characterButtonHandler);
			
			player2Characters[i] = new JButton();
			player2Characters[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			player2Characters[i].setFocusPainted(false);
			player2Characters[i].setContentAreaFilled(false);
			player2Characters[i].setBorderPainted(false);
//			player2Characters[i].setEnabled(false);
			add(player2Characters[i]);
			player2Characters[i].addActionListener(characterButtonHandler);
		}
			
		JLabel turtleRockAction = new JLabel(new ImageIcon(LocalInGameView.class.getResource("/playUI/turtleRockAction.gif")));
//		turtleRockAction.setBounds(rock_turtle.getBounds());
		turtleRockAction.setVisible(false);
	
		JLabel turtleScissorsAction = new JLabel(new ImageIcon(LocalInGameView.class.getResource("/playUI/turtleScissorsAction.gif")));
//	    turtleScissorsAction.setBounds(scissors_turtle.getBounds());
	    turtleScissorsAction.setVisible(false);
	    
	    JLabel turtlePaperAction = new JLabel(new ImageIcon(LocalInGameView.class.getResource("/playUI/turtlePaperAction.gif")));
//	    turtlePaperAction.setBounds(paper_turtle.getBounds());
	    turtlePaperAction.setVisible(false);
	    
	    add(turtleRockAction);
	    add(turtleScissorsAction);
	    add(turtlePaperAction);
	      
	    JLabel rabbitRockAction = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/rabbitRockAction.gif")));
//	    rabbitRockAction.setBounds(rock.getBounds());
	    rabbitRockAction.setVisible(false);
	      
	    JLabel rabbitScissorsAction = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/rabbitScissorsAction.gif")));
//	    rabbitScissorsAction.setBounds(scissors.getBounds());
	    rabbitScissorsAction.setVisible(false);
	      
	    JLabel rabbitPaperAction = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/rabbitPaperAction.gif")));
//	    rabbitPaperAction.setBounds(paper.getBounds());
	    rabbitPaperAction.setVisible(false);
	    
	    add(rabbitRockAction);
	    add(rabbitScissorsAction);
	    add(rabbitPaperAction);
	    
	    JPanel panel_2 = new JPanel();
	    panel_2.setBackground(new Color(255, 255, 255));
	    panel_2.setOpaque(false);
	    panel_2.setBorder(new LineBorder(new Color(153, 204, 255), 3));
	    panel_2.setBounds(0, 0, 184, 116);
	    add(panel_2);
	    panel_2.setLayout(null);
	      
	    JLabel name2 = new JLabel("1 vs 1 \uB300\uC804");
	    name2.setOpaque(true);
	    name2.setBorder(new LineBorder(new Color(153, 204, 255), 3));
	    name2.setHorizontalAlignment(SwingConstants.CENTER);
	    name2.setForeground(Color.BLACK);
	    name2.setFont(new Font("Maplestory", Font.PLAIN, 24));
	    name2.setBackground(new Color(153, 204, 255));
	    name2.setBounds(0, 71, 184, 45);
	    panel_2.add(name2);
	      
	    JButton option2 = new JButton("");
	    option2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    option2.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/option2.png")));
	    option2.setFocusPainted(false);
	    option2.setContentAreaFilled(false);
	    option2.setBorderPainted(false);
	    option2.setBounds(97, 0, 73, 73);
	    panel_2.add(option2);
	      
	    JButton bubble2 = new JButton("");
	    bubble2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    bubble2.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/return.png")));
	    bubble2.setFocusPainted(false);
	    bubble2.setContentAreaFilled(false);
	    bubble2.setBorderPainted(false);
	    bubble2.setBounds(12, 0, 73, 73);
	    panel_2.add(bubble2);
	    
	    // ���� �κ�� �̵� (�ڷ� ����)
	    bubble2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				
				// �������� �ʱ�ȭ
				if (stoneImage != null)
					stoneImage.setVisible(false);
				rollButton.setVisible(true);
				player1Cursor = null;
				player2Cursor = null;
				turn = 1;
				isRoll = false;
				
				for (JButton player : player1Characters)
					player.setEnabled(true);
				
				for (JButton player : player2Characters)
					player.setEnabled(false);
				
				ChangePanelService.getInstance().changePanel("LocalRobbyView");
			}
	    	
	    });
	      
	    moveEffect = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/moveEffect.gif")));
	    moveEffect.setVisible(false);
	    add(moveEffect);
	    
	    JLabel gage = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/gage.gif")));
	    gage.setBounds(980, 454, 300, 112);
	    gage.setVisible(false);
	    add(gage);
	    
	    rollButton = new JButton("");
	    rollButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    rollButton.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/ROLL.png")));
	    rollButton.setBounds(1060, 504, 145, 112);
	    rollButton.setContentAreaFilled(false);
	    rollButton.setFocusPainted(false);
	    rollButton.setBorderPainted(false);
	    add(rollButton);
	    
	    actionButton = new JButton("");
	    actionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    actionButton.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/attack.png")));
	    actionButton.setBounds(1000, 424, 100, 100);
	    actionButton.setContentAreaFilled(false);
	    actionButton.setFocusPainted(false);
	    actionButton.setBorderPainted(false);
	    add(actionButton);
	    
	    selectButton = new JButton("");
	    selectButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    selectButton.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/selectButton.png")));
	    selectButton.setBounds(950, 424, 100, 100);
	    selectButton.setContentAreaFilled(false);
	    selectButton.setFocusPainted(false);
	    selectButton.setBorderPainted(false);
	    selectButton.setVisible(false);
	    add(selectButton);
	      
	    add(chooseTable);
	      
	    // �պ��� ĳ���� ����
	    selectButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if (!chooseTable.isVisible()) {
	    			if (actionCharacter != null) {
		    			chooseTable.setVisible(true);
			    		selectCharacter[0] = actionCharacter;
			    		prevState = actionCharacter.getBounds();
			    		selectCharacter[0].setBounds(430, 238, 300, 300);
			    		selectCharacter[0].setVisible(true);
			    		selectCharacter[0].setEnabled(true);
	    			}
	    		}
	    		else {
	    			chooseTable.setVisible(false);
	    			selectCharacter[0].setVisible(false);
	    			selectCharacter[0].setBounds(prevState);
	    			selectCharacter[0].setVisible(true);
	    			selectCharacter[0].setEnabled(false);
	    		}
	    	}
	      });

	    // ������ �׼� ����Ʈ�� ����
	    actionButton.addActionListener(new ActionListener() {
	    	// � ĳ�������� ã�� ���� index
	    	// Thread ������ ����ϱ� ���ؼ� �ʵ�� ��
	    	private int i;
	      	@Override
	  		public void actionPerformed(ActionEvent e) {
	      		JButton[] characters = null;
	      		
	      		actionCharacter.setEnabled(true);
	      		
	      		// ���� ������ ���� ĳ���� �̵��� ������ ���� ��뿡�� �Ѿ�Ƿ�,
	      		// �̵� �� ���� ���� ���� ĳ������ �׼��� �̷������ �ϵ��� �� ������ �������� ����
	      		switch(turn) {
	      		case 2: 
	      			characters = player1Characters;
	      			break;
	      		case 1:
	      			characters = player2Characters;
	      			break;
	      		}
	      	
	      		for (i = 0; i < characters.length; i++) {
	      			if (actionCharacter == characters[i]) break;
	      		} 
	      		
	      		// �����带 ���� �׼� �̹����� ȭ�鿡 ���� �ð����� �����־��ٰ� �ٽ� �������� �ʰ� ��
	      		Thread action = new Thread() {
	  				public void run() {
	  					switch(turn) {
	  						case 2:
		  	    			switch(i) {
		  			    		case 1 : 
		  			    			player1Characters[0].setVisible(false);
		  			    			rabbitRockAction.setBounds(player1Characters[0].getX() - 150, player1Characters[0].getY() - 150, player1Characters[0].getWidth() + 300, player1Characters[0].getHeight() + 300);
		  			    			rabbitRockAction.setVisible(true);
		  			    			break;
		  			    		case 2 :
		  			    			player1Characters[1].setVisible(false);
		  			    			rabbitScissorsAction.setBounds(player1Characters[1].getX() - 150, player1Characters[1].getY() - 150, player1Characters[1].getWidth() + 300, player1Characters[1].getHeight() + 300);
		  			    			rabbitScissorsAction.setVisible(true);
		  			    			break;
		  			    		case 3 :
		  			    			player1Characters[2].setVisible(false);
		  			    			rabbitPaperAction.setBounds(player1Characters[2].getX() - 150, player1Characters[2].getY() - 150, player1Characters[2].getWidth() + 300, player1Characters[2].getHeight() + 300);
		  			    			rabbitPaperAction.setVisible(true);
		  			    			break;
		  	    			}
		  	    			break;
		  	    			
	  						case 1:
	  							switch(i) {
		  			    		case 1 : 
		  			    			player2Characters[0].setVisible(false);
		  			    			turtleRockAction.setBounds(player2Characters[0].getX() - 150, player2Characters[0].getY() - 150, player2Characters[0].getWidth() + 300, player2Characters[0].getHeight() + 300);
		  			    			turtleRockAction.setVisible(true);
		  			    			break;
		  			    		case 2 :
		  			    			player2Characters[1].setVisible(false);
		  			    			turtleScissorsAction.setBounds(player2Characters[1].getX() - 150, player2Characters[1].getY() - 150, player2Characters[1].getWidth() + 300, player2Characters[1].getHeight() + 300);
		  			    			turtleScissorsAction.setVisible(true);
		  			    			break;
		  			    		case 3 :
		  			    			player2Characters[2].setVisible(false);
		  			    			turtlePaperAction.setBounds(player2Characters[2].getX() - 150, player2Characters[2].getY() - 150, player2Characters[2].getWidth() + 300, player2Characters[2].getHeight() + 300);
		  			    			turtlePaperAction.setVisible(true);
		  			    			break;
		  					}
		  	    			break;
	  					}
	  					
	  	    			
	  	    			try {
	  						sleep(1000);
	  					} catch (InterruptedException e) {
	  						e.printStackTrace();
	  					}
	  	    			
	  	    			switch(turn) {
		  	    			case 2:
			  	    			switch(i) {
			  		    		case 1 : 
			  		    			player1Characters[0].setVisible(true);
			  		    			rabbitRockAction.setVisible(false);
			  		    			rockEffect.setBounds(rabbitRockAction.getX() + 50, rabbitRockAction.getY(), rabbitRockAction.getWidth(), rabbitRockAction.getHeight());
					    			rockEffect.setVisible(true);
			  		    			break;
			  		    		case 2 :
			  		    			player1Characters[1].setVisible(true);
			  		    			rabbitScissorsAction.setVisible(false);
			  		    			scissorsEffect.setBounds(rabbitScissorsAction.getX() + 50, rabbitScissorsAction.getY(), rabbitScissorsAction.getWidth(), rabbitScissorsAction.getHeight());
					    			scissorsEffect.setVisible(true);
			  		    			break;
			  		    		case 3 :
			  		    			player1Characters[2].setVisible(true);
			  		    			rabbitPaperAction.setVisible(false);
			  		    			paperEffect.setBounds(rabbitPaperAction.getX() + 50, rabbitPaperAction.getY(), rabbitPaperAction.getWidth(), rabbitPaperAction.getHeight());
					    			paperEffect.setVisible(true);
			  			    		break;
			  					}
			  	    			break;
		  	    			case 1:
		  	    				switch(i) {
		  	    				case 1 : 
		  	    					player2Characters[0].setVisible(true);
			  		    			turtleRockAction.setVisible(false);
			  		    			rockEffect.setBounds(turtleRockAction.getX() + 50, turtleRockAction.getY(), turtleRockAction.getWidth(), turtleRockAction.getHeight());
					    			rockEffect.setVisible(true);
			  		    			break;
			  		    		case 2 :
			  		    			player2Characters[1].setVisible(true);
			  		    			turtleScissorsAction.setVisible(false);
			  		    			scissorsEffect.setBounds(turtleScissorsAction.getX() + 50, turtleScissorsAction.getY(), turtleScissorsAction.getWidth(), turtleScissorsAction.getHeight());
					    			scissorsEffect.setVisible(true);
			  		    			break;
			  		    		case 3 :
			  		    			player2Characters[2].setVisible(true);
			  		    			turtlePaperAction.setVisible(false);
			  		    			paperEffect.setBounds(turtlePaperAction.getX() + 50, turtlePaperAction.getY(), turtlePaperAction.getWidth(), turtlePaperAction.getHeight());
					    			paperEffect.setVisible(true);
			  			    		break;
		  	    				}
		  	    			break;
		  	    			}
	  	    			
	  	    			try {
		    				sleep(500);
		    			} catch (InterruptedException e) {
		    				e.printStackTrace();
		    			}
		    			
		    			switch(i) {
			    		case 1 : 
			    			rockEffect.setVisible(false);
			    			break;
			    		case 2 :
			    			scissorsEffect.setVisible(false);
			    			break;
			    		case 3 :
			    			paperEffect.setVisible(false);
				    		break;
					}
	  	    			
	  				}
	      		};
	      		action.start();
	      		actionButton.setVisible(false);
	      		actionCharacter.setEnabled(false);
	      		actionCharacter = null;
	  		}
	        });
	      
	    JLabel plate = new JLabel("");
	    plate.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/plate.png")));
	    plate.setBounds(879, -35, 599, 359);
	      
	    JLabel stoneRollAction = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/stoneRollAction.gif")));
	    stoneRollAction.setBounds(plate.getX() - 90, plate.getY() - 80, plate.getWidth(), plate.getHeight());
	    stoneRollAction.setVisible(false);
	      
	    add(stoneRollAction);
	    add(plate);
	     
	    // �ֻ��� ������
	    rollButton.addActionListener(new ActionListener() {
	  	  	public void actionPerformed(ActionEvent e) {
	  	  		// ó�� ������ ���� �������� ����
	  	  		if (gageFlag) {
	  	  			// ���� ������ ��
		  	  		if (!isRoll) {
		  	  			gage.setVisible(false);
		  	  			
		  	  			int key = (int) (Math.random() * 6);
		  	  			
		   				new Thread() {
		   					public void run() {
		   						stoneRollAction.setVisible(true);
		   						try {
									sleep(750);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
		   						stoneRollAction.setVisible(false);
		   						Collections.shuffle(quinqueStones.get(key));
		   						stoneImage = quinqueStones.get(key).get(0);
		   						stoneImage.setVisible(true);
		   					}
		   				}.start();
		   				isRoll = true;
		    			((JButton) (e.getSource())).setVisible(false); 
		    	  	}
		  	  		gageFlag = false;
		    	}
	  	  		else {
	  	  			gage.setVisible(true);
	  	  			gageFlag = true;
	  	  		}
	  	  	}
	    });
	    
	    for (int i = 0; i < mapTiles.length; i++) {
	    	add(mapTiles[i]);
	    }
	    
	    JLabel windmill = new JLabel("");
	    windmill.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/home.png")));
	    windmill.setBounds(-25, 374, 239, 345);
	    add(windmill);
	      
	    JLabel black1 = new JLabel("");
	    black1.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackstone.png")));
	    black1.setBounds(379, 575, 122, 116);
	    add(black1);
	      
	    JLabel black2 = new JLabel("");
	    black2.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackstone.png")));
	    black2.setBounds(294, 521, 122, 116);
	    add(black2);
	      
	    JLabel black3 = new JLabel("");
	    black3.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackstone.png")));
	    black3.setBounds(218, 475, 122, 116);
	    add(black3);
	      
	    JLabel black4 = new JLabel("");
	    black4.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackstone.png")));
	    black4.setBounds(137, 411, 122, 116);
	    add(black4);
	      
	    JLabel black5 = new JLabel("");
	    black5.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/blackstone.png")));
	    black5.setBounds(181, 245, 122, 116);
	    add(black5);
	
	    JLabel black6 = new JLabel("");
	    black6.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/blackstone.png")));
	    black6.setBounds(270, 194, 122, 116);
	    add(black6);
	      
	    JLabel black7 = new JLabel("");
	    black7.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/blackstone.png")));
	    black7.setBounds(352, 143, 122, 116);
	    add(black7);
	      
	    JLabel black8 = new JLabel("");
	    black8.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/blackstone.png")));
	    black8.setBounds(426, 93, 122, 116);
	    add(black8);
	    
	    JLabel background = new JLabel("");
	    background.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/background.png")));
	    background.setBounds(0, 0, 1264, 681);
	    add(background);
	    
	    black1.addMouseListener(tileHandler);
	    black2.addMouseListener(tileHandler);
	    black3.addMouseListener(tileHandler);
	    black4.addMouseListener(tileHandler);
	    black5.addMouseListener(tileHandler);
		black6.addMouseListener(tileHandler);
		black7.addMouseListener(tileHandler);
		black8.addMouseListener(tileHandler);
		
		this.setFocusable(true);
		this.addKeyListener(new KeyHandler());
	}
	
	// ��Ű ���� �̹����� �÷��ǿ� �����ϴ� �޼���
	private void addQuinqueStones() {
		JLabel backUnus01 = new JLabel("");
		backUnus01.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/backUnus01.png")));
		backUnus01.setBounds(stoneRectangle);
		
		JLabel backUnus02 = new JLabel("");
		backUnus02.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/backUnus02.png")));
		backUnus02.setBounds(stoneRectangle);
		
		JLabel backUnus03 = new JLabel("");
		backUnus03.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/backUnus03.png")));
		backUnus03.setBounds(stoneRectangle);
		
		JLabel unus01 = new JLabel("");
		unus01.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/unus01.png")));
		unus01.setBounds(stoneRectangle);
		
		JLabel unus02 = new JLabel("");
		unus02.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/unus02.png")));
		unus02.setBounds(stoneRectangle);
		
		JLabel unus03 = new JLabel("");
		unus03.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/unus03.png")));
		unus03.setBounds(stoneRectangle);
		
		JLabel duo01 = new JLabel("");
		duo01.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/duo01.png")));
		duo01.setBounds(stoneRectangle);
		
		JLabel duo02 = new JLabel("");
		duo02.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/duo02.png")));
		duo02.setBounds(stoneRectangle);
		
		JLabel duo03 = new JLabel("");
		duo03.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/duo03.png")));
		duo03.setBounds(stoneRectangle);
		
		JLabel tres01 = new JLabel("");
		tres01.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/tres01.png")));
		tres01.setBounds(stoneRectangle);
		
		JLabel tres02 = new JLabel("");
		tres02.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/tres02.png")));
		tres02.setBounds(stoneRectangle);
		
		JLabel tres03 = new JLabel("");
		tres03.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/tres03.png")));
		tres03.setBounds(stoneRectangle);
		
		JLabel tres04 = new JLabel("");
		tres04.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/tres04.png")));
		tres04.setBounds(stoneRectangle);
		
		JLabel quattuor01 = new JLabel("");
		quattuor01.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/quattuor01.png")));
		quattuor01.setBounds(stoneRectangle);
		
		JLabel quattuor02 = new JLabel("");
		quattuor02.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/quattuor02.png")));
		quattuor02.setBounds(stoneRectangle);
		
		JLabel quattuor03 = new JLabel("");
		quattuor03.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/quattuor03.png")));
		quattuor03.setBounds(stoneRectangle);
		
		JLabel quinque01 = new JLabel("");
		quinque01.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/quinque01.png")));
		quinque01.setBounds(stoneRectangle);
		
		JLabel quinque02 = new JLabel("");
		quinque02.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/quinque02.png")));
		quinque02.setBounds(stoneRectangle);
		
		ArrayList<JLabel> backUnus = new ArrayList<JLabel>();
		
		backUnus.add(backUnus01);
		backUnus.add(backUnus02);
		backUnus.add(backUnus03);
		
		ArrayList<JLabel> unus = new ArrayList<JLabel>();
		
		unus.add(unus01);
		unus.add(unus02);
		unus.add(unus03);
		
		ArrayList<JLabel> duo = new ArrayList<JLabel>();
		
		duo.add(duo01);
		duo.add(duo02);
		duo.add(duo03);
		
		ArrayList<JLabel> tres = new ArrayList<JLabel>();
		
		tres.add(tres01);
		tres.add(tres02);
		tres.add(tres03);
		tres.add(tres04);
		
		ArrayList<JLabel> quattuor = new ArrayList<JLabel>();
		
		quattuor.add(quattuor01);
		quattuor.add(quattuor02);
		quattuor.add(quattuor03);
		
		ArrayList<JLabel> quinque = new ArrayList<JLabel>();
		
		quinque.add(quinque01);
		quinque.add(quinque02);

		quinqueStones = new ArrayList<ArrayList<JLabel>>();
		
		quinqueStones.add(backUnus);
		quinqueStones.add(unus);
		quinqueStones.add(duo);
		quinqueStones.add(tres);
		quinqueStones.add(quattuor);
		quinqueStones.add(quinque);
		
		for (ArrayList<JLabel> stones : quinqueStones) {
			for (JLabel stone : stones) {
				stone.setVisible(false);
				add(stone);
			}
		}

	}
	
	// �̵� ����Ʈ ���� �� ĳ���� ����
	private class CharacterButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			switch (turn) {
				case 1:
					if (((JButton) (e.getSource())).isVisible() && player1Cursor == null && isRoll) {
						moveEffect.setBounds(((JButton) (e.getSource())).getBounds());
						Thread moveThread = new Thread() {
							public void run() {
								moveEffect.setVisible(true);
								try {
									sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								moveEffect.setVisible(false);
							}
						};
						moveThread.start();
						
						Thread moveCharacter = new Thread() {
							public void run() {
								((JButton) (e.getSource())).setVisible(false);
								try {
									sleep(500);
								} catch(InterruptedException e) {
									e.printStackTrace();
								}
							}
							
						};
						moveCharacter.start();
						player1Cursor = (JButton) (e.getSource());
						actionCharacter = player1Cursor;
						actionButton.setVisible(true);
						selectButton.setVisible(true);
					}
					else if (((JButton) (e.getSource())) != player1Cursor && isRoll) {
						player1Cursor.setVisible(true);
						((JButton) (e.getSource())).setVisible(false);
						player1Cursor = ((JButton) (e.getSource()));
						actionButton.setVisible(true);
						selectButton.setVisible(true);
						actionCharacter = player1Cursor;
					}
					else {
						((JButton) (e.getSource())).setVisible(true);
					}
					break;
				case 2:
					if (((JButton) (e.getSource())).isVisible() && player2Cursor == null && isRoll) {
						moveEffect.setBounds(((JButton) (e.getSource())).getBounds());
						Thread moveThread = new Thread() {
							public void run() {
								moveEffect.setVisible(true);
								try {
									sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								moveEffect.setVisible(false);
							}
						};
						moveThread.start();
						
						Thread moveCharacter = new Thread() {
							public void run() {
								((JButton) (e.getSource())).setVisible(false);
								try {
									sleep(500);
								} catch(InterruptedException e) {
									e.printStackTrace();
								}
							}
							
						};
						moveCharacter.start();
						player2Cursor = (JButton) (e.getSource());
						actionButton.setVisible(true);
						selectButton.setVisible(true);
						actionCharacter = player2Cursor;
					}
					else if (((JButton) (e.getSource())) != player2Cursor && isRoll) {
						player2Cursor.setVisible(true);
						((JButton) (e.getSource())).setVisible(false);
						player2Cursor = ((JButton) (e.getSource()));
						actionButton.setVisible(true);
						selectButton.setVisible(true);
						actionCharacter = player2Cursor;
					}
					else {
						((JButton) (e.getSource())).setVisible(true);
					}
					break;
				default:;
			}	
		}
	}
	
	// Ÿ�ϵ鿡 �޸��� ������
	// ĳ���� ���� �� Ÿ�� ���ý� �̵� ����Ʈ ���� �� ĳ���͹�ư�� �̵��Ѵ�.
	private class TileHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			switch(turn) {
				case 1:
					if (player1Cursor != null) {
						System.out.println("[Click]");
						if (player1Cursor.isVisible()) {
							player1Cursor = null;
						}
					
						else {
							player1Cursor.setBounds(((JLabel) (e.getSource())).getX(), ((JLabel) (e.getSource())).getY() - 100, player1Cursor.getWidth(), player1Cursor.getHeight());
							moveEffect.setBounds(player1Cursor.getBounds());
							Thread moveThread = new Thread() {
								public void run() {
									moveEffect.setVisible(true);
									try {
										sleep(500);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									moveEffect.setVisible(false);
								}
							};
							moveThread.start();
							
							Thread moveCharacter = new Thread() {
								public void run() {
									try {
										sleep(500);
									} catch(InterruptedException e) {
										e.printStackTrace();
									}
									player1Cursor.setVisible(true);	
									player1Cursor = null;
								}
								
							};
							moveCharacter.start();	
							stoneImage.setVisible(false);
							isRoll = false;
							rollButton.setVisible(true);
							turn = 2;
							
							for (int i = 0; i < player1Characters.length; i++) {
								player1Characters[i].setEnabled(false);
							}
							for (int i = 0; i < player2Characters.length; i++) {
								player2Characters[i].setEnabled(true);
							}
							
						}
					}
					break;
				case 2:	
					if (player2Cursor != null) {
						System.out.println("[Click]");
						if (player2Cursor.isVisible()) {
							player2Cursor = null;
						}
						else {
							player2Cursor.setBounds(((JLabel) (e.getSource())).getX(), ((JLabel) (e.getSource())).getY() - 100, player2Cursor.getWidth(), player2Cursor.getHeight());
							moveEffect.setBounds(player2Cursor.getBounds());
							Thread moveThread = new Thread() {
								public void run() {
									moveEffect.setVisible(true);
									try {
										sleep(500);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									moveEffect.setVisible(false);
								}
							};
							moveThread.start();
							
							Thread moveCharacter = new Thread() {
								public void run() {
									try {
										sleep(500);
									} catch(InterruptedException e) {
										e.printStackTrace();
									}
									player2Cursor.setVisible(true);	
									player2Cursor = null;
								}
								
							};
							moveCharacter.start();	
							stoneImage.setVisible(false);
							isRoll = false;
							rollButton.setVisible(true);
							turn = 1;
							
							for (int i = 0; i < player1Characters.length; i++) {
								player1Characters[i].setEnabled(true);
							}
							for (int i = 0; i < player2Characters.length; i++) {
								player2Characters[i].setEnabled(false);
							}
						}
					}
					break;
				default:; 
			}
		
		}
	}
	
	// ĳ���� ���� �� ��������
	private class KeyHandler extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			char key = e.getKeyChar();
			switch(key) {
			case 'q': 
			case 'w':
			case 'e':
			case 'r':
			case 'o':
			case 'p':
			case '[':
			case ']': System.out.println(key);
			default: ;
			}
		}
	}
	
	public void initiateGame() {
//		int cnt = GameServiceManager.getInstance().getPlayerNum();
		
		ArrayList<ArrayList<Object>> markersResource = GameServiceManager.getInstance().getMarkerResource();
		
		for (int i = 0; i < 4; i++) {
			ArrayList<Object> markerResource = markersResource.get(i);
			player1Characters[i].setActionCommand((String) markerResource.get(0));
			player1Characters[i].setIcon(new ImageIcon(LocalInGameView.class.getResource((String) markerResource.get(1))));
			player1Characters[i].setBounds((Rectangle) markerResource.get(2));
		}
		for (int i = 0; i < 4; i++) {
			ArrayList<Object> markerResource = markersResource.get(i + 4);
			player2Characters[i].setActionCommand((String) markerResource.get(0));
			player2Characters[i].setIcon(new ImageIcon(LocalInGameView.class.getResource((String) markerResource.get(1))));
			player2Characters[i].setBounds((Rectangle) markerResource.get(2));
		}
	
		ArrayList<ArrayList<Object>> mapsResource = GameServiceManager.getInstance().getMapResource();
		int mapsResourceSize = mapsResource.size();
		for (int i = 0; i < mapsResourceSize; i++) {
			ArrayList<Object> mapResource = GameServiceManager.getInstance().getMapResource().get(i);
			mapTiles[i].setName("" + (int) mapResource.get(0));
			mapTiles[i].setIcon(new ImageIcon(LocalInGameView.class.getResource((String) mapResource.get(1))));
			mapTiles[i].setBounds((Rectangle) mapResource.get(2));
		}
	}
	
}