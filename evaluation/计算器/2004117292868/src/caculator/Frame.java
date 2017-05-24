package caculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import com.borland.jbcl.layout.*;

public class Frame
    extends JFrame {
  JPanel contentPane;
  /////////////////////////////////////
  Process process = new Process();
  JTextField tfsum = new JTextField();
  JButton btnC = new JButton();
  JButton btnCE = new JButton();
  JButton btnBackSpace = new JButton();
  JButton btn9 = new JButton();
  JButton btn8 = new JButton();
  JButton btn7 = new JButton();
  JButton btndiv = new JButton();
  JButton btnmul = new JButton();
  JButton btnsub = new JButton();
  JButton btnadd = new JButton();
  JButton btn6 = new JButton();
  JButton btn5 = new JButton();
  JButton btn4 = new JButton();
  JButton btn3 = new JButton();
  JButton btn2 = new JButton();
  JButton btn1 = new JButton();
  JButton btn0 = new JButton();
  JButton btnsign = new JButton();
  JButton btnpoint = new JButton();
  Border border1;
  TitledBorder titledBorder1;
  JButton btnEqu = new JButton();
  PaneLayout paneLayout1 = new PaneLayout();

  //Construct the frame
  public Frame() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception {
    contentPane = (JPanel)this.getContentPane();
    this.setSize(300, 500);
    border1 = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new
        Color(231, 255, 241), 2), BorderFactory.createEmptyBorder(0, 0, 0, 99));
    titledBorder1 = new TitledBorder("");
    tfsum.setBackground(Color.lightGray);
    tfsum.setFont(new java.awt.Font("Dialog", 0, 22));
    tfsum.setForeground(Color.red);
    tfsum.setBorder(BorderFactory.createLoweredBevelBorder());
    tfsum.setDebugGraphicsOptions(0);
    tfsum.setToolTipText("");
    tfsum.setCaretColor(Color.black);
    tfsum.setCaretPosition(0);
    tfsum.setDisabledTextColor(Color.red);
    tfsum.setEditable(false);
    tfsum.setSelectedTextColor(Color.black);
    tfsum.setText("0");
    tfsum.setColumns(0);
    tfsum.setHorizontalAlignment(SwingConstants.RIGHT);
    tfsum.setScrollOffset(0);
    contentPane.setLayout(paneLayout1);
    this.setSize(new Dimension(400, 300));
    this.setTitle("Calculator");
    btnC.setBackground(Color.pink);
    btnC.setFont(new java.awt.Font("Dialog", 1, 33));
    btnC.setForeground(new Color(87, 137, 131));
    btnC.setActionCommand("btnC");
    btnC.setText("C");
    btnC.addActionListener(new Frame_btnC_actionAdapter(this));
    btnCE.setBackground(Color.pink);
    btnCE.setFont(new java.awt.Font("Dialog", 1, 33));
    btnCE.setForeground(new Color(87, 137, 131));
    btnCE.setActionCommand("btnCE");
    btnCE.setText("CE");
    btnCE.addActionListener(new Frame_btnCE_actionAdapter(this));
    btnBackSpace.setBackground(Color.pink);
    btnBackSpace.setFont(new java.awt.Font("Dialog", 1, 22));
    btnBackSpace.setForeground(new Color(87, 137, 131));
    btnBackSpace.setActionCommand("btnBackSpace");
    btnBackSpace.setText("BackSpace");
    btnBackSpace.addActionListener(new Frame_btnBackSpace_actionAdapter(this));
    btn9.setBackground(Color.pink);
    btn9.setFont(new java.awt.Font("SansSerif", 0, 22));
    btn9.setForeground(new Color(87, 137, 131));
    btn9.setActionCommand("btn9");
    btn9.setText("9");
    btn9.addActionListener(new Frame_btn9_actionAdapter(this));
    btn8.setBackground(Color.pink);
    btn8.setFont(new java.awt.Font("Dialog", 0, 22));
    btn8.setForeground(new Color(87, 137, 131));
    btn8.setActionCommand("btn8");
    btn8.setText("8");
    btn8.addActionListener(new Frame_btn8_actionAdapter(this));
    btn7.setBackground(Color.pink);
    btn7.setFont(new java.awt.Font("Dialog", 0, 22));
    btn7.setForeground(new Color(87, 137, 131));
    btn7.setActionCommand("btn7");
    btn7.setText("7");
    btn7.addActionListener(new Frame_btn7_actionAdapter(this));
    btndiv.setBackground(Color.pink);
    btndiv.setFont(new java.awt.Font("Dialog", 0, 22));
    btndiv.setForeground(new Color(87, 137, 131));
    btndiv.setActionCommand("btndiv");
    btndiv.setText("/");
    btndiv.addActionListener(new Frame_btndiv_actionAdapter(this));
    btnmul.setBackground(Color.pink);
    btnmul.setFont(new java.awt.Font("Dialog", 0, 22));
    btnmul.setForeground(new Color(87, 137, 131));
    btnmul.setActionCommand("btnmul");
    btnmul.setText("*");
    btnmul.addActionListener(new Frame_btnmul_actionAdapter(this));
    btnsub.setBackground(Color.pink);
    btnsub.setFont(new java.awt.Font("Dialog", 0, 22));
    btnsub.setForeground(new Color(87, 137, 131));
    btnsub.setActionCommand("btnsub");
    btnsub.setText("-");
    btnsub.addActionListener(new Frame_btnsub_actionAdapter(this));
    btnadd.setBackground(Color.pink);
    btnadd.setFont(new java.awt.Font("Dialog", 0, 22));
    btnadd.setForeground(new Color(87, 137, 131));
    btnadd.setActionCommand("btnadd");
    btnadd.setText("+");
    btnadd.addActionListener(new Frame_btnadd_actionAdapter(this));
    btn6.setBackground(Color.pink);
    btn6.setFont(new java.awt.Font("Dialog", 0, 22));
    btn6.setForeground(new Color(87, 137, 131));
    btn6.setActionCommand("btn6");
    btn6.setText("6");
    btn6.addActionListener(new Frame_btn6_actionAdapter(this));
    btn5.setBackground(Color.pink);
    btn5.setFont(new java.awt.Font("Dialog", 0, 22));
    btn5.setForeground(new Color(87, 137, 131));
    btn5.setActionCommand("btn5");
    btn5.setText("5");
    btn5.addActionListener(new Frame_btn5_actionAdapter(this));
    btn4.setBackground(Color.pink);
    btn4.setFont(new java.awt.Font("Dialog", 0, 22));
    btn4.setForeground(new Color(87, 137, 131));
    btn4.setActionCommand("btn4");
    btn4.setText("4");
    btn4.addActionListener(new Frame_btn4_actionAdapter(this));
    btn3.setBackground(Color.pink);
    btn3.setFont(new java.awt.Font("Dialog", 0, 22));
    btn3.setForeground(new Color(87, 137, 131));
    btn3.setActionCommand("btn3");
    btn3.setText("3");
    btn3.addActionListener(new Frame_btn3_actionAdapter(this));
    btn2.setBackground(Color.pink);
    btn2.setFont(new java.awt.Font("Dialog", 0, 22));
    btn2.setForeground(new Color(87, 137, 131));
    btn2.setActionCommand("btn2");
    btn2.setText("2");
    btn2.addActionListener(new Frame_btn2_actionAdapter(this));
    btn1.setBackground(Color.pink);
    btn1.setFont(new java.awt.Font("Dialog", 0, 22));
    btn1.setForeground(new Color(87, 137, 131));
    btn1.setActionCommand("btn1");
    btn1.setText("1");
    btn1.addActionListener(new Frame_btn1_actionAdapter(this));
    btn0.setBackground(Color.pink);
    btn0.setFont(new java.awt.Font("Dialog", 0, 22));
    btn0.setForeground(new Color(87, 137, 131));
    btn0.setActionCommand("btn0");
    btn0.setText("0");
    btn0.addActionListener(new Frame_btn0_actionAdapter(this));
    btnsign.setBackground(Color.pink);
    btnsign.setFont(new java.awt.Font("Dialog", 0, 22));
    btnsign.setForeground(new Color(87, 137, 131));
    btnsign.setActionCommand("btnsign");
    btnsign.setText("+/-");
    btnsign.addActionListener(new Frame_btnsign_actionAdapter(this));
    btnpoint.setBackground(Color.pink);
    btnpoint.setFont(new java.awt.Font("Dialog", 0, 22));
    btnpoint.setForeground(new Color(87, 137, 131));
    btnpoint.setActionCommand("btnpoint");
    btnpoint.setText(".");
    btnpoint.addActionListener(new Frame_btnpoint_actionAdapter(this));
    contentPane.setBackground(UIManager.getColor("TextField.inactiveBackground"));
    contentPane.setOpaque(true);
    btnEqu.setBackground(Color.pink);
    btnEqu.setFont(new java.awt.Font("Dialog", 0, 22));
    btnEqu.setForeground(new Color(94, 137, 137));
    btnEqu.setActionCommand("btnEqu");
    btnEqu.setText("=");
    btnEqu.addActionListener(new Frame_btnEqu_actionAdapter(this));
    contentPane.add(tfsum,
                    new PaneConstraints("tfsum", "tfsum", PaneConstraints.ROOT,
                                        0.5f));
    contentPane.add(btnC,
                    new PaneConstraints("btnC", "tfsum", PaneConstraints.BOTTOM,
                                        0.87333333f));
    contentPane.add(btnEqu,
                    new PaneConstraints("btnEqu", "btnC",
                                        PaneConstraints.BOTTOM, 0.8664122f));
    contentPane.add(btnCE,
                    new PaneConstraints("btnCE", "btnC", PaneConstraints.LEFT,
                                        0.7175f));
    contentPane.add(btnBackSpace,
                    new PaneConstraints("btnBackSpace", "btnCE",
                                        PaneConstraints.LEFT, 0.6445993f));
    contentPane.add(btnadd,
                    new PaneConstraints("btnadd", "btnEqu", PaneConstraints.TOP,
                                        0.78854626f));
    contentPane.add(btnsub,
                    new PaneConstraints("btnsub", "btnadd", PaneConstraints.TOP,
                                        0.74860334f));
    contentPane.add(btnsign,
                    new PaneConstraints("btnsigh", "btnadd",
                                        PaneConstraints.LEFT, 0.46500003f));
    contentPane.add(btnpoint,
                    new PaneConstraints("btnpoint", "btnadd",
                                        PaneConstraints.LEFT, 0.4722222f));
    contentPane.add(btn0,
                    new PaneConstraints("btn0", "btnsigh", PaneConstraints.LEFT,
                                        0.5f));
    contentPane.add(btnmul,
                    new PaneConstraints("btnmul", "btnsub", PaneConstraints.TOP,
                                        0.6641791f));
    contentPane.add(btn3,
                    new PaneConstraints("btn3", "btnsub", PaneConstraints.LEFT,
                                        0.7175f));
    contentPane.add(btn2,
                    new PaneConstraints("btn2", "btn3", PaneConstraints.LEFT,
                                        0.6445993f));
    contentPane.add(btn1,
                    new PaneConstraints("btn1", "btn2", PaneConstraints.LEFT,
                                        0.5081081f));
    contentPane.add(btndiv,
                    new PaneConstraints("btndiv", "btnmul", PaneConstraints.TOP,
                                        0.5232558f));
    contentPane.add(btn6,
                    new PaneConstraints("btn6", "btnmul", PaneConstraints.LEFT,
                                        0.7175f));
    contentPane.add(btn5,
                    new PaneConstraints("btn5", "btn6", PaneConstraints.LEFT,
                                        0.6445993f));
    contentPane.add(btn4,
                    new PaneConstraints("btn4", "btn5", PaneConstraints.LEFT,
                                        0.5081081f));
    contentPane.add(btn9,
                    new PaneConstraints("btn9", "btndiv", PaneConstraints.LEFT,
                                        0.7175f));
    contentPane.add(btn8,
                    new PaneConstraints("btn8", "btn9", PaneConstraints.LEFT,
                                        0.64685315f));
    contentPane.add(btn7,
                    new PaneConstraints("btn7", "btn8", PaneConstraints.LEFT,
                                        0.5027027f));
  }

  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

//////////////----------9-----------------//////////////////
  void btn9_actionPerformed(ActionEvent e) {
    process.input("9");
    tfsum.setText(process.out());
  }

//////////////----------8-----------------//////////////////
  void btn8_actionPerformed(ActionEvent e) {
    process.input("8");
    tfsum.setText(process.out());
  }

//////////////----------7-----------------//////////////////
  void btn7_actionPerformed(ActionEvent e) {
    process.input("7");
    tfsum.setText(process.out());
  }

//////////////----------6-----------------//////////////////
  void btn6_actionPerformed(ActionEvent e) {
    process.input("6");
    tfsum.setText(process.out());
  }

//////////////----------5-----------------//////////////////
  void btn5_actionPerformed(ActionEvent e) {
    process.input("5");
    tfsum.setText(process.out());
  }

//////////////----------4-----------------//////////////////
  void btn4_actionPerformed(ActionEvent e) {
    process.input("4");
    tfsum.setText(process.out());
  }

//////////////----------3-----------------//////////////////
  void btn3_actionPerformed(ActionEvent e) {
    process.input("3");
    tfsum.setText(process.out());
  }

//////////////----------2-----------------//////////////////
  void btn2_actionPerformed(ActionEvent e) {
    process.input("2");
    tfsum.setText(process.out());
  }

//////////////----------1-----------------//////////////////
  void btn1_actionPerformed(ActionEvent e) {
    process.input("1");
    tfsum.setText(process.out());
  }

//////////////----------0-----------------//////////////////
  void btn0_actionPerformed(ActionEvent e) {
    process.input("0");
    tfsum.setText(process.out());
  }

//////////////----------Clear-----------------//////////////////
  void btnC_actionPerformed(ActionEvent e) {
    process.clear();
    tfsum.setText("0");
  }

//////////////----------Div-----------------//////////////////
  void btndiv_actionPerformed(ActionEvent e) {
    process.sign(4);
  }

//////////////----------Add-----------------//////////////////
  void btnadd_actionPerformed(ActionEvent e) {
    process.sign(1);
  }

//////////////----------Sub-----------------//////////////////
  void btnsub_actionPerformed(ActionEvent e) {
    process.sign(2);
  }

//////////////----------Mul-----------------//////////////////
  void btnmul_actionPerformed(ActionEvent e) {
    process.sign(3);
  }

//////////////----------Point-----------------//////////////////
  void btnpoint_actionPerformed(ActionEvent e) {
    process.input(".");
    tfsum.setText(process.out());
  }

//////////////----------Sign-----------------//////////////////
  void btnsign_actionPerformed(ActionEvent e) {
    process.setSign();
    tfsum.setText(process.out());
  }

//////////////----------Equ-----------------//////////////////
  void btnEqu_actionPerformed(ActionEvent e) {
    tfsum.setText(process.sum());
  }

//////////////----------CE-----------------//////////////////
  void btnCE_actionPerformed(ActionEvent e) {
    process.clear();
    tfsum.setText("0");
  }

//////////////----------BackSpqce-----------------//////////////////
  void btnBackSpace_actionPerformed(ActionEvent e) {
    process.backSpace();
    tfsum.setText(process.out());
  }
}

//////////////----------9-----------------//////////////////
class Frame_btn9_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btn9_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btn9_actionPerformed(e);
  }
}

class Frame_btn8_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btn8_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btn8_actionPerformed(e);
  }
}

class Frame_btn7_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btn7_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btn7_actionPerformed(e);
  }
}

class Frame_btn6_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btn6_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btn6_actionPerformed(e);
  }
}

class Frame_btn5_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btn5_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btn5_actionPerformed(e);
  }
}

class Frame_btn4_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btn4_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btn4_actionPerformed(e);
  }
}

class Frame_btn3_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btn3_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btn3_actionPerformed(e);
  }
}

class Frame_btn2_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btn2_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btn2_actionPerformed(e);
  }
}

class Frame_btn1_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btn1_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btn1_actionPerformed(e);
  }
}

class Frame_btn0_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btn0_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btn0_actionPerformed(e);
  }
}

class Frame_btnC_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btnC_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btnC_actionPerformed(e);
  }
}

class Frame_btndiv_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btndiv_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btndiv_actionPerformed(e);
  }
}

class Frame_btnadd_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btnadd_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btnadd_actionPerformed(e);
  }
}

class Frame_btnsub_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btnsub_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btnsub_actionPerformed(e);
  }
}

class Frame_btnmul_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btnmul_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btnmul_actionPerformed(e);
  }
}

class Frame_btnpoint_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btnpoint_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btnpoint_actionPerformed(e);
  }
}

class Frame_btnsign_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btnsign_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btnsign_actionPerformed(e);
  }
}

class Frame_btnEqu_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btnEqu_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btnEqu_actionPerformed(e);
  }
}

class Frame_btnCE_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btnCE_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btnCE_actionPerformed(e);
  }
}

class Frame_btnBackSpace_actionAdapter
    implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_btnBackSpace_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btnBackSpace_actionPerformed(e);
  }
}