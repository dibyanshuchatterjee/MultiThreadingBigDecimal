  /*
   * Start.java
   *
   * Version: $Id$
   *
   * Revisions: $Log$
   */

  import java.math.BigDecimal;

  /**
   * Description - This is the class containing the main method.
   *
   * @author Author name
   * @author Dibyanshu Chatterjee
   * @author Muskan Mall
   */

  public class Start {
      public static void main(String[] args) {
          int ThreadCount = Integer.parseInt(args[0]);
          int upperLimit = Integer.parseInt(args[1]);
          taskManager tasks = new taskManager(ThreadCount, upperLimit);
          BigDecimal finalResult = tasks.dispatcher();
          System.out.println("The result is " + finalResult.floatValue());
      }

  }
