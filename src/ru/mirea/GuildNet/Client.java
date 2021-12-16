package ru.mirea.GuildNet;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Stack;

class frmClient extends JFrame
{
    JPanel pnlInput = new JPanel();
    JTextField txtPlayer1 = new JTextField(12);
    JTextField txtPlayer2 = new JTextField(12);
    JLabel lblPlayer1 = new JLabel("Игрок 1:");
    JLabel lblPlayer2 = new JLabel("Игрок 2:");
    Font fnt = new Font("Times new roman",Font.BOLD,20);
    JButton btnOK = new JButton("OK");

    frmClient(int id)
    {
        super("GuildNet: Client " + id);

        setSize(300,450);
        setMinimumSize(new Dimension(300, 450));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        pnlInput.setBackground(Color.pink);
        pnlInput.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        lblPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer1.setPreferredSize(new Dimension(200, 25));
        c.gridx = 0; c.gridy = 0;
        c.insets = new Insets(5,5,5,5);
        c.anchor = GridBagConstraints.PAGE_START;
        c.fill = GridBagConstraints.BOTH;

        pnlInput.add(lblPlayer1, c);

        //txtPlayer1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        txtPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 0; c.gridy = 1;
        pnlInput.add(txtPlayer1, c);

        lblPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 0; c.gridy = 2;
        pnlInput.add(lblPlayer2, c);

        //txtPlayer2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        txtPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 0; c.gridy = 3;
        pnlInput.add(txtPlayer2, c);

        //c.weighty = 0.1;
        c.gridx = 0; c.gridy = 4;
        c.anchor = GridBagConstraints.PAGE_END;
        pnlInput.add(btnOK, c);
        add(pnlInput);

        setVisible(true);
    }
}