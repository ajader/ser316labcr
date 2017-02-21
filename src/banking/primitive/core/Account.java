/**
 * Account Class is an abstract class that implements 
 * Serializable.
 * Has three states an account can be in
 * OPEN, CLOSED, and OVERDRAWN
 * Has abstract methods that can get the current balance,
 * add to the account or deposit from the account
 * 
 */
package banking.primitive.core;

public abstract class Account implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    protected enum State {
        OPEN, CLOSED, OVERDRAWN
    };

    private float balance = 0.0F;
    private String name;
    private State state;

    protected Account(String n) {
        name = n;
        state = State.OPEN;
    }

    protected Account(String n, float b) {
        this(n); 
        balance = b;
    }

    /**
     * @return balance in the Account
     */
    public final float getBalance() {
        return balance;
    }
    
    /**
     * @return name of the Account
     */
    public final String getName() {
        return name;
    }

    protected final State getState() {
        return state;
    }
    
    /**
     * @return either "Checking" or "Savings"
     */
    public abstract String getType();
    
    protected final void setState(State s) {
        state = s;
    }
    
    /**
     * Adds money to an account. May not be done if the account is CLOSED
     * 
     * @param parameter
     *            amount is a deposit and must be > 0
     * @return true if the deposit was successful, false if not due to amount or
     *         invalid state
     */

    public abstract String getType();

    protected final State getState() {
        return state;
    }

    protected final void setState(State s) {
        state = s;
    }
    public abstract boolean deposit(float amount);

    /**
     * Takes money out of an account. If the balance falls below 0 then the
     * account is moved to an OVERDRAWN state
     * 
     * @param parameter
     *            amount is a withdrawal and must be > 0
     * @return true if the deposit was successful, false if not due to amount or
     *         invalid state
     */
    public abstract boolean withdraw(float amount);

    public String toString() {
        return "Account " + name + " has $" + balance + "and is " + getState()
                + "\n";
    }
}
