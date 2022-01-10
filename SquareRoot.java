  /*
   * SquareRoot.java
   *
   * Version: $Id$
   *
   * Revisions: $Log$
   */

  import java.math.BigDecimal;
  import java.math.RoundingMode;

  /**
   * Description - This class works on finding the square root
   *
   * @author Author name
   * @author Dibyanshu Chatterjee
   * @author Muskan Mall
   */


  public class SquareRoot implements Runnable {
      BigDecimal element;
      int k;
      static BigDecimal Product = new BigDecimal(1);

      SquareRoot(int k) {
          this.element = new BigDecimal(1);
          this.k = k;
      }

      @Override
      public void run() {
          element = element.multiply(new BigDecimal("4.0"));
          element = element.add(new BigDecimal("2.0"));
          element = element.multiply(element);
          element = new BigDecimal("1.0").divide(element, 33, RoundingMode.HALF_UP);
          element = new BigDecimal("1.0").subtract(element);
      }
  }
