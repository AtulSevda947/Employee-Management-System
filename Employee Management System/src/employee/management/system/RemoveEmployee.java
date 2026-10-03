package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice choiceEmpid;
    JButton delete , back;
    RemoveEmployee(){

        JLabel label = new JLabel("Employee Id");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        add(label);

        choiceEmpid = new Choice();
        choiceEmpid.setBounds(200,50,150,30);
        add(choiceEmpid);

        try{
         Conn con = new Conn();
            ResultSet resultSet = con.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choiceEmpid.add(resultSet.getString("empId"));

            }
        }catch(Exception e) {
           e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name ");
        labelName.setBounds(50,100,100,30);
        labelName.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelName);


        JLabel textName = new JLabel("Name ");
        textName.setBounds(200,100,100,30);
        textName.setFont(new Font("Tahoma",Font.BOLD,15));
        add(textName);


        JLabel labelPhone = new JLabel("Name ");
        labelPhone.setBounds(50,150,100,30);
        labelPhone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelPhone);


        JLabel textPhone = new JLabel("Name ");
        textPhone.setBounds(200,150,100,30);
        textPhone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(textPhone);

        JLabel labelEmail = new JLabel("Name ");
        labelEmail.setBounds(50,200,100,30);
        labelEmail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelEmail);


        JLabel textEmail = new JLabel("Name ");
        textEmail.setBounds(200,200,100,30);
        textEmail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(textEmail);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee where empId ='"+choiceEmpid.getSelectedItem()+"'");
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        choiceEmpid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from employee where empId ='"+choiceEmpid.getSelectedItem()+"'");
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });



        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700,80,200,200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(1000,630,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(0,0,1000,630);
        add(imgg);

        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);


    }




    public static void main(String[] args){
        new RemoveEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== delete){
            try {
                Conn c = new Conn();
               String query = "delete from employee where empId = '"+choiceEmpid.getSelectedItem()+"'";
               c.statement.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Employee Delete Successfully...");
               new Home();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new Home();
        }
    }
}
