  /*
   * taskManager.java
   *
   * Version: $Id$
   *
   * Revisions: $Log$
   */

  import java.math.BigDecimal;
  import java.util.concurrent.ExecutorService;
  import java.util.concurrent.Executors;

  /**
   * Description - This  class manages the functionalities as mentioned in the problem writeup.
   *
   * @author Author name
   * @author Dibyanshu Chatterjee
   * @author Muskan Mall
   */


  public class taskManager {
      int ThreadCount;
      int upperLimit;
      SquareRoot[] squareRootElements;
      BigDecimal product;

      taskManager(int ThreadCount, int upperLimit) {
          this.ThreadCount = ThreadCount;
          this.upperLimit = upperLimit;
          this.product = new BigDecimal("1.0");
          squareRootElements = new SquareRoot[upperLimit];
          for (int index = 0; index < upperLimit; index++) {
              squareRootElements[index] = new SquareRoot(index);
          }
      }

      BigDecimal dispatcher() {
          ExecutorService elementToExecute = Executors.newFixedThreadPool(this.ThreadCount);
          for (int index = 0; index < this.upperLimit; index++) {
              elementToExecute.execute(squareRootElements[index]);
          }
          elementToExecute.shutdown();
          while (!elementToExecute.isTerminated()) {
          }

          ExecutorService executor = Executors.newFixedThreadPool(this.ThreadCount);
          accumulatedProduct[] Accumlator = new accumulatedProduct[this.upperLimit];
          for (int index = 0; index < this.upperLimit; index++) {
              Accumlator[index] = new accumulatedProduct(squareRootElements[index].element);
              executor.execute(Accumlator[index]);
          }
          executor.shutdown();
          while (!executor.isTerminated()) {
          }
          return accumulatedProduct.product;
      }

  }
