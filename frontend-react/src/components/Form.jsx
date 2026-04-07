import CustomersList from "./CustomersList";
import AccountsList from "./AccountsList";

export default function Form() {
    const SAMPLE_ACCOUNTS = [
        { id: 1, balance: 5000.0, interestRate: 1 },
        { id: 2, balance: 10000.0, interestRate: 2 },
        { id: 3, balance: 15000.0, interestRate: 1 },
        { id: 4, balance: 20000.0, interestRate: 2 },
        { id: 5, balance: 25000.0, interestRate: 1 },
        { id: 6, balance: 30000.0, interestRate: 2 },
        { id: 7, balance: 35000.0, interestRate: 1 },
        { id: 8, balance: 40000.0, interestRate: 2 },
    ];
    
    const SAMPLE_CUSTOMERS = [
      { id: 1, name: "Ash", account_id: 1 },
      { id: 2, name: "Ash", account_id:  2 },
      { id: 3, name: "Ash", account_id:  1 },
      { id: 4, name: "Ash", account_id:  2 },
      { id: 5, name: "Ash", account_id: 1 },
      { id: 6, name: "Ash", account_id: 3},
      { id: 7, name: "Ash", account_id:  1 },
      { id: 8, name: "Ash", account_id:  2 },
    ];

    // if click view Accounts, it will display accounts
    // if click view Customers, it will display customers
    return (
        <div>
            <AccountsList accounts={ SAMPLE_ACCOUNTS } />;
            <CustomersList customers={ SAMPLE_CUSTOMERS } />;
        </div>
    )
}
