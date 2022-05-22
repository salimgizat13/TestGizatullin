import java.io.IOException;
import java.util.Scanner;

public class Namaste {
 public static void main(String[] args) {

  System.out.println("Input (Вâîäèòå ÷èñëà îò 1(I) äî 10(X) ÷åðåç ïðîáåë):");
  Scanner number = new Scanner(System.in);
  Numbers num = new Numbers();

  String[] array = number.nextLine().split(" ");
  String num1 = array[0];
  String operationS = array[1];
  String num2 = array[2];
  if (array.length != 3) {
   System.out.println("throws Exception //ò.ê. ôîðìàò ìàòåìàòè÷åñêîé îïåðàöèè íå óäîâëåòâîðÿåò çàäàíèþ - äâà îïåðàíäà è îäèí îïåðàòîð (+, -, /, *)");
  } else {
   num.num1 = num1;
   num.operation = operationS.charAt(0);
   num.num2 = num2;


   num.existR();       // êîíâåðòàöèÿ â int äëÿ ðèìñêèõ
   num.convertIntRo();
   num.existR2();
   num.convertIntRo2();


   num.exist();          // êîíâåðòàöèÿ â int äëÿ àðàáñêèõ
   num.convertIntAr();
   num.exist2();
   num.convertIntAr2();


   if (num.exist() && num.exist2()) {
    System.out.println(num.calculation());
   } else if (num.exist() && num.existR2()) {          // ïîñìîòðè ëîãè÷åñêèå îïåðàòîðû!!!!
    System.out.println("throws Exception //ò.ê. èñïîëüçóþòñÿ îäíîâðåìåííî ðàçíûå ñèñòåìû ñ÷èñëåíèÿ");
   } else if (num.exist2() && num.existR()) {
    System.out.println("throws Exception //ò.ê. èñïîëüçóþòñÿ îäíîâðåìåííî ðàçíûå ñèñòåìû ñ÷èñëåíèÿ");
   } else if (num.existR() && num.existR2()) {
    num.calculation();
    try {
     num.res();
     System.out.println(num.res());
    } catch (ArrayIndexOutOfBoundsException e) {
     System.out.println("throws Exception //ò.ê. â ðèìñêîé ñèñòåìå íåò îòðèöàòåëüíûõ ÷èñåë è íóëÿ");
    }

   }
  }
 }
}
class Numbers {


 String num1;
 String num2;

 char operation;

 int numInt1;
 int numInt2;


 int result;

 RomanNumeral resultRo;

 String[] numArabic = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
 String[] numRoman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

 boolean exist() {
  for (String s : numArabic) {
   if (num1.equals(s)) {
    return true;
   }
  }
  return false;
 }

 boolean exist2() {
  for (String s : numArabic) {
   if (num2.equals(s)) {
    return true;
   }
  }
  return false;
 }

 int convertIntAr() {
  if (exist()) {
   numInt1 = Integer.parseInt(num1);
  }
  return numInt1;
 }

 int convertIntAr2() {
  if (exist2()) {
   numInt2 = Integer.parseInt(num2);
  }
  return numInt2;
 }

 boolean existR() {
  for (String v : numRoman) {
   if (num1.equals(v)) {
    return true;
   }
  }
  return false;
 }

 boolean existR2() {
  for (String v : numRoman) {
   if (num2.equals(v)) {
    return true;
   }
  }
  return false;
 }

 int convertIntRo() {
  if (existR()) {
   RomanNumeral one = RomanNumeral.valueOf(num1);
   numInt1 = one.getArabic();
  }
  return numInt1;
 }

 int convertIntRo2() {
  if (existR2()) {
   RomanNumeral two = RomanNumeral.valueOf(num2);
   numInt2 = two.getArabic();
  }
  return numInt2;
 }


 int calculation() {
   switch (operation) {
    case '+':
     result = numInt1 + numInt2;
     break;
    case '-':
     result = numInt1 - numInt2;
     break;
    case '*':
     result = numInt1 * numInt2;
     break;
    case '/':
     result = numInt1 / numInt2;
     break;
    default:
     System.out.print("Âû óêàçàëè íåâåðíóþ îïåðàöèþ");
   }
  return result;
 }


 RomanNumeral res() {
  resultRo = RomanNumeral.values()[result - 1];
  return resultRo;
 }
}


