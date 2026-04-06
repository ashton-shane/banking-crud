import AccountsList from "../components/AccountsList"

const DisplayAccounts = () => {

    const accounts = [
        { id: 1, balance: 1500.75, interestRate: 1.5 },
        { id: 2, balance: 8920.0, interestRate: 2.0 },
        { id: 3, balance: 340.4, interestRate: 1.2 },
    ];

    return (
        <AccountsList accounts={ accounts }/>
    )
}

export default DisplayAccounts