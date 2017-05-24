package caculator;

class Process {
  double temp1, temp2;
  String tfsum1, tfsum2;
  int mark, mark1;
  Process() { //////////////���캯��/////////////////
    clear();
  }

  void clear() {
    temp1 = temp2 = 0;
    mark = mark1 = 0;
    tfsum1 = tfsum2 = "0";
  }

  void input(String s) { /////////////��������//////////////
    if (mark1 == -1) {
      clear();
      if (!s.equalsIgnoreCase(".")) {
        tfsum1 = s;
      }
      else {
        tfsum1 += s;
      }
    }
    else if (mark != 0) {
      if (tfsum2.equalsIgnoreCase("0") && !s.equalsIgnoreCase(".")) {
        tfsum2 = s;
      }
      else if (!s.equalsIgnoreCase(".") ||
               (tfsum2.indexOf(".") < 0 && s.equalsIgnoreCase("."))) {
        tfsum2 += s;
      }
      mark1 = 2;
    }
    else {
      if (tfsum1.equalsIgnoreCase("0") && !s.equalsIgnoreCase(".")) {
        tfsum1 = s;
      }
      else if (!s.equalsIgnoreCase(".") ||
               (tfsum1.indexOf(".") < 0 && s.equalsIgnoreCase("."))) {
        tfsum1 += s;
      }
      mark1 = 1;
    }
    temp1 = Double.parseDouble(tfsum1);
    temp2 = Double.parseDouble(tfsum2);
  }

  void sign(int sign) { //////////////����//////////////
    if (mark1 != 0) {
      mark = sign;
    }
  }

  String sum() { //////////������������/////////////////
    mark1 = -1;
    switch (mark) {
      default:
        break;
      case 1:
        temp1 += temp2;
        break;
      case 2:
        temp1 -= temp2;
        break;
      case 3:
        temp1 *= temp2;
        break;
      case 4:
        if (temp2 != 0) {
          temp1 /= temp2;
        }
        else {
          return "CE";
        }
        break;
    }
    tfsum1 = Double.toString(temp1);
    tfsum2 = Double.toString(temp2);
    if (Double.isInfinite(temp1)) {
      return "CE";
    }
    else {
      return String.valueOf(temp1);
    }
  }

  //////////�����ǰ�Ĳ��������ַ���/////////////////
  String out() {
    if (mark != 0 && mark1 >= 0) {
      return tfsum2;
    }
    else {
      return tfsum1;
    }
  }

  ///////////�˸��////////////////////////////////
  void backSpace() {
    if (mark1 == 1) {
      if (tfsum1.length() <= 1) {
        tfsum1 = "0";
      }
      else {
        tfsum1 = tfsum1.substring(0, tfsum1.length() - 1);
      }
      temp1 = Double.parseDouble(tfsum1);
    }
    if (mark1 == 2) {
      if (tfsum2.length() <= 1) {
        tfsum2 = "0";
      }
      else {
        tfsum2 = tfsum2.substring(0, tfsum2.length() - 1);
      }
      temp2 = Double.parseDouble(tfsum2);
    }
  }

  //////////////////ȡ��//////////////////////
  void setSign() {
    switch (mark1) {
      case -1:
      case 1:
        if (tfsum1.startsWith("-")) {
          tfsum1 = tfsum1.substring(1, tfsum1.length());
        }
        else {
          tfsum1 = "-" + tfsum1;
        }
        break;
      case 2:
        if (tfsum2.startsWith("-")) {
          tfsum2 = tfsum2.substring(1, tfsum2.length());
        }
        else {
          tfsum2 = "-" + tfsum1;
        }
        break;
      default:
        break;
    }
    temp1 = Double.parseDouble(tfsum1);
    temp2 = Double.parseDouble(tfsum2);
  }
}