import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener{
    
    JFrame frame;
    JTextField textField;
    JButton[] numButtons= new JButton[10];
    JButton[] functiButtons= new JButton[8];
    JButton addButton, subButton,mulButton,divButton;
    JButton decButton, equButton,delButton,clrButton;
    JPanel panel ;

    Font myFont=new Font("Norasi",Font.BOLD,30);
    double num1=0,num2=0, result=0;
    char operator;


    Calculator(){
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField= new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);


        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("Del");
        clrButton=new JButton("Clr");
        
        functiButtons[0]=addButton;
        functiButtons[1]=subButton;
        functiButtons[2]=mulButton;
        functiButtons[3]=divButton;
        functiButtons[4]=decButton;
        functiButtons[5]=equButton;
        functiButtons[6]=delButton;
        functiButtons[7]=clrButton;
       
        for(int i=0;i<8;i++){
            functiButtons[i].addActionListener(this);
            functiButtons[i].setFont(myFont);
            functiButtons[i].setFocusable(false);
        }

        for(int i=0;i<10;i++){
            numButtons[i]= new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);
        }

        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);
        
        panel =new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.BLUE);


        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(functiButtons[0]);

        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(functiButtons[1]);

        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(functiButtons[2]);

        panel.add(functiButtons[4]);
        panel.add(numButtons[0]);
        panel.add(functiButtons[5]);
        panel.add(functiButtons[3]);
       
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        Calculator calc= new Calculator();
    }

    public void actionPerformed(ActionEvent e){

        for(int i=0;i<10;i++){
           if(e.getSource()==numButtons[i]) {
            textField.setText(textField.getText().concat(String.valueOf(i)));
           }
        }

        if(e.getSource()==decButton){
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource()==addButton){
            num1=Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }

        if(e.getSource()==mulButton){
            num1=Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }

        if(e.getSource()==subButton){
            num1=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }

        if(e.getSource()==divButton){
            num1=Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }

        if(e.getSource()==equButton){
            num2=Double.parseDouble(textField.getText());

            switch(operator){
               case '+':
               result=num1+num2;
               break;

               case '-':
               result=num1-num2;
               break;

               case '*':
               result=num1*num2;
               break;

               case '/':
               result=num1/num2;
               break;
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clrButton){
           textField.setText("");
        }

        if(e.getSource()==delButton){
           String sring=textField.getText();
            textField.setText("");
            for(int i=0;i<sring.length()-1;i++){
                textField.setText(textField.getText()+sring.charAt(i));
            }
         }



    }
    
   
}
