package com.lectopia.quinque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LoginView extends JPanel {

   private JPanel contentPane;
   private JTextField login;
   private JPasswordField password;
   private JFrame parentFrame;

   public LoginView() {
   };

   public LoginView(JFrame parentFrame) {
      this.parentFrame = parentFrame;
//      this.setBackground(new Color(244, 228, 223));
      setBackground(new Color(232, 232, 255));
      setBounds(100, 100, 1280, 720);
      // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(null);

      JLabel lblNewLabel_2 = new JLabel("");
      lblNewLabel_2.setIcon(new ImageIcon(LocalRobbyView.class.getResource("/localView/home.png")));
      lblNewLabel_2.setBounds(435, 181, 90, 79);
      add(lblNewLabel_2);
		
      JLabel label2 = new JLabel("�α���");
      label2.setFont(new Font("�����ý��丮", Font.BOLD, 70));
      label2.setBounds(580, 179, 367, 92);
      add(label2);
      
      JPanel panel = new JPanel();
//      panel.setBackground(new Color(244, 228, 223));
      panel.setBackground(new Color(232, 232, 255));
      panel.setBounds(394, 50, 448, 243);
      this.add(panel);
      LoginViewHandler lvh = new LoginViewHandler();

      JLabel lblNewLabel_1 = new JLabel("");
      lblNewLabel_1.setIcon(new ImageIcon("multiui\\three.png"));
      panel.add(lblNewLabel_1);

      JPanel panel_1 = new JPanel();
//      panel_1.setBackground(new Color(244, 228, 223));
      panel_1.setBackground(new Color(232, 232, 255));
      panel_1.setBounds(300, 332, 636, 132);
      this.add(panel_1);
      panel_1.setLayout(null);

      JLabel lblNewLabel = new JLabel("���̵�");// ���̵�
      lblNewLabel.setFont(new Font("�����ý��丮", Font.PLAIN, 24));
      lblNewLabel.setBounds(103, 24, 83, 29);
      panel_1.add(lblNewLabel);

      login = new JTextField();
      login.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      login.setBounds(276, 22, 280, 30);
      panel_1.add(login);
      login.setColumns(10);

      JLabel label = new JLabel("��й�ȣ");// ��й�ȣ
      label.setBounds(91, 76, 130, 29);
      panel_1.add(label);
      label.setFont(new Font("�����ý��丮", Font.PLAIN, 24));

      password = new JPasswordField();
      password.setBounds(276, 76, 280, 30);
      panel_1.add(password);
      password.setColumns(10);

      JButton btnNewButton = new JButton("ȸ������");
      btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      btnNewButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
      btnNewButton.addActionListener(lvh);
      btnNewButton.setBackground(Color.WHITE);
      btnNewButton.setHideActionText(true);
      btnNewButton.setFont(new Font("�����ý��丮", Font.PLAIN, 24));
      btnNewButton.setBounds(538, 509, 170, 50);
      this.add(btnNewButton);

      JButton button = new JButton("�α���");
      button.setBackground(Color.WHITE);
      button.setFont(new Font("�����ý��丮", Font.PLAIN, 24));
      button.addActionListener(lvh);
      button.setBounds(766, 509, 170, 50);
      this.add(button);

      JButton button_1 = new JButton("�ǵ��ư���");// �ǵ��ư���
      button_1.addActionListener(lvh);
      button_1.setHideActionText(true);
      button_1.setFont(new Font("�����ý��丮", Font.PLAIN, 24));
      button_1.setBackground(Color.WHITE);
      button_1.setAlignmentX(1.0f);
      button_1.setBounds(310, 509, 170, 50);
      add(button_1);
   }

   private class LoginViewHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if (e.getActionCommand().equals("�ǵ��ư���")) {
            ChangePanelService.getInstance().changePanel("MainMenuView");
            System.out.println("�ǵ��ư���");
         } else if (e.getActionCommand().equals("�α���")) {
            System.out.println("���̵� " + login.getText());
            System.out.println("��й�ȣ " + password.getPassword());
            System.out.println("�α��� �Ϸ�");
            ChangePanelService.getInstance().changePanel("MultiPlayListView");
         } else if (e.getActionCommand().equals("ȸ������")) {
            new SignUpView(parentFrame, "ȸ������");
            // System.out.println("ȸ������");
         }
      }

   }
}