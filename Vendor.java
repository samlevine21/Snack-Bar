/*
   This class implements a vendor that sells one kind of items.
   A vendor carries out sales transactions.
*/

public class Vendor
{
  // Fields:
  private int price; //in cents
  private int totalDeposited; //in cents
  private int change; //in cents
  private int stock; 

  // Constructor
  // Parameters:
  //    int price of a single item in cents
  //    int number of items to place in stock
  public Vendor(int newPrice, int newStock)
  {
    price = newPrice;
    stock = newStock;
    totalDeposited = 0;
    change = 0;
  }

  // Sets the quantity of items in stock.
  // Parameters:
  //   int number of items to place in stock
  // Return:
  //   None
  public void setStock(int newStock)
  {
    stock = newStock; //new stock in machine
  }

  // Returns the number of items currently in stock.
  // Parameters:
  //   None
  // Return:
  //   int number of items currently in stock
  public int getStock()
  {
    return stock; //returns stock in the machine
  }

  // Adds a specified amount (in cents) to the deposited amount.
  // Parameters:
  //   int number of cents to add to the deposit
  // Return:
  //   None
  public void addMoney(int deposit)
  {
    totalDeposited += deposit; //adds our deposit to the money in machine
  }

  // Returns the currently deposited amount (in cents).
  // Parameters:
  //   None
  // Return:
  //   int number of cents in the current deposit
  public int getDeposit()
  {
    return totalDeposited; //returns amount of money in machine
  }

  // Implements a sale.  If there are items in stock and
  // the deposited amount is greater than or equal to
  // the single item price, then adjusts the stock
  // and calculates and sets change and returns true;
  // otherwise refunds the whole deposit (moves it into change)
  // and returns false.
  // Parameters:
  //   None
  // Return:
  //   boolean successful sale (true) or failure (false)
  public boolean makeSale()
  {
    if (totalDeposited >= price && stock >= 1) { //if we have enough money AND stock
        stock -=1; //removes one from stock
        change = totalDeposited - price; //sets our change
        totalDeposited = 0; //removes the deposited money
        return true;
    }
    else { //if there isn't enough money OR enough stock
        change = totalDeposited; //gives back money (failed sale)
        totalDeposited = 0;
        return false;
    }
  }

  // Returns and zeroes out the amount of change (from the last
  // sale or refund).
  // Parameters:
  //   None
  // Return:
  //   int number of cents in the current change
  public int getChange()
  {
    return change;
  }
}
