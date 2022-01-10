  /*
   * accumulatedProduct.java
   *
   * Version: $Id$
   *
   * Revisions: $Log$
   */

import java.math.BigDecimal;
  /**
   * Description - This class works on getting the accumulated product.
   *
   * @author Author name
   * @author Dibyanshu Chatterjee
   * @author Muskan Mall
   */

public class accumulatedProduct implements Runnable {
    static BigDecimal product = new BigDecimal("1.0");
    BigDecimal Result;

    accumulatedProduct(BigDecimal result) {
        this.Result = result;
    }

    @Override
    public void run() {
        synchronized (product) {
            product = product.multiply(this.Result);
        }
    }
}
